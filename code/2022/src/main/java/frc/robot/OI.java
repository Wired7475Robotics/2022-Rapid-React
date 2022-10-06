package frc.robot;

import frc.robot.commands.wiredAPI.Motor;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;


public class OI {
    
    private static String filePath = Filesystem.getDeployDirectory().getPath();
    private static XboxController driveController;
    private static XboxController opController;
    private static double DEADZONE = 0.05;
    private static double TRIGGER_THRESH = 0.5;
    public static int RIGHT = 0;
    public static int LEFT = 1;

    public OI() {
        Motor.setMotorConfigPath(filePath);
        driveController = new XboxController(0);
        opController = new XboxController(1);
    }

    public static boolean getDriveBumper(int side) {
        if(side == RIGHT)
            return driveController.getRightBumper();
        else if (side == LEFT)
            return driveController.getLeftBumper();
        else
            return false;
    }

    public static boolean getDriveTrigger(int side) {
        if(side == RIGHT)
            return driveController.getRightTriggerAxis() > TRIGGER_THRESH;
        else if (side == LEFT)
            return driveController.getLeftTriggerAxis() > TRIGGER_THRESH;
        else
            return false;
    }

    public static boolean getOpBumper(int side) {
        if(side == RIGHT)
            return opController.getRightBumper();
        else if (side == LEFT)
            return opController.getLeftBumper();
        else
            return false;
    }

    public static boolean getOpTrigger(int side) {
        if(side == RIGHT)
            return opController.getRightTriggerAxis() > TRIGGER_THRESH;
        else if (side == LEFT)
            return opController.getLeftTriggerAxis() > TRIGGER_THRESH;
        else
            return false;
    }

    public static double getDriveLeftStick() {
        return (driveController.getLeftX() < DEADZONE) ? 0 : driveController.getLeftX(); 
    }


    public static double getDriveRightStick() {
        return (driveController.getRightY() < DEADZONE) ? 0 : driveController.getRightY(); 
    }

    public static double getOpLeftStick() {
        return (opController.getLeftX() < DEADZONE) ? 0 : opController.getLeftX(); 
    }

    public static double getOpRightStick() {
        return (opController.getRightY() < DEADZONE) ? 0 : opController.getRightY(); 
    } 
}
 