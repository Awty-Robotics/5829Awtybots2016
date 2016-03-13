package org.usfirst.frc.team5829.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous(int option) {
    	switch(option)
    	{
    	case 0: LowBar(); break;
    	case 1: Moat(); break;
    	case 2: RoughTerrain(); break;
    	case 3: Ramparts(); break;
    	case 4: RockWall(); break;
    	case 5: Breach(); break;
    	case 6: DoNothing(); break;
    	}
    }
    
    public void LowBar(){
    	addSequential(new AutoIntakeAngleTime(2.5, 0.3)); //low bar step 1
    	addSequential(new AutoForwardTime(2.5, 0.5)); //low bar step 2
    }
    
    public void Moat(){
    	addSequential(new AutoForwardTime(2.5, .5)); //works for moat
    	//addSequential(new AutoShooterTargeting());
    }
    
    public void RoughTerrain(){
    	addSequential(new AutoForwardTime(2, .75)); //works for rough terrain}
    }
    
    public void Ramparts(){
    	//code for ramparts
    }
    
    public void RockWall(){
    	//code for rockwall
    }
    
    public void Breach(){
    	//code for breach
    }
    
    public void DoNothing(){
    	//leave empty. probably will never be used but just in case......
    }
}
