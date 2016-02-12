package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.Robot;
import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.ShooterDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon leftShooter = new CANTalon(0);
	CANTalon rightShooter = new CANTalon(1);

	
	//Encoder shooterEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
	
	public void updateDashboard() {
		//SmartDashboard.putNumber("Count",leftShooter.getEncPosition());
		//SmartDashboard.putNumber("Raw Distance",shooterEncoder.getRaw());
		//SmartDashboard.putNumber("Distance",shooterEncoder.getDistance());
		SmartDashboard.putNumber("Rate",leftShooter.getEncVelocity());
		SmartDashboard.putNumber("Left Speed: ", leftShooter.getSpeed());
		SmartDashboard.putNumber("Right Speed ", Math.abs(rightShooter.getSpeed()));
		//SmartDashboard.putBoolean("Direction",shooterEncoder.getDirection());
		//SmartDashboard.putBoolean("Stopped",shooterEncoder.getStopped());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterDoNothing());
    	//shooterEncoder.setMinRate(0);
    	//shooterEncoder.reset();
    	leftShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    }
    
    public void shoot(double speed) {
    	//leftShooter.changeControlMode(TalonControlMode.Speed);
    	leftShooter.set(speed);
    	//rightShooter.changeControlMode(TalonControlMode.Speed);
    	rightShooter.set(speed);
       	
    }
    public void doNothing() {
    	rightShooter.set(0);
    	leftShooter.set(0);
    }
}

