package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.commands.wiredAPI.Motor;

public class Intake extends SubsystemBase {
    private static Motor ballLoad;
    private static Motor intake;
    public Intake() {
        ballLoad = new Motor("BallLoader");
        intake = new Motor("IntakeMotor");
    }

    public void teleIntake() {
        if (OI.getOpB()) {
            intake.run(-0.25);
        } else {
            intake.run(0);
        }
        if (OI.getOpX()) {
            ballLoad.run(0.5);
        } else {
            ballLoad.run(0);
        }
    }
}
