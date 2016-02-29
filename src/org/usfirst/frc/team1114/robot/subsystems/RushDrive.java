package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.commands.*;
import org.usfirst.frc.team1114.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RushDrive extends Subsystem {
	//As the left and right motors will always act together, I have chosen to array the left and right motors together
	//CANTalon leftSideMotor[] = {new CANTalon(RobotMap.leftBackMotor), new CANTalon(RobotMap.leftFrontMotor)};
	//CANTalon rightSideMotor[] = {new CANTalon(RobotMap.rightBackMotor), new CANTalon(RobotMap.rightFrontMotor)};
	CANTalon leftBackDrive = new  CANTalon(RobotMap.leftBackMotor);
	CANTalon leftFrontDrive= new CANTalon(RobotMap.leftFrontMotor);
	CANTalon rightBackDrive = new CANTalon(RobotMap.rightBackMotor);
	CANTalon rightFrontDrive = new CANTalon(RobotMap.rightFrontMotor);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new JSCheesyDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //Description
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	//for(int i=0;i<2;i++){ leftSideMotor[i].set(leftSpeed); }
    	//for(int i=0;i<2;i++){ rightSideMotor[i].set(rightSpeed); }
    	leftBackDrive.set(leftSpeed);
    	leftFrontDrive.set(leftSpeed);
    	rightFrontDrive.set(rightSpeed);
    	rightBackDrive.set(rightSpeed);
    	//Will set the variables left and right Speed to joystick values in command
    }
    
    public void cheesyDrive(double straight, double rotate){
    	//for(int i=0;i<2;i++){ leftSideMotor[i].set(-straight + rotate); }
    	//for(int i=0;i<2;i++){ rightSideMotor[i].set(-straight - rotate); }
    	leftBackDrive.set(-straight + rotate);
    	leftFrontDrive.set(-straight + rotate);
    	rightFrontDrive.set(-straight - rotate);
    	rightBackDrive.set(-straight - rotate);
		SmartDashboard.putNumber("Left Back Drive Current Draw: ", leftBackDrive.getOutputCurrent());
		SmartDashboard.putNumber("Left Front Drive Current Draw: ", leftFrontDrive.getOutputCurrent());
		SmartDashboard.putNumber("Right Back Drive Current Draw: ", rightBackDrive.getOutputCurrent());
		//SmartDashboard.putNumber("Right Front Drive Current Draw: ", rightFrontDrive.getOutputCurrent());
    }
    public void flippedCheesyDrive(double straight, double rotate){
    	//for(int i=0;i<2;i++){ leftSideMotor[i].set(straight + rotate); }
    	//for(int i=0;i<2;i++){ rightSideMotor[i].set(straight - rotate); }
    	leftBackDrive.set(straight + rotate);
    	leftFrontDrive.set(straight + rotate);
    	rightFrontDrive.set(straight - rotate);
    	rightBackDrive.set(straight - rotate);
    }
    public void turnToGoal(){
    	
    }
  
}