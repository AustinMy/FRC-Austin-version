package org.usfirst.frc.team5243.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static int frontLeftMotor = 3;
    public static int backLeftMotor = 5;
    public static int frontRightMotor = 2;
    public static int backRightMotor = 4;
    public static int middleMotor1 = 1;
    public static int middleMotor0 = 0;
    public static int liftMotor = 6;
    public static int leftJoystick = 1;//far back right port is 1
    public static int rightJoystick= 0;//left side port is 0 
    public static int ultraOutput = 7;
    public static int ultraInput = 8;

    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    public static int rangefinderPort = 1;
    public static int rangefinderModule = 1;
    
}
