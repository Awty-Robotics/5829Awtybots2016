package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class JSCheesyDrive extends Command {

    public JSCheesyDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Drive Train", "Cheesy Drive");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rawstraight;
    	double rawrotate;
    	double straight;  
    	double rotate;
    	
    	rawstraight = -(Robot.oi.xbox.getRawAxis(1));
    	rawrotate = -(Robot.oi.xbox.getRawAxis(4));
    	
    	if (Math.abs(rawstraight) < 0.18) {
    		straight = 0;
    	}
    	if (Math.abs(rawrotate) < 0.18) {
    		rotate = 0;
    	}
    	
    	straight = (0.1*(Math.pow(11, Math.abs(rawstraight)))-.1);
    	rotate = (0.1*(Math.pow(11, Math.abs(rawrotate)))-.1);
    	
    	if (rawstraight < 0){
    		straight= -(straight);
    	}
    	if (rawrotate < 0){
    		rotate= -(rotate);
    	}

    	Robot.driveTrain.cheesyDrive(straight*.5, rotate); 
    	System.out.println("Left: "+straight);
    	System.out.println("Right: "+-1*(rotate));
    
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
