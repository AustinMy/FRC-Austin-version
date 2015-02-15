package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousEasiest extends CommandGroup {
	
	public AutonomousEasiest(){
		addSequential(new AutonomousStart());
		
	}
	
	
}
