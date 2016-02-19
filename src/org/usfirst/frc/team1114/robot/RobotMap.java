package org.usfirst.frc.team1114.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	public static int leftBackMotor = 2;
	public static int leftFrontMotor = 3;
	public static int rightBackMotor = 4;
	public static int rightFrontMotor = 5;
	public static int rightShooterMotor = 1;
	public static int leftShooterMotor = 0;
	public static int intakeMotor = 6;
	public static int angleMotor = 7;
	public static int rightTapeMeasureMotor = 8;
	public static int leftTapeMeasureMotor = 9;
	public static int leftWinchMotor = 10;
	public static int rightWinchMotor = 11;
	
	public static int shifterReverse = 0;
	public static int shifterForward = 1;
	
	public static int shooterSwitch = 0;
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
