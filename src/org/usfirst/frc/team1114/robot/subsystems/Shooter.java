package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.Robot;
import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.ShooterDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
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
		
		double leftSpeed = leftShooter.getSpeed();
		double rightSpeed = rightShooter.getSpeed();
		double avgSpeed;
		
		double fireA, fireB, fireY = 0.0;
		
		//average speed of the two shooter motors
		avgSpeed = (leftSpeed+Math.abs(rightSpeed))/2;
		
		//low speed shooting range
		if(1500.0 < avgSpeed){
			if(avgSpeed < 1600.0)
				fireA = 100.0;
			else
				fireA = 0.0;
		}
		else
			fireA = 0.0;
		
		//mid speed shooting range
		if(2700.0 < avgSpeed){
			if(avgSpeed < 2800.0)
				fireB = 100.0;
			else
				fireB = 0.0;
		}
		else
			fireB = 0.0;
		
		//high speed shooting range
		if(5300.0 < avgSpeed){
			if(avgSpeed < 5400.0)
				fireY = 100.0;
			else
				fireY = 0.0;
		}
		else
			fireY = 0.0;
		
			
		
		//SmartDashboard.putNumber("Count",leftShooter.getEncPosition());
		//SmartDashboard.putNumber("Raw Distance",shooterEncoder.getRaw());
		//SmartDashboard.putNumber("Distance",shooterEncoder.getDistance());
		
		
		// get and display values from encoder
		SmartDashboard.putNumber("Rate",leftShooter.getEncVelocity());
		SmartDashboard.putNumber("Left Speed: ", leftSpeed);
		SmartDashboard.putNumber("Right Speed: ", Math.abs(rightSpeed));
		SmartDashboard.putNumber("Left Speed Value:", leftSpeed);
		SmartDashboard.putNumber("Right Speed Value:", Math.abs(rightSpeed));
		SmartDashboard.putNumber("Average Speed: ", avgSpeed);
		
		// used for displaying a green bar that will tell the drivers when to fire the ball
		SmartDashboard.putNumber("Low Speed Fire!!", fireA);
		SmartDashboard.putNumber("Mid Speed Fire!!", fireB);
		SmartDashboard.putNumber("High Speed Fire!!", fireY);
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

