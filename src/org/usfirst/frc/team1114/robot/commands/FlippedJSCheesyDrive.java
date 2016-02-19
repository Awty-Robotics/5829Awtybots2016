package org.usfirst.frc.team1114.robot.commands;

import org.usfirst.frc.team1114.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FlippedJSCheesyDrive extends Command {

    public FlippedJSCheesyDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Drive Train", "Flipped Cheesy Drive");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rawstraight;
    	double rawrotate;
    	double straight;  
    	double rotate;
    	
    	rawstraight = -(Robot.oi.xbox.getRawAxis(4));
    	rawrotate = (Robot.oi.xbox.getRawAxis(1));
    	
    	if (Math.abs(rawstraight) < 0.18) {
    		straight = 0;
    	}
    	if (Math.abs(rawrotate) < 0.18) {
    		rotate = 0;
    	}
    	
    	if (rawstraight < 0){
    		rawstraight= -(rawstraight);
    	}
    	if (rawrotate < 0){
    		rawrotate= -(rawrotate);
    	}
    	
    	straight = (0.001*(Math.pow(1500, rawstraight)));
    	rotate = (0.001*(Math.pow(1500, rawrotate)));
    	
    	if (rawstraight < 0){
    		straight= -(straight);
    	}
    	if (rawrotate < 0){
    		rotate= -(rotate);
    	}

    	Robot.driveTrain.cheesyDrive(straight, rotate); 
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
