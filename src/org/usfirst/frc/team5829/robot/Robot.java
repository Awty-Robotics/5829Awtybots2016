
package org.usfirst.frc.team5829.robot;

import org.usfirst.frc.team5829.robot.subsystems.*;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import org.usfirst.frc.team1114.robot.commands.ExampleCommand;
//import org.usfirst.frc.team1114.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    
    public static Preferences prefs;
    CameraServer server;
    USBCamera targetCam;
    public static int g_exp;
    
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
    //subsystems
	public static final DriveBase driveTrain = new DriveBase();
	public static final Shooter shooter = new Shooter();
	public static final IntakeRollers intake = new IntakeRollers();
	public static final IntakeAngle intakeAngle = new IntakeAngle();
	public static final ScalingWinches scalingWinch = new ScalingWinches();
	public static final ScalingWheelTapeMeasure scalingTape = new ScalingWheelTapeMeasure();
	public static final ShifterDriveGear shiftDriveGear = new ShifterDriveGear();
	public static final Electrical electrical = new Electrical();
	
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
		oi = new OI();
		prefs = Preferences.getInstance();
		
    	targetCam = new USBCamera("cam0");
    	targetCam.setBrightness(prefs.getInt("cameraBrightness", 10));
    	targetCam.setExposureManual(prefs.getInt("cameraExposure", 10));
    	//targetCam.setSize(width, height);
    	
		server = CameraServer.getInstance();
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();


        // the camera name (ex "cam0") can be found through the roborio web interface
        /*session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);*/
    	
    	//SmartDashboard.putNumber("Brightness", targetCam.getBrightness());
    	
       
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Image image = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        
        //Scheduler.getInstance().run();

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

    	targetCam.startCapture();
    	
        while (isOperatorControl() && isEnabled()) {
        	Scheduler.getInstance().run();

            targetCam.getImage(image);
            
            //NIVision.imaqDrawShapeOnImage(image, image, rect,
                    //DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            server.setImage(image);

            /** robot code here! **/
            electrical.pArTy(0, 1000, 0);
            Timer.delay(0.005);		// wait for a motor update time
        }
        targetCam.stopCapture();
        electrical.pArTy(1000, 0, 0);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    //SMARTDASHBOARD STARS HERE RIGHT HERE SMARTDASHBOARD!!!!
    
    
}
