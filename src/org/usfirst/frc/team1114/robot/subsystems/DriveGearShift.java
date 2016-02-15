package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.ShifterLowGear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveGearShift extends Subsystem {
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.shifterSolenoid1, RobotMap.shifterSolenoid2);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new ShifterLowGear());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void solenoidForward() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void solenoidReverse() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);	
    }
}

