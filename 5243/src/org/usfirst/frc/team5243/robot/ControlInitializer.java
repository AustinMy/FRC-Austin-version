package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.LiftCommand;
import org.usfirst.frc.team5243.robot.commands.StrafeCommand;
import org.usfirst.frc.team5243.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.MotorSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;



public class ControlInitializer {
    private double strafeSpeed;
    
    private final Joystick leftStick = new Joystick(RobotMap.leftJoystick), rightStick = new Joystick(RobotMap.rightJoystick);

    private final DigitalInput limitSwitchBottom = new DigitalInput(0); //Parameter is the channel
    private final DigitalInput limitSwitchFirst = new DigitalInput(4);
    private final DigitalInput limitSwitchSecond = new DigitalInput(2);
    private final DigitalInput limitSwitchThird = new DigitalInput(3);
    private final DigitalInput limitSwitchTop= new DigitalInput(1);
    
    private int direction = 0;
    private double speed;
    
    public final static SensorSubsystem sensorSubsystem = new SensorSubsystem();
	public final static CameraSubsystem cameraSubsystem = new CameraSubsystem();
	public final static MotorSubsystem motorSubsystem = new MotorSubsystem();
	public final static LiftSubsystem liftSubsystem = new LiftSubsystem();
	
	//This is the limit switch. The constructor parameter is the channel its plugged into. 
	//private final DigitalInput limitSwitch = new DigitalInput(1);
	//private Encoder encoder = new Encoder(2,7); // constructor parameters will change
	private Button strafeTriggerLeft, strafeTriggerRight, liftUp, liftDown;
	
	public ControlInitializer() {
		speed=0;
		System.out.println("controlInitializer");
				//deleted speedUp and slowDown
			strafeTriggerLeft = new JoystickButton(leftStick, 1); 
			strafeTriggerRight = new JoystickButton(rightStick, 1);
			liftUp= new JoystickButton(rightStick, 3);
			liftDown=new JoystickButton(rightStick,2);
		strafeSpeed=0;
		liftUp.whenPressed( new LiftCommand(1,1));
		liftDown.whenPressed(new LiftCommand(-1,1));
		//left is false right is true
		strafeTriggerLeft.whenPressed(new StrafeCommand(-1));
		strafeTriggerRight.whenPressed(new StrafeCommand(1));
		
	}
	/**
	 * sets the button speed making sure it does not exceed 1 or go below 0(negative speed is handled when moving left or right)
	 * @param s new speed the robot should go between 0 and 1
	 * @return false if the speed given(s) exceeds 1 or goes below 0: true if speed was changed to intended value;
	 */
	public boolean setStrafeSpeed(double s){
		if(s>1){
			strafeSpeed =1;
			return false;
		}
		else if(s<0){
			strafeSpeed=0;
			return false;
		}
		else{
			strafeSpeed =s;
			return true;
		}
	}
	public double getStrafeSpeed(){
		return strafeSpeed;
	}
	/**
	 * Get the left joystick
	 */
    public Joystick getLeftStick() {
    	return leftStick;
    }
    /**
     * Get the right joystick 
     */
    public Joystick getRightStick() {
    	return rightStick;
    }
    /**
     * Get the trigger on the LEFT joystick that allows for strafing 
     */
    public Button getLeftStrafeTrigger() {
    	return strafeTriggerLeft;
    }
    /**
     * Get the trigger on the RIGHT joystick that allows for strafing 
     */
    public Button getRightStrafeTrigger() {
    	return strafeTriggerRight;
    }
    
    public DigitalInput getLimitSwitchBottom(){
    	return limitSwitchBottom;
    }
    
    public DigitalInput getLimitSwitchFirst(){
    	return limitSwitchFirst;
    }
    
    public DigitalInput getLimitSwitchSecond(){
    	return limitSwitchSecond;
    }
    
    public DigitalInput getLimitSwitchThird(){
    	return limitSwitchThird;
    }
    
    public DigitalInput getLimitSwitchTop(){
    	return limitSwitchTop;
    }
    
    public int getDirection() {
    	return direction;
    }
	public void setDirection(int dir) {
		direction=dir;
	}
	public double getSpeed(){
		return speed;
	}
	public void setSpeed(double d){
		speed=d;
	}
}

