package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.commands.wiredAPI.Motor;

public class Shooter extends SubsystemBase {
    int idleTimer;
    boolean shooterIdleIsActive;
    int idleCooldown;
    private static Motor shooter;
    public Shooter() {
        
        shooter = new Motor("ShooterMotor");
        
    }



    public void teleShooter(){
        
        if(OI.getOpA())
            shooter.run(1);
        else 
            shooter.run(0);
        
    }



}
