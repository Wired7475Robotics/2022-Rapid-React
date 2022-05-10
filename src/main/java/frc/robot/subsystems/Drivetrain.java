// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //Variable init

  VictorSPX leftmotor1;
  VictorSPX leftmotor2;
  VictorSPX rightmotor1;
  VictorSPX rightmotor2;
  //TalonFX testmotor;

  DifferentialDrive differentialDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    //Initializing the motors 
    leftmotor1 = new VictorSPX(Constants.LEFT_FRONT);
    leftmotor1.configPeakOutputForward(.75);
    leftmotor1.configPeakOutputReverse(-.75);

    leftmotor2 = new VictorSPX(Constants.LEFT_REAR);
    leftmotor2.configPeakOutputForward(.75);
    leftmotor2.configPeakOutputReverse(-.75);

    rightmotor1 = new VictorSPX(Constants.RIGHT_FRONT);
    rightmotor1.configPeakOutputForward(.75);
    rightmotor1.configPeakOutputReverse(-.75);

    rightmotor2 = new VictorSPX(Constants.RIGHT_REAR);
    rightmotor2.configPeakOutputForward(.75);
    rightmotor2.configPeakOutputReverse(-.75);

   // testmotor = new TalonFX(4);
    //testmotor.set(ControlMode.PercentOutput, -0.2);
    //Creating MotorControlGroups for motors

  }

  public void tankDrive(double x, double y, boolean trig1, boolean trig2){ //New tankDrive object
    
    //joystickDrive.joyDrive(x, y, trig1, trig2, leftmotor1, rightmotor1);
    //leftmotor1.follow(leftmotor2);
    //rightmotor1.follow(rightmotor2);
    //Sets what values are used in arcade drive
  }

  public double getLeftTarget(){
    return leftmotor1.getMotorOutputPercent();
  }

  public double getRightTarget(){
    return rightmotor1.getMotorOutputPercent();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
