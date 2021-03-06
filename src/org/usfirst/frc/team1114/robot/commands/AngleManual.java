package org.usfirst.frc.team1114.robot.commands;

import org.usfirst.frc.team1114.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AngleManual extends Command {

    public AngleManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intakeAngle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rawup;
    	double rawdown;
    	double up;
    	double down;
    	
    	rawup = -(Robot.oi.xbox.getRawAxis(2)+Robot.oi.xbox2.getRawAxis(2));
    	rawdown = (Robot.oi.xbox.getRawAxis(3)+Robot.oi.xbox2.getRawAxis(3));

    	
    	up = (0.1*(Math.pow(11, Math.abs(rawup)))-.1);
    	down = (0.1*(Math.pow(11, Math.abs(rawdown)))-.1);
    	
    	if (rawup < 0){
    		up= -(up);
    	}
    	if (rawdown < 0){
    		down= -(down);
    	}

    	Robot.intakeAngle.angleManual(up, down); 
    	System.out.println("Up: "+up);
    	System.out.println("Down: "+(down));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
