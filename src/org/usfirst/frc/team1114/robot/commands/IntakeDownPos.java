package org.usfirst.frc.team1114.robot.commands;

import org.usfirst.frc.team1114.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1114.robot.subsystems.IntakeAngle;

/**
 *
 */
public class IntakeDownPos extends Command {

    public IntakeDownPos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakeAngle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	IntakeAngle.encIntakeAngleVal = 0;//get encoder current value
    	if (IntakeAngle.encIntakeAngleVal >0) { 
    		//encoder value at desired angle
    			Robot.intakeAngle.intakeDown();
    		}
    		else {
    			Robot.intakeAngle.intakeUp();
    			}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//get encoder current value
    	if ((IntakeAngle.encIntakeAngleVal > 593000) && (IntakeAngle.encIntakeAngleVal <607000 )) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
