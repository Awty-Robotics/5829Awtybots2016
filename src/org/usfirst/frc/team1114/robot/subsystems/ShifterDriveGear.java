package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.ShifterLowGear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShifterDriveGear extends Subsystem {
    DoubleSolenoid solenoid = new DoubleSolenoid (RobotMap.shiftHigh, RobotMap.shiftLow);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new ShifterLowGear());
        // Set the default command for a subsystem here.
    	
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void lowGear(){
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void highGear(){ 
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

