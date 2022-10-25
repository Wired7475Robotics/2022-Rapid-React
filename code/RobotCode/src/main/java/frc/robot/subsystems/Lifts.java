package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.commands.wiredAPI.Motor;

public class Lifts extends SubsystemBase {
    
    public static Motor leftPulleyMotor1;
    public static Motor leftPulleyMotor2;
    public static Motor rightPulleyMotor1;
    public static Motor rightPulleyMotor2;



    public Lifts(){
        leftPulleyMotor1 = new Motor("LeftPulleyMotor1");
        leftPulleyMotor2 = new Motor("LeftPulleyMotor2");
        rightPulleyMotor1 = new Motor("RightPulleyMotor1");
        rightPulleyMotor2 = new Motor("RightPulleyMotor2");

    }

    public void teleLifts() {

        if(OI.getOpLeftStick(OI.Y) != 0)

            leftPulleyMotor2.run(OI.getOpLeftStick(OI.Y));
            rightPulleyMotor1.run(OI.getOpLeftStick(OI.Y));
            rightPulleyMotor2.run(OI.getOpLeftStick(OI.Y));
            leftPulleyMotor1.run(-OI.getOpLeftStick(OI.Y));
    } 

}
