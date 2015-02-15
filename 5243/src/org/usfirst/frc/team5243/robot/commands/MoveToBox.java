package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToBox extends Command {
	private long time;
	private double distance;
    public MoveToBox() {
        requires(Robot.oi.sensorSubsystem);
        requires(Robot.oi.motorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = System.currentTimeMillis();
    	distance = Robot.oi.sensorSubsystem.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.motorSubsystem.getRobot().drive(.5, 0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.sensorSubsystem.getDistance()<20) return true;
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.oi.motorSubsystem.getRobot().drive(0,0);
    	Robot.oi.setSpeed(getVelocity(time,System.currentTimeMillis(),distance,Robot.oi.sensorSubsystem.getDistance()));
    }
    public double getVelocity(long timeFirst,long timeLast, double distanceStart, double distanceEnd){
    	return (timeLast-timeFirst)/(distanceStart-distanceEnd);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
