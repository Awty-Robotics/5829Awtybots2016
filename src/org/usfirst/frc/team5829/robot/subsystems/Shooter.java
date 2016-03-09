package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.ShooterDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
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
	public Timer timer = new Timer();
	public boolean isShooting=false;
	
	//Encoder shooterEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
	
	public void updateDashboard() {
		
		double leftSpeed = leftShooter.getSpeed();
		double rightSpeed = rightShooter.getSpeed();
		double avgSpeed;
		
		double fireA, fireB, fireY = 0.0;
		
		//average speed of the two shooter motors
		avgSpeed = (Math.abs(leftSpeed)+Math.abs(rightSpeed))/2;
		
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
		SmartDashboard.putNumber("RateL",leftShooter.getSpeed());
		SmartDashboard.putNumber("RateR",rightShooter.getSpeed());
		SmartDashboard.putNumber("Left Speed: ", Math.abs(leftSpeed));
		SmartDashboard.putNumber("Right Speed: ", Math.abs(rightSpeed));
		SmartDashboard.putNumber("Left Speed Value:", Math.abs(leftSpeed));
		SmartDashboard.putNumber("Right Speed Value:", Math.abs(rightSpeed));
		SmartDashboard.putNumber("Average Speed: ", avgSpeed);
		SmartDashboard.putNumber("Error: ", leftShooter.getClosedLoopError());
		
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
    	
    	leftShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	rightShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	
    	leftShooter.reverseSensor(false);
    	rightShooter.reverseSensor(true);
    	
    	leftShooter.changeControlMode(TalonControlMode.Speed);
    	rightShooter.changeControlMode(TalonControlMode.Speed);
    	
    	leftShooter.configPeakOutputVoltage(+12.0f, -0.0f);
    	rightShooter.configPeakOutputVoltage(+12.0f, -0.0f);
    	
    	double shooterP = Robot.prefs.getDouble("shooterP", 0.4);
    	double shooterI = Robot.prefs.getDouble("shooterI", 0);
    	double shooterD = Robot.prefs.getDouble("shooterD", 4);
    	double shooterF = Robot.prefs.getDouble("shooterF", 0);
    	double prefspeed = Robot.prefs.getDouble("prefspeed", 100);
    	
    	//(p, i, d, f, izone, closeLoopRampRate, profile)
    	leftShooter.setPID(shooterP, shooterI, shooterD, shooterF, 0, 0, 0);
    	rightShooter.setPID(shooterP, shooterI, shooterD, shooterF, 0, 0, 0);
    	
    	leftShooter.set(prefspeed);
    	rightShooter.set(prefspeed);
    	isShooting=true;
    }
    public void manualShoot(double speed) {
		leftShooter.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooter.changeControlMode(TalonControlMode.PercentVbus);
		rightShooter.set(speed);
    	leftShooter.set(speed);
    }
    
    public boolean ready() {
    	/*double prefready = Robot.prefs.getDouble("ready", 9);
    	
    	if (Math.abs(leftShooter.getClosedLoopError())< prefready ){
    		return true;
    	}else{ 
    		return false;
    	}*/
    	if (isShooting==true){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public void doneShooting(){
    	isShooting=false;
    }
    
    public void doNothing() {
    	leftShooter.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooter.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooter.set(0);
    	leftShooter.set(0);
    	isShooting=false;
    }
}

