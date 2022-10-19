package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;

public class DriveTrain extends SubsystemBase{
    private static WPI_VictorSPX leftDrive1;
    private static WPI_VictorSPX leftDrive2;
    private static WPI_TalonSRX rightDrive1;
    private static WPI_TalonSRX rightDrive2;
    private static double xSpeed;
    private static double zRotation;
    private static MotorControllerGroup m_leftDrive;
    private static MotorControllerGroup m_rightDrive;
    private static DifferentialDrive drivetrain;
    private static double MED_SPEED_COEFF = 0.6;
    private static double LOW_SPEED_COEFF = 0.4;
    private static double HIGH_SPEED_COEFF = 0.7;

    public DriveTrain() {
        leftDrive1 = new WPI_VictorSPX(9);
        leftDrive2 = new WPI_VictorSPX(13);
        rightDrive1 = new WPI_TalonSRX(14);
        rightDrive2 = new WPI_TalonSRX(15);

        m_leftDrive = new MotorControllerGroup(leftDrive1, leftDrive2);
        m_rightDrive = new MotorControllerGroup(rightDrive1, rightDrive2);
        drivetrain = new DifferentialDrive(m_leftDrive,m_rightDrive);
    }

    public void teleDrive() {
        if (OI.getDriveBumper(OI.RIGHT)){
            xSpeed = OI.getDriveRightStick(OI.X);
            zRotation = OI.getDriveLeftStick(OI.Y);
        } else if (OI.getDriveBumper(OI.LEFT)){
            xSpeed = OI.getDriveRightStick(OI.X) * MED_SPEED_COEFF;
            zRotation = OI.getDriveLeftStick(OI.Y) * MED_SPEED_COEFF;
        } else if (OI.getDriveTrigger(OI.RIGHT)){
            xSpeed = OI.getDriveRightStick(OI.X) *MED_SPEED_COEFF;
            zRotation = OI.getDriveLeftStick(OI.Y) * LOW_SPEED_COEFF;
        }  else {
            xSpeed = OI.getDriveRightStick(OI.X) * HIGH_SPEED_COEFF;
            zRotation = OI.getDriveLeftStick(OI.Y) * HIGH_SPEED_COEFF;
        }


        drivetrain.arcadeDrive(-xSpeed, zRotation);
        drivetrain.feed();
    }
}
