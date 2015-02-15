package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.ControlInitializer;
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
	private Talon liftMotor;
	private int level;
	public LiftSubsystem(){
		liftMotor = new Talon(RobotMap.liftMotor);
		level =0;
		System.out.println("liftSub");
		liftMotor.set(0);
	}
    public void initDefaultCommand() {
        
    }
    
    /*
     * Returns the level of the lift (?)
     */
    public int getLevel(){
    	return level;
    }
    
    /*
     * Increases the level of the lift if it is less than 4
     */
    public void increaseLevel(){
    	if (level < 4) {
    		level++;
    	}
    }
    
    public void decreaseLevel(){
    	if (level > 0) {
    	level--;
    	}
    }
    
	public Talon getLiftMotor(){
		return liftMotor;
	} 
	public void stopLift() {
		liftMotor.set(0);
	}
	public boolean checkLimits(int direction){

		if(level==4&&direction>0){
			return true;
		}
		
		if(level==0&&direction<0){
			return true;
		}
		return false;
	}
	public boolean getSwitches(int direction){
		if(Robot.oi.getLimitSwitchBottom().get()&&level!=0) {
			System.out.println("BottomSwitch pushed");
			level =0;
			return true;
		}
		
		else if (Robot.oi.getLimitSwitchFirst().get()&&level!=1) {
			System.out.println("first level pushed");
			level=1;
			return true;
		}
		
		else if (Robot.oi.getLimitSwitchSecond().get()&&level!=2) {
			System.out.println("2nd level Pushed");
			level =2;
			return true;
		}
		
		else if (Robot.oi.getLimitSwitchThird().get()&&level!=3) {
			System.out.println("3rd level Pushed");
			level =3;
			return true;
		}
		
		else if(Robot.oi.getLimitSwitchTop().get()&&level!=4) {
			System.out.println("TopSwitch Pushed");
			level =4;
			return true;
		}
		else{
			level =-1;
		}
		if (direction == 0) {
			return true;
		}
		return false;
	}
	public void startLift(int d){
		liftMotor.set(d * 0.5);
	}
	
	
	
}

