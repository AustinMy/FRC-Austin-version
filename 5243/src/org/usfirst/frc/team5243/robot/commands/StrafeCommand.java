package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;

/* The StrafeCommand class's methods are called if, while the teleopContinuous() method is running,
 * the trigger button on the right joystick is pressed. First, initialize() is called, then execute() is called
 * continuously until the trigger button on the right joystick is released. When it is released, isFinished() is called,
 * followed by end()
 */

public class StrafeCommand extends Command {
	private double speed;
	// true is right:false is left
	private int direction;

	public StrafeCommand(int d) {
		//requires(ControlInitializer.motorSubsystem);
		if(d==1||d==-1){
			direction = d;
		}else{
			System.out.println("dont be a fool (strafeCommand)");
		}
		System.out.println("Strafe command constructor: default shouldn't be called");
		
	}

	// Called just before this Command runs the first time
	public void initialize() {
		System.out.println("Strafecommand initialize");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (!Robot.oi.getRightStrafeTrigger().get()&&direction==1) {//make with left
			System.out.println("isFinished");
			return true;
		}
		if(!Robot.oi.getLeftStrafeTrigger().get()&&direction==-1){
			System.out.println("isfinsihed left");
			return true;
			
		}
		return false;
	}

	// Called once after isFinished returns true
	public void end() {
		System.out.println("Strafing ended");
		ControlInitializer.motorSubsystem.getMiddleOne().set(0);
		ControlInitializer.motorSubsystem.getMiddleZero().set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("interrupted strafe command");
	}

	// use scheduler with these not working yet.
	
	protected void execute() {
		//System.out.println("AMAZING STRAFECOMMMAND EXECUTE HAS FINNALLY RUN!!");
		JoystickSpeed();
		Strafe(direction);
		}

	/*
	public void start() {
		System.out.println("in StrafeCommand start ");
	}*/

	/**
	 * constant speed push right go right push left go left
	 */
	private void Strafe(int d) {
		ControlInitializer.motorSubsystem.getMiddleOne().set(speed);//Talon not working as of 2/9/15 6:01
		ControlInitializer.motorSubsystem.getMiddleZero().set(speed);
		System.out.println("Speed Strafe: " + speed);
		//ControlInitializer.motorSubsystem.getMiddleOne().
	}

	/*
	 * sets the button speed making sure it does not exceed 1 or go below
	 * 0(negative speed is handled when moving left or right)
	 * 
	 * @param s new speed the robot should go between 0 and 1
	 * 
	 * @return false if the speed given(s) exceeds 1 or goes below 0: true if
	 * speed was changed to intended value;
	 */

	private void JoystickSpeed() {
		speed = Robot.oi.getRightStick().getX();
	}

}
