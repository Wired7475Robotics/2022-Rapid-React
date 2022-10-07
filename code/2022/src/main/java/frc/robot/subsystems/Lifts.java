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

    public Lifts(){
        leftPulleyMotor1 = new Motor("LeftPulleyMotor1");
        leftPulleyMotor2 = new Motor("LeftPulleyMotor2");
        rightPulleyMotor1 = new Motor("RightPulleyMotor1");
        rightPulleyMotor2 = new Motor("RightPulleyMotor2");
        leftLift = new Motor("LeftLiftMotor");
        rightLift = new Motor("RightLiftMotor");
    }

    public void teleLifts() {
        if (OI.getOpRightStick() > 0.1) {
            leftLift.run(OI.getOpRightStick());
            rightLift.run(OI.getOpRightStick());
        } else if (OI.getOpRightStick() < -0.1) {
            leftLift.run(OI.getOpRightStick());
            rightLift.run(OI.getOpRightStick());
        } else {
            leftLift.run(0);
            rightLift.run(0);
        }

        if (OI.getOpDpad(OI.UP)){
            leftPulleyMotor1.run(0.25);
            leftPulleyMotor2.run(-0.25);
            rightPulleyMotor1.run(-0.25);
            rightPulleyMotor2.run(-0.25);
        } else if(OI.getOpDpad(OI.DOWN)) {
            leftPulleyMotor1.run(-0.25);
            leftPulleyMotor2.run(0.25);
            rightPulleyMotor1.run(0.25);
            rightPulleyMotor2.run(0.25);
        } else {
            leftPulleyMotor1.run(0);
            leftPulleyMotor2.run(0);
            rightPulleyMotor1.run(0);
            rightPulleyMotor2.run(0);
        }
    }

}
