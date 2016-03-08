package org.usfirst.frc.team5829.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5829.robot.RobotMap;
import org.usfirst.frc.team5829.robot.commands.RunCompressor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PWM;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 *
 */
public class Electrical extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void initDefaultCommand() {
		//setDefaultCommand(new RunCompressor());
	}
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	
	public Compressor cmp;
	public AnalogInput pressure;
	public PWM r;
	public PWM g;
	public PWM b;
	
	public Electrical(){
		cmp = new Compressor(30);
		pressure = new AnalogInput(0);
		cmp.setClosedLoopControl(true);
		
	}
	
	public void enableCompressor(){
		//cmp.setClosedLoopControl(true);
		//cmp.start();
	}

	/*public void pArTy(int rPWM,int gPWM, int bPWM){
		r= new PWM(RobotMap.Rled);
		g= new PWM(RobotMap.Gled);
		b= new PWM(RobotMap.Bled);
		r.setRaw(rPWM);
		g.setRaw(gPWM);
		b.setRaw(bPWM);
		
	}*/
	/*
	public void setCompressor(boolean var){
		if(var)
			cmp.start();
		else
			cmp.stop();
	}
	
	public boolean getCompressorState(){
		return cmp.enabled();
	}
	
	public boolean getPressureSwitchState(){
		return cmp.getPressureSwitchValue();
	}
	
	public boolean getCompressorControlLoopState(){
		return cmp.getClosedLoopControl();
	}
	
	public double getCompressorCurrent(){
		return cmp.getCompressorCurrent();
	}
	
	
    }*/
}

