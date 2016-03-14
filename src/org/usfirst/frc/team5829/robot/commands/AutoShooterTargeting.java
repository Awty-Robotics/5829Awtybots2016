package org.usfirst.frc.team5829.robot.commands;

import org.usfirst.frc.team5829.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoShooterTargeting extends Command {

    public AutoShooterTargeting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double xcenter = 0;//get function goes here
    	double xtarget = 0;
    	double xslowzone= 30;
    	double xerrortolerance = 5;
    	double maxturn = .4;
    	double slowturn = .2;
    	
    	double ycenter = 30;//get function goes here
    	double ytarget = 30;
    	double yslowzone = 30;
    	double yerrortolerance = 5;
    	double maxstraight = .4;
    	double slowstraight = .2;
    	
    	Robot.shooter.shoot(3000);
    	
    	while(xcenter < xtarget - xerrortolerance || xcenter > xtarget + xerrortolerance){
    		if (xcenter > xtarget + xslowzone){
    			Robot.driveTrain.cheesyDrive(0,-maxturn);
    		}else if (xcenter > xtarget + xerrortolerance && xcenter < xtarget + xslowzone){
    			Robot.driveTrain.cheesyDrive(0,-slowturn);
    		}else if (xcenter < xtarget - xslowzone){
    			Robot.driveTrain.cheesyDrive(0,maxturn);
    		}else if (xcenter < xtarget - xerrortolerance && xcenter > xtarget - xslowzone){
    			Robot.driveTrain.cheesyDrive(0,slowturn);
    		}else if (xcenter > xtarget - xerrortolerance && xcenter < xtarget + xerrortolerance){
    			Robot.driveTrain.cheesyDrive(0,0);
    		}
    	}
    	while(ycenter < ytarget - yerrortolerance || ycenter > ytarget + yerrortolerance){
    		if (ycenter > ytarget + yslowzone){
    			Robot.driveTrain.cheesyDrive(-maxstraight,0);
    		}else if (ycenter > ytarget + yerrortolerance && ycenter < ytarget + yslowzone){
    			Robot.driveTrain.cheesyDrive(-slowstraight,0);
    		}else if (ycenter < ytarget - yslowzone){
    			Robot.driveTrain.cheesyDrive(-maxstraight,0);
    		}else if (ycenter < ytarget - yerrortolerance && ycenter > ytarget - yslowzone){
    			Robot.driveTrain.cheesyDrive(slowstraight,0);
    		}else if (ycenter > ytarget - yerrortolerance && ycenter < ytarget + yerrortolerance){
    			Robot.driveTrain.cheesyDrive(0,0);
    		}
    	}
    	while(xcenter < xtarget - xerrortolerance || xcenter > xtarget + xerrortolerance){
    		if (xcenter > xtarget + xslowzone){
    			Robot.driveTrain.cheesyDrive(0,-maxturn);
    		}else if (xcenter > xtarget + xerrortolerance && xcenter < xtarget + xslowzone){
    			Robot.driveTrain.cheesyDrive(0,-slowturn);
    		}else if (xcenter < xtarget - xslowzone){
    			Robot.driveTrain.cheesyDrive(0,maxturn);
    		}else if (xcenter < xtarget - xerrortolerance && xcenter > xtarget - xslowzone){
    			Robot.driveTrain.cheesyDrive(0,slowturn);
    		}else if (xcenter > xtarget - xerrortolerance && xcenter < xtarget + xerrortolerance){
    			Robot.driveTrain.cheesyDrive(0,0);
    		}
    	}
    	if (Robot.shooter.ready()){
       	 Robot.intake.intake(1);
       	 }
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
