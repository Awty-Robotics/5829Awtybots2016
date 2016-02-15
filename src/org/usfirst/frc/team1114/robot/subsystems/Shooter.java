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
	CANTalon leftShooter = new CANTalon(RobotMap.leftShooterMotor);
	CANTalon rightShooter = new CANTalon(RobotMap.rightShooterMotor);

	
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
    	
    }
    
    public void shoot(double speed) {
    	//changing Talon mode to speed to directly control speed, not power
    	rightShooter.changeControlMode(TalonControlMode.Speed);
    	leftShooter.changeControlMode(TalonControlMode.Speed);
    	
    	//introducing the sensor for the right shooter motor
    	rightShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightShooter.reverseSensor(false); //can change to "true" to multiply value from the sensor by -1
    	rightShooter.configNominalOutputVoltage(+0.0f, -0.0f); //minimum power to motor
    	rightShooter.configPeakOutputVoltage(+12.0f, 0.0f);//we don't want the motors to spin backwards. ever.
    	
    	//setting PID parameters
    	rightShooter.setProfile(0);//this is a thing
    	rightShooter.setF(0.1097);//feed-forward gain--it's also a thing.
    	rightShooter.setP(0.22);//proportional
    	rightShooter.setI(0); //integral
    	rightShooter.setD(0);//derivative
    	
    	//repeating sensor setup for left shooter motor
    	leftShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	leftShooter.reverseSensor(false);
    	leftShooter.configNominalOutputVoltage(+0.0f, -0.0f);
    	leftShooter.configPeakOutputVoltage(+12.0f, 0.0f);
    	
    	//PID parameters for the left shooter motor, same as rightshooter
    	leftShooter.setProfile(0);
    	leftShooter.setF(0.1097);
    	leftShooter.setP(0.22);
    	leftShooter.setI(0); 
    	leftShooter.setD(0);
    	
    	//Setting target speed. The Talons are in speed mode, so the values indicate RPM, not power.
    	rightShooter.set(speed);
    	leftShooter.set(speed);
       	
    }
    public void doNothing() {
    	//Changing the Talons back to their default mode, PercentVbus. 
    	//These values range from 0 (0% power) to 1(100% power).
    	//Speed control is not necessary here--we just want to stop sending electricity to the motors.
    	rightShooter.changeControlMode(TalonControlMode.PercentVbus);
    	leftShooter.changeControlMode(TalonControlMode.PercentVbus);
    	
    	//A value of 0 means there will be no power sent to the motors.
    	rightShooter.set(0);
    	leftShooter.set(0);
    }
}

