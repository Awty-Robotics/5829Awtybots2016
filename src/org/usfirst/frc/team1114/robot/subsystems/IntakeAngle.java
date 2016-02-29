package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.AngleManual;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeAngle extends Subsystem {
    
	//As the left and right motors will always act together, I have chosen to array the left and right motors together
		CANTalon angleMotor = new CANTalon(RobotMap.angleMotor);
	    // Put methods for controlling this subsystem
	    // here. Call these from Commands.

	    public void initDefaultCommand() {
	    	setDefaultCommand (new AngleManual());
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	    //Description
	    
	    public void angleManual (double up, double down){
	    	angleMotor.changeControlMode(TalonControlMode.PercentVbus);
	    	angleMotor.set(up+down);//Will set the variables left and right Speed to joystick values in command
	    }
	   
	    public void horizontalAngle(){
	    	int horizontalPosition = 0;
	    	int startPosition = 0;
	    	angleMotor.setFeedbackDevice(FeedbackDevice.AnalogPot);
	    	
	    	angleMotor.reverseSensor(false);
	    	
	    	angleMotor.changeControlMode(TalonControlMode.Position);
	    	
	    	//(p, i, d, f, izone, closeLoopRampRate, profile)
	    	angleMotor.setPID(.5, .00009, .5, 0, 0, 0, 0);
			SmartDashboard.putNumber("Angle of Intake: ", angleMotor.getPosition());
	    	angleMotor.set(horizontalPosition);//degrees to be horizontal
	    	
	    }
	    
	    public boolean targetReached(){
	    	angleMotor.setFeedbackDevice(FeedbackDevice.AnalogPot);
	    	angleMotor.reverseSensor(false);
	    	double error = Math.abs(angleMotor.getClosedLoopError());
	    	if (error > 0.5){              //need to determine actual error tolerance
	    		return true;
	    	} else {
	    		return false;
	    	}
	    	
	    }
	    
	    
	}

