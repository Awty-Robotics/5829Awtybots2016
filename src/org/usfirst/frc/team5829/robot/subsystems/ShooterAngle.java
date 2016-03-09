package org.usfirst.frc.team5829.robot.subsystems;

import org.usfirst.frc.team5829.robot.Robot;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.IntakeDoNothing;
import org.usfirst.frc.team5829.robot.commands.ShooterAngleDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterAngle extends Subsystem {
	public CANTalon angle = new CANTalon(RobotMap.shooterAngleMotor);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new ShooterAngleDoNothing());
        //setDefaultCommand(new MySpecialCommand());
    	//SmartDashboard.putNumber("Shooter Position:", Robot.shooterAngle.angle.getPosition());
    }
    public void goToAngle(double setAngle) {
    	angle.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	angle.changeControlMode(TalonControlMode.Position);
    	angle.reverseSensor(false);
    	//angle.setPID(1, .0001, 0, 0, 0, 0, 0);
    	
    	angle.set(setAngle);
    	if(angle.getPosition()<0){
    		angle.set(0);
    	}
    	else if(angle.getPosition()>150000){
    		angle.set(0);
    	}
    	
    	
	}
    public void doNothing() {
    	angle.set(0);
    }
}

