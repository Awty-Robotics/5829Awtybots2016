package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.IntakeDoNothing;
import org.usfirst.frc.team5829.robot.commands.WinchDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ScalingWinches extends Subsystem {
	CANTalon leftWinch = new CANTalon(RobotMap.leftWinchMotor);
	CANTalon rightWinch = new CANTalon(RobotMap.rightWinchMotor);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new WinchDoNothing());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void reel(double reel) {
    	leftWinch.set(reel);
    	rightWinch.set(reel);
	}
    public void doNothing() {
    	leftWinch.set(0);
    	rightWinch.set(0);
    }
}

