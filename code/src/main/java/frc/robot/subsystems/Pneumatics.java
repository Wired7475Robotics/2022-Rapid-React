package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
    //declare compressor values
    Compressor compressor = new Compressor(1, PneumaticsModuleType.REVPH);
    boolean enabled = compressor.enabled();
    boolean pSwitch = compressor.getPressureSwitchValue();
    double current = compressor.getPressure();

    // declare Left arm solenoid values
    public static Solenoid Lifts = new Solenoid(PneumaticsModuleType.REVPH , 15 );
}
