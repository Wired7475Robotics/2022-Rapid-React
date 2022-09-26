package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.systems;

public class Controllers {
    //TODO: Get controller port numbers for controllers
    //Declare Controller Objects
    XboxController driveController = new XboxController(0);
    XboxController opController = new XboxController(1);
    
    private void driveControllerBind(){
        String mode = "normal";
        boolean rightBumber = driveController.getRightBumper();
    }
    private void opControllerBind(){
        boolean shooterIdleIsActive = true;
        boolean y = opController.getYButtonPressed();
        boolean b = opController.getBButton();
        boolean a = opController.getAButton();
        boolean x = opController.getXButton();
        double rightStick = opController.getRightY();
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
