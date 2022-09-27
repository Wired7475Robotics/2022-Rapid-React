package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.systems;
import frc.robot.commands.wiredAPI.Motor;

public class Controllers {
    //TODO: Get controller port numbers for controllers
    //Declare Controller Objects
    XboxController driveController = new XboxController(0);
    XboxController opController = new XboxController(1);
    
    private void driveControllerBind(){
        //declare drive controller buttons
        String mode = "normal";
        boolean rightBumper = driveController.getRightBumper();
        boolean leftBumper = driveController.getLeftBumper();
        boolean rightTrigger = driveController.getRightTriggerAxis() > 0.5;
        double leftStick = driveController.getLeftX();
        double rightStick = driveController.getRightY();

        // set drive mode
        if (rightBumper){
            mode = "speed";
        } else if (leftBumper){
            mode = "precision";
        } else if (rightTrigger){
            mode = "aim";
        }  else {
            mode = "normal";
        }

        //motor logic
        if (mode == "normal"){
            Motor.runSame(leftStick, systems.leftDrive1, systems.leftDrive2, systems.rightDrive1, systems.rightDrive2);
        } else if (mode == "precision"){
            Motor.runSame(leftStick/2, systems.leftDrive1, systems.leftDrive2, systems.rightDrive1, systems.rightDrive2);
        } else if (mode == "speed"){
            Motor.runSame(leftStick, systems.leftDrive1, systems.leftDrive2, systems.rightDrive1, systems.rightDrive2);
        } else if (mode == "aim"){
            Motor.runSame(leftStick/2, systems.leftDrive1, systems.leftDrive2, systems.rightDrive1, systems.rightDrive2);
        }
        


    }
    private void opControllerBind(){
        //declare opController buttons
        boolean shooterIdleIsActive = true;
        boolean y = opController.getYButtonPressed();
        boolean b = opController.getBButton();
        boolean a = opController.getAButton();
        boolean x = opController.getXButton();
        double rightStick = opController.getRightX();
        double leftTrigger = opController.getLeftTriggerAxis();

        if (y) {
            shooterIdleIsActive = !shooterIdleIsActive;
        }
        
        if (b) {
            systems.intake.run(1);
        } else {
            systems.intake.run(0);
        }
        
        if (a) {
            systems.shooter.run(1);
        } else if (shooterIdleIsActive) {
            systems.shooter.run(0.2);
        } else {
            systems.shooter.run(0);
        }

        if (x) {
            systems.ballLoad.run(1);
        } else {
            systems.ballLoad.run(0);
        }

        if (rightStick > 0.1) {
            systems.leftLift.run(rightStick);
            systems.rightLift.run(rightStick);
        } else if (rightStick < -0.1) {
            systems.leftLift.run(rightStick);
            systems.rightLift.run(rightStick);
        } else {
            systems.leftLift.run(0);
            systems.rightLift.run(0);
        }

        if (leftTrigger > 0.1) {
            systems.liftPNU.set(true);
        } else {
            systems.liftPNU.set(false);
        }

    }
    public void listen(){
        systems.init();
        driveControllerBind();
        opControllerBind();
    }
}
