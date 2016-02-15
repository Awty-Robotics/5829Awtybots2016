package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.AngleDoNothing;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeAngle extends Subsystem {
	CANTalon angleMotor = new CANTalon(RobotMap.intakeAngleMotor);
	public static double encIntakeAngleVal = 0;//encoder value to be added 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new AngleDoNothing());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intakeUp() {
    	angleMotor.set(1);
    	}
    public void intakeDown() {
    	angleMotor.set(-1);
    }
    public void intakeKeepAngle(){
    	angleMotor.set(0);
    }
    /* setting the intake position:
     * 1) Find current position
     * 2) Based on current position/angle, determine 
     *    appropriate motor direction
     * 3) Set motor speed (testing at 0.2)
     * 4) Command is finished when in position
     * 5) Position is known via encoder or potentiometer
     * 
     * To do this, we must make the robot know what position or
     * angle it is currently in, along with basic motor speed code
     */
    //get encoder value
	/* encIntakeAngleVal = 0;//encoder value to be added
	if (encIntakeAngleVal >0) { 
	//encoder value at desired angle
		angleMotor.set(0.2);
	}
	else {
		angleMotor.set(-0.2);
    	*/
    	 
    	
    }
    


