package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.commands.*;
import org.usfirst.frc.team1114.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RushDrive extends Subsystem {
	//As the left and right motors will always act together, I have chosen to array the left and right motors together
	SpeedController leftSideMotor[] = {new Victor(RobotMap.leftBackMotor), new Victor(RobotMap.leftFrontMotor)};
	SpeedController rightSideMotor[] = {new Victor(RobotMap.rightBackMotor), new Victor(RobotMap.rightFrontMotor)};
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new JSCheesyDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //Description
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	for(int i=0;i<2;i++){ leftSideMotor[i].set(leftSpeed); }
    	for(int i=0;i<2;i++){ rightSideMotor[i].set(rightSpeed); }
    	//Will set the variables left and right Speed to joystick values in command
    }
    
    public void cheesyDrive(double straight, double rotate){
    	for(int i=0;i<2;i++){ leftSideMotor[i].set(straight + rotate); }
    	for(int i=0;i<2;i++){ rightSideMotor[i].set(straight - rotate); }
    }
    public void flippedCheesyDrive(double straight, double rotate){
    	for(int i=0;i<2;i++){ leftSideMotor[i].set(straight + rotate); }
    	for(int i=0;i<2;i++){ rightSideMotor[i].set(straight - rotate); }
    }
}