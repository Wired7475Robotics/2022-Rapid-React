// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  /** Creates a new TankDrive. */
  private final Drivetrain m_drivetrain;

  public TankDrive(Drivetrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_drivetrain = subsystem;
    addRequirements(Robot.drivetrain);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    Robot.drivetrain.tankDrive(OI.getX(), OI.getY(), OI.drive.getLeftBumper(), OI.drive.getRightBumper());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0, false, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
