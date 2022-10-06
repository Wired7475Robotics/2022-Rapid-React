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
        idleTimer = 0;
        shooterIdleIsActive = false;
        idleCooldown = 50;
        shooter = new Motor("ShooterMotor");
        
    }

    private boolean IdleTimer() {
        if(idleTimer > idleCooldown)
            return true;
         else 
            idleTimer++;
            return false;
    }

    public void idle() {
        if(OI.getOpY() && !shooterIdleIsActive && IdleTimer()){
            shooterIdleIsActive = true;
        } else if (OI.getOpY() && shooterIdleIsActive && !IdleTimer()) {
            shooterIdleIsActive = false;
        }
    }

    public void teleShooter(){
        
        idle();

        if(OI.getOpA())
            shooter.run(1);
        else if (shooterIdleIsActive)
            shooter.run(0.25);
        else 
            shooter.run(0);
        
    }



}
