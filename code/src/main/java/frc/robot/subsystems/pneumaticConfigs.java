package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class pneumaticConfigs {
    //declare compressor values
    Compressor compressor = new Compressor(1, PneumaticsModuleType.REVPH);
    boolean enabled = compressor.enabled();
    boolean pSwitch = compressor.getPressureSwitchValue();
    double current = compressor.getPressure();

    //TODO: get CAN IDs for solenoids
    // declare Left arm solenoid values
    Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.REVPH , 1 );
}
