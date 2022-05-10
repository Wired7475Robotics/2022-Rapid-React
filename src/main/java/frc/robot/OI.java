package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {

public static XboxController xbox = new XboxController(Constants.XBOX_OP);
public static XboxController drive = new XboxController(Constants.XBOX_DRIVE);
public static double deadzone = 0.1;

    public static double getX() {
        return Math.abs(drive.getLeftX()) < deadzone ? 0.0 : xbox.getLeftX();
    }

    public static double getY() {
        return Math.abs(drive.getRightY()) < deadzone ? 0.0 : xbox.getRightY();
    }

    public static boolean getAButton() {
        return xbox.getAButton();
    }

    public static boolean getBButton() {
        return xbox.getBButton();
    }

    public static boolean getXButton() {
        return xbox.getXButton();
    }

    public static boolean getYButton() {
        return xbox.getYButton();
    }

    public static boolean getBumperL() {
        return xbox.getLeftBumper();
    }

    public static boolean getBumperR() {
        return xbox.getRightBumper();
    }

    public static double getTriggerL() {
        return xbox.getLeftTriggerAxis();
    }

    public static double getTriggerR() {
        return xbox.getRightTriggerAxis();
    }

}