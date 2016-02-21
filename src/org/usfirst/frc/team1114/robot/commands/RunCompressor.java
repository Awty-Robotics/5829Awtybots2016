package org.usfirst.frc.team1114.robot.commands;

import org.usfirst.frc.team1114.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RunCompressor extends Command {

    public RunCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.electrical);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.electrical.enableCompressor();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.electrical.enableCompressor();
    	
    	SmartDashboard.putNumber("Pressure",Robot.electrical.pressure.getValue());
    	SmartDashboard.putBoolean("Compressor Enabled",Robot.electrical.cmp.enabled());
    	SmartDashboard.putNumber("Compressor Current",Robot.electrical.cmp.getCompressorCurrent());
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
