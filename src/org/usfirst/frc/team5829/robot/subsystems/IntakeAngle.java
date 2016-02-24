package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.AngleManual;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeAngle extends Subsystem {
    
	//As the left and right motors will always act together, I have chosen to array the left and right motors together
		CANTalon angleMotor = new CANTalon(RobotMap.angleMotor);
	    // Put methods for controlling this subsystem
	    // here. Call these from Commands.
		double horizontalPosition=0;
		double verticlePosition=0;
		double startPosition=0;

	    public void initDefaultCommand() {
	    	setDefaultCommand (new AngleManual());
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	    //Description
	    
	    public void angleManual (double up, double down){
	    	angleMotor.changeControlMode(TalonControlMode.PercentVbus);
	    	angleMotor.set((up+down)/3);//Will set the variables left and right Speed to joystick values in command
	    }
	   
	    public void horizontalAngle(){
	    	angleMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	    	
	    	angleMotor.reverseSensor(false);
	    	
	    	angleMotor.changeControlMode(TalonControlMode.Position);
	    	angleMotor.set(.1);
	    	//(p, i, d, f, izone, closeLoopRampRate, profile)
	    	angleMotor.setPID(.5, .5, .5, 0, 0, 0, 0);
	    	
	    	angleMotor.set(horizontalPosition);//degrees to be horizontal
	    }
	    
	    public boolean targetReached(){
	    	angleMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	    	angleMotor.reverseSensor(false);
	    	double error = Math.abs(angleMotor.getClosedLoopError());
	    	if (error > 0.5){              //need to determine actual error tolerance
	    		return true;
	    	} else {
	    		return false;
	    	}
	    	
	    }
	    
	    
	}

