package frc;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ControllersCommand extends CommandBase{
    public ControllersCommand() {
        // Use requires() here to declare subsystem dependencies
        addRequirements(Robot.controllers);
        System.out.println("controllercommandinit");
      }
    
      // Called just before this Command runs the first time
      @Override
      public void initialize() {
      }
    
      // Called repeatedly when this Command is scheduled to run
      @Override
      public void execute() {
        Robot.controllers.listen();
        System.out.println("listening to controllers");
      }
    
      // Make this return true when this Command no longer needs to run execute()
      @Override
      public boolean isFinished() {
        return false;
      }
    
      // Called once after isFinished returns true
      @Override
      protected void end() {
      }
    
      // Called when another command which requires one or more of the same
      // subsystems is scheduled to run
      @Override
      protected void interrupted() {
      }
}
