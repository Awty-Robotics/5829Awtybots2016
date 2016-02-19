package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.DontExtendTapeMeasure;
import org.usfirst.frc.team1114.robot.commands.IntakeDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ScalingWheelTapeMeasure extends Subsystem {
	CANTalon leftTapeMeasure = new CANTalon(RobotMap.leftTapeMeasureMotor);
	CANTalon rightTapeMeasure = new CANTalon(RobotMap.rightTapeMeasureMotor);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new DontExtendTapeMeasure());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extend(double reel) {
    	leftTapeMeasure.set(reel);
    	rightTapeMeasure.set(-reel);
	}
    public void doNothing() {
    	leftTapeMeasure.set(0);
    	rightTapeMeasure.set(0);
    }
}

