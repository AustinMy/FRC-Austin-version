package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5243.robot.Robot;

public class StrafeSpeedCommand extends Command{
  double speed;
  
  public StrafeSpeedCommand(double d){
    speed = d;
  }
  
  public void initialize(){
	  
  }
  
  public void start() {//if there is  start method execute will never run
	  System.out.println("in Start strafespeed command:"+ speed);
	  if(speed==.1||speed==-.1)Robot.oi.setStrafeSpeed(speed+Robot.oi.getStrafeSpeed());
	  else if(speed==0) Robot.oi.setStrafeSpeed(0);
  }
  
  protected void execute(){
	  System.out.println("execute run strafe speed command");
  }
  
  public boolean isFinished(){
	  return true;
  }
  
  public void end(){}
  
  protected void interrupted(){}
  
  
}
