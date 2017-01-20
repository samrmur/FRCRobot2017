package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

// Start of RobotDriveXbox
public class RobotDriveXbox extends RobotDrive {

	public RobotDriveXbox(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
	} // End of constructor
	
	public void arcadeDrive(GenericHID moveStick, final int forwardAxis, final int backwardAxis, GenericHID rotateStick, final int rotateAxis) {
		double moveValue = moveStick.getRawAxis(forwardAxis) - moveStick.getRawAxis(backwardAxis);
		double rotateValue = rotateStick.getRawAxis(rotateAxis);
		
		arcadeDrive(moveValue, rotateValue, true);
	} // End of method
} // ENd of class

