package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.wiredAPI.Motor;
import frc.robot.subsystems.Pneumatics;



public class systems {
    //declare path to motor configs
    static String filePath = Filesystem.getDeployDirectory().getPath();
    //declare motor objects to make them accessible to other classes
    public static Motor ballLoad;
    public static Motor intake;
    public static WPI_VictorSPX leftDrive1 = new WPI_VictorSPX(9);
    public static WPI_VictorSPX leftDrive2 = new WPI_VictorSPX(13);
    public static WPI_TalonSRX rightDrive1 = new WPI_TalonSRX(14);
    public static WPI_TalonSRX rightDrive2 = new WPI_TalonSRX(15);
    public static Motor leftPulleyMotor1;
    public static Motor leftPulleyMotor2;
    public static Motor rightPulleyMotor1;
    public static Motor rightPulleyMotor2;
    public static Motor leftLift;
    public static Motor rightLift;
    public static Solenoid liftPNU = Pneumatics.Lifts;
    public static Motor shooter;
    
    /*
     * This method is called in Controllers.java to initialize all motors
     * /!\ This method must be called before  using any variables from this class /!\
     */
    public static void init(){
        //initialize motor configs
        Motor.setMotorConfigPath(filePath);
        ballLoad = new Motor("BallLoader");
        intake = new Motor("IntakeMotor");
        leftPulleyMotor1 = new Motor("LeftPulleyMotor1");
        leftPulleyMotor2 = new Motor("LeftPulleyMotor2");
        rightPulleyMotor1 = new Motor("RightPulleyMotor1");
        rightPulleyMotor2 = new Motor("RightPulleyMotor2");
        leftLift = new Motor("LeftLiftMotor");
        rightLift = new Motor("RightLiftMotor");
        shooter = new Motor("ShooterMotor");
        
    }
}
