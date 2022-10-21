package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.commands.wiredAPI.Motor;

public class Lifts extends SubsystemBase {
    
    public static Motor leftPulleyMotor1;
    public static Motor leftPulleyMotor2;
    public static Motor rightPulleyMotor1;
    public static Motor rightPulleyMotor2;
    public static Motor leftLift;
    public static Motor rightLift;
    private static double Idle;

    public Lifts(){
        leftPulleyMotor1 = new Motor("LeftPulleyMotor1");
        leftPulleyMotor2 = new Motor("LeftPulleyMotor2");
        rightPulleyMotor1 = new Motor("RightPulleyMotor1");
        rightPulleyMotor2 = new Motor("RightPulleyMotor2");
        leftLift = new Motor("LeftLiftMotor");
        rightLift = new Motor("RightLiftMotor");
        Idle = 0.1;
    }

    public void teleLifts() {
        if (OI.getOpDpad(OI.UP)) {
            leftLift.run(1);
            rightLift.run(1);
        } else if (OI.getOpDpad(OI.DOWN)) {
            leftLift.run(-1);
            rightLift.run(-1);
        } else {
            leftLift.run(0);
            rightLift.run(0);
        }
        if(OI.getOpLeftStick(OI.Y) != 0){
            leftPulleyMotor1.run(OI.getOpLeftStick(OI.Y));
            leftPulleyMotor2.run(-OI.getOpLeftStick(OI.Y));
            rightPulleyMotor1.run(OI.getOpLeftStick(OI.Y));
            rightPulleyMotor2.run(OI.getOpLeftStick(OI.Y));
        } else if (OI.getOpY()){
            leftPulleyMotor1.run(Idle);
            leftPulleyMotor2.run(-Idle);
            rightPulleyMotor1.run(Idle);
            rightPulleyMotor2.run(Idle);
        } else {
            leftPulleyMotor1.run(0);
            leftPulleyMotor2.run(0);
            rightPulleyMotor1.run(0);
            rightPulleyMotor2.run(0);  
        }



    } 

}
