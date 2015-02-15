package org.usfirst.frc.team5243.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *Controls the camera will be a  big class
 */
public class CameraSubsystem extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	int session;
    Image frame;
    public void initializeCam(){
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam1",NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
    }
    public int getSession(){
    	return session;
    }
    public Image getFrame(){
    	return frame;
    }
    
    
    
}

