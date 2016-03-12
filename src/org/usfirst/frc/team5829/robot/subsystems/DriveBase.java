package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
	//As the left and right motors will always act together, I have chosen to array the left and right motors together
	CANTalon leftSideMotor[] = {new CANTalon(RobotMap.leftBackMotor), new CANTalon(RobotMap.leftFrontMotor)};
	CANTalon rightSideMotor[] = {new CANTalon(RobotMap.rightBackMotor), new CANTalon(RobotMap.rightFrontMotor)};
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
    	for(int i=0;i<2;i++){ leftSideMotor[i].set((-rotate+ straight)); }
    	for(int i=0;i<2;i++){ rightSideMotor[i].set((-rotate - straight)); }
    }
    public void flippedCheesyDrive(double straight, double rotate){
    	for(int i=0;i<2;i++){ leftSideMotor[i].set((rotate + straight)); }
    	for(int i=0;i<2;i++){ rightSideMotor[i].set((rotate - straight)); }
    }
  
}