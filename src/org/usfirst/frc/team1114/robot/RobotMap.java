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
	public static int leftBackMotor = 0;
	public static int leftFrontMotor = 1;
	public static int rightBackMotor = 15;
	public static int rightFrontMotor = 14;
	public static int rightShooterMotor = 8;
	public static int leftShooterMotor = 7;
	public static int intakeMotor = 6;
	public static int angleMotor = 9;
	public static int rightTapeMeasureMotor = 11;
	public static int leftTapeMeasureMotor = 4;
	public static int leftWinchMotor = 5;
	public static int rightWinchMotor = 10;
	
	public static int shiftHigh = 0;
	public static int shiftLow = 1;
	
	public static int shooterSwitch = 0;
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
