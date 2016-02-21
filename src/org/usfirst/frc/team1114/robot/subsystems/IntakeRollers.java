package org.usfirst.frc.team1114.robot.subsystems;

import org.usfirst.frc.team1114.robot.Robot;
import org.usfirst.frc.team1114.robot.RobotMap;
import org.usfirst.frc.team1114.robot.commands.IntakeDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeRollers extends Subsystem {
	CANTalon intake = new CANTalon(RobotMap.intakeMotor);
	DigitalInput shooterSwitch = new DigitalInput(RobotMap.shooterSwitch);
	public Joystick xbox = new Joystick(0);
	Button btnR1 = new JoystickButton(xbox, 6);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand (new IntakeDoNothing());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intake(double power) {
    	if ((shooterSwitch.get() == false) && (power > 0) && (!Robot.shooter.ready())){
    	 intake.set(0);
    	 }else{
    	 intake.set(power);
    	 }
    }
    public void doNothing() {
    	intake.set(0);
    	
    }
}

