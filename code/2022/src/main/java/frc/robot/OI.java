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
    public static int UP = 2;
    public static int DOWN = 3;
    public static int X = 4;
    public static int Y = 5;

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

    public static double getDriveLeftStick(int axis) {
        if( axis == Y )
            return (driveController.getRightY() > DEADZONE || driveController.getLeftY() < -DEADZONE) ? 0 : driveController.getLeftY();
        else if ( axis == X)
            return (driveController.getLeftX() > DEADZONE || driveController.getLeftX() > -DEADZONE) ? 0 : driveController.getRightX();
        else 
            return 0;
    }


    public static double getDriveRightStick(int axis) {
        if( axis == Y )
        return (driveController.getRightY() > DEADZONE || driveController.getRightY() < -DEADZONE) ? driveController.getRightY() : 0 ;
    else if ( axis == X)
        return (driveController.getRightX() > DEADZONE || driveController.getRightX() < -DEADZONE) ? driveController.getRightX() : 0 ;
    else 
        return 0;
    }

    public static double getOpLeftStick(int axis) {
        if( axis == Y )
            return (opController.getLeftY() > DEADZONE || opController.getLeftY() < -DEADZONE) ? opController.getLeftY() : 0 ;
        else if ( axis == X)
            return (opController.getLeftX() > DEADZONE || opController.getLeftX() < -DEADZONE) ?  opController.getLeftX() : 0 ;
        else 
            return 0;
    }

    public static double getOpRightStick(int axis) {
        if( axis == Y )
            return (opController.getRightY() > DEADZONE || opController.getRightY() < -DEADZONE) ? opController.getRightY() : 0 ;
        else if ( axis == X)
            return (opController.getRightX() > DEADZONE || opController.getRightX() < -DEADZONE) ? opController.getRightX() : 0 ;
        else 
            return 0;
    } 

    public static boolean getOpX(){
        return (opController.getXButton());
    }

    public static boolean getDriveX(){
        return (driveController.getXButton());
    }

    public static boolean getOpY(){
        return (opController.getYButton());
    }

    public static boolean getDriveY(){
        return (driveController.getXButton());
    }

    public static boolean getOpA(){
        return (opController.getAButton());
    }

    public static boolean getDriveA(){
        return (driveController.getAButton());
    }

    public static boolean getOpB(){
        return (opController.getBButton());
    }

    public static boolean getDriveB(){
        return (driveController.getBButton());
    }

    public static boolean getOpDpad(int direction) {
        if (direction == 0)
            return  (((opController.getPOV() < 135) && (opController.getPOV() < 45 )) && opController.getPOV() != -1);
        else if(direction == 1)
            return (((opController.getPOV() < 315) && (opController.getPOV() > 225 )) && opController.getPOV() != -1);
        else if(direction == 2)
            return (((opController.getPOV() < 45) || (opController.getPOV()>315)) && opController.getPOV() != -1);
        else if(direction == 3)
            return (((opController.getPOV() > 135) && (opController.getPOV() < 225 )) && opController.getPOV() != -1);
        else{
            return false;
        }    
    }
}
 