package org.usfirst.frc.team1114.robot.commands;

import org.usfirst.frc.team1114.robot.Robot;
import org.usfirst.frc.team1114.robot.subsystems.IntakeAngle;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMiddlePos extends Command {

    public IntakeMiddlePos() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	IntakeAngle.encIntakeAngleVal = 0;//get encoder current value
    	if (IntakeAngle.encIntakeAngleVal <0) { 
    		//encoder value at desired angle
    			Robot.intakeAngle.intakeUp();
    		}
    		else {
    			Robot.intakeAngle.intakeDown();
    		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//get encoder current value
    	if ((IntakeAngle.encIntakeAngleVal > 293000) && (IntakeAngle.encIntakeAngleVal <307000 )) {
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
