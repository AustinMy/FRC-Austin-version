package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousStart extends CommandGroup {
    
    public  AutonomousStart() {
    	addSequential(new MoveToBox());
    	addSequential(new LiftCommand(1,1));
    }
}
