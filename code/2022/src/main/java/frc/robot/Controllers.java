package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ControllersCommand;
import frc.robot.commands.systems;
import frc.robot.commands.wiredAPI.Motor;


public class Controllers extends SubsystemBase{
    //Declare Controller and other common Objects
    static XboxController driveController = new XboxController(0);
    static XboxController opController = new XboxController(1);
    static int shooterTimer;
    static double xSpeed;
    static double zRotation;
    static MotorControllerGroup m_leftDrive;
    static MotorControllerGroup m_rightDrive;
    static DifferentialDrive drivetrain;
    private static boolean shooterIdleIsActive = false;
    private static double DEADZONE = 0.05;
    public Controllers() {
        driveController = new XboxController(0);
        opController = new XboxController(1);
        shooterTimer = 0;
        m_leftDrive = new MotorControllerGroup(systems.leftDrive1,systems.leftDrive2);
        m_rightDrive = new MotorControllerGroup(systems.rightDrive1, systems.rightDrive2);
        drivetrain = new DifferentialDrive(m_leftDrive,m_rightDrive);
        shooterTimer = 0;
    }
    private static void driveControllerBind(){
        //declare drive controller buttons

        boolean rightBumper = driveController.getRightBumper();
        boolean leftBumper = driveController.getLeftBumper();
        boolean rightTrigger = driveController.getRightTriggerAxis() > 0.5;
        double leftStick = driveController.getLeftX();
        double rightStick = driveController.getRightY();


        //Drive Logic
        leftStick = (leftStick < DEADZONE) ? 0 : leftStick;
        rightStick = (rightStick < DEADZONE) ? 0 : rightStick;        
        if (rightBumper){
            xSpeed = leftStick;
            zRotation = rightStick;
        } else if (leftBumper){
            xSpeed = leftStick*0.3;
            zRotation = rightStick*0.3;
        } else if (rightTrigger){
            xSpeed = leftStick*0.3;
            zRotation = rightStick*0.1;
        }  else {
            xSpeed = leftStick*0.5;
            zRotation = rightStick*0.5;
        }

        //Drive output
        System.out.println(xSpeed + ":" + zRotation);
        drivetrain.arcadeDrive(xSpeed, zRotation);


    }
    private static void opControllerBind(){
        //declare opController buttons
        boolean y = opController.getYButton();
        boolean b = opController.getBButton();
        boolean a = opController.getAButton();
        boolean x = opController.getXButton();
        double rightStick = opController.getRightX();
        double leftTrigger = opController.getLeftTriggerAxis();
        boolean dpadUp = (((opController.getPOV() < 45) | (opController.getPOV()>315)) && opController.getPOV() != -1);
        boolean dpadDown = (((opController.getPOV() > 135) && (opController.getPOV() < 225 )) && opController.getPOV() != -1);

        //Shooter Idle Logic
        if (y && shooterIdleIsActive == false && shooterTimer > 50) {
            shooterIdleIsActive = true;
            shooterTimer = 0;
        } else if (y && shooterIdleIsActive && shooterTimer > 50){
            shooterIdleIsActive = false;
            shooterTimer = 0;
        } else {
            shooterTimer++;
        }

        // Intake Logic
        if (b) {
            systems.intake.run(-0.25);
        } else {
            systems.intake.run(0);
        }
        
        //Shooter Logic
        if (a) {
            systems.shooter.run(1);
        } else if (shooterIdleIsActive) {
            systems.shooter.run(0.15);
        } else {
            systems.shooter.run(0);
        }

        if (x) {
            systems.ballLoad.run(0.5);
        } else {
            systems.ballLoad.run(0);
        }

        //Lifts (MiniCIM) Logic
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

        //Pneumatics Logic
        if (leftTrigger > 0.1) {
            systems.liftPNU.set(true);
        } else {
            systems.liftPNU.set(false);
        }

        //Pulley Logic
        if (dpadUp){
            systems.leftPulleyMotor1.run(0.25);
            systems.leftPulleyMotor2.run(-0.25);
            systems.rightPulleyMotor1.run(-0.25);
            systems.rightPulleyMotor2.run(-0.25);
        } else if(dpadDown) {
            systems.leftPulleyMotor1.run(-0.25);
            systems.leftPulleyMotor2.run(0.25);
            systems.rightPulleyMotor1.run(0.25);
            systems.rightPulleyMotor2.run(0.25);
        } else {
            systems.leftPulleyMotor1.run(0);
            systems.leftPulleyMotor2.run(0);
            systems.rightPulleyMotor1.run(0);
            systems.rightPulleyMotor2.run(0);
        }

    }
    public static void listen(){
        //Perform Button Bindings
        driveControllerBind();
        opControllerBind();
        drivetrain.feed();
    }
}
