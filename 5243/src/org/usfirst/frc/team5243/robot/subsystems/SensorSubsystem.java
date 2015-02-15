package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {
    
    Ultrasonic ultraSasquatch;
    public SensorSubsystem() {
    	ultraSasquatch = new Ultrasonic(RobotMap.ultraOutput, RobotMap.ultraInput);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double getDistance() {
    	return ultraSasquatch.getRangeInches();    	
    }
    public void initializeSensor() {
    	ultraSasquatch.setAutomaticMode(true);
    }
    public void destroySensor() {
    	ultraSasquatch.setAutomaticMode(false);
    }
}

