package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;
import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.AngleManual;
import org.usfirst.frc.team5829.robot.commands.HorizontalAngle;

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
		double horizontalPosition=-.32;
		double verticalPosition=0;
		double startPosition=0;
		double intakeP=.1;
		double intakeI=0;
		double intakeD=0;
		//int secondaryCommand =0;
		//double val=0;

	    public void initDefaultCommand() {
	    	setDefaultCommand (new AngleManual());
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	    //Description
	    
	    public void PIDControl(){
	    	angleMotor.changeControlMode(TalonControlMode.PercentVbus);
    	
    		double intakeP = Robot.prefs.getDouble("intakeP", 0.1);
    		double intakeI = Robot.prefs.getDouble("intakeI", 0);
    		double intakeD = Robot.prefs.getDouble("intakeD", 0);
    		double intakeF = Robot.prefs.getDouble("intakeF", 0);
    		angleMotor.set(angleMotor.get());
    		double PIDError = angleMotor.getError();
    	
    		double propComponent = intakeP*PIDError;
    		//double intComponent = intComponent + intakeI*PIDError;
    	//	double diffComponent = intakeD*(PIDError-LastPIDError;
    		angleMotor.set(propComponent);
    	//		LastPIDError = PIDError;
	    }
    				
	    public void angleManual (double up, double down){
	    	//if ((up+down)!=0){
	    	angleMotor.changeControlMode(TalonControlMode.PercentVbus);
	    	if(up<0 && down>0){
	    		angleMotor.set((-.2));
	    	}
		    	angleMotor.set((up+down));//Will set the variables left and right Speed to joystick values in command	
	    	/*}else{
	    		PIDControl();
	    	}	*/
	    }
	   
	    public void horizontalAngle(double pos){
	    	angleMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	    	angleMotor.reverseSensor(false);
	    	
	    	angleMotor.changeControlMode(TalonControlMode.Speed);
	    	
	    	angleMotor.setForwardSoftLimit(.4);
	    	angleMotor.enableForwardSoftLimit(false);
	    	angleMotor.setReverseSoftLimit(-.5);
	    	angleMotor.enableReverseSoftLimit(false);
	    	
	    	//(p, i, d, f, izone, closeLoopRampRate, profile)
	    	angleMotor.setPID(intakeP, intakeI, intakeD, 1, 0, 0, 0);
	    	if(pos==1){
	    	//angleMotor.set(horizontalPosition);//degrees to be horizontal
	    	}
	    	else if(pos==2){
	    		//angleMotor.set(horizontalPosition);
	    		angleMotor.setSetpoint(horizontalPosition);
	    		//angleMotor.set
	    		//angleMotor.set
	    	}
	    	else{
	    		//angleMotor.setSetpoint(verticalPosition);
	    		angleMotor.changeControlMode(TalonControlMode.PercentVbus);
	    	}
	    	
	    	/*
	    	if(angleMotor.getPosition()>=horizontalPosition && pos==2){
	    		angleMotor.set(.3);
	    	}
	    	else if(angleMotor.getPosition()<=horizontalPosition && pos==2){
	    		angleMotor.set(-.3);
	    	}
	    	else if(angleMotor.getPosition()<=verticalPosition && pos>2){
	    		angleMotor.set(-.3);
	    	}
	    	else if(angleMotor.getPosition()>=verticalPosition && pos>2){
	    		angleMotor.set(.3);
	    	}
	    	else{
	    		angleMotor.set(0);
	    	}
	    	*/	    	
	    	SmartDashboard.putNumber("Arm Position:", angleMotor.getPosition());
	    	
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

