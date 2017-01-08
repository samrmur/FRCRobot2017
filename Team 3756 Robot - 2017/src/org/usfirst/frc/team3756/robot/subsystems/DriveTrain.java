/**
 * NAME: Samer Alabi
 * CLASS: DriveTrain
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class creates the subsystem needed to control the robot's drive train.
 */

package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;

// Start of DriveTrain
public class DriveTrain {
	// Declare each separate speed controller
	public SpeedController leftFront;
	public SpeedController leftMiddle;
	public SpeedController leftBack;
	public SpeedController rightFront;
	public SpeedController rightMiddle;
	public SpeedController rightBack;
	
	// Declare each Speed Controller (which will contain an array of speed controllers that will act as one)
	public SpeedController leftSide;
	public SpeedController rightSide;
	
	// Declare the robot drive train
	public RobotDrive driveRobot;

	public DriveTrain() {
		// Initialize each speed controller
		leftFront = new VictorSP(0);
		leftMiddle = new VictorSP(1);
		leftBack = new VictorSP(2);
		rightFront = new VictorSP(3);
		rightMiddle = new VictorSP(4);
		rightBack = new VictorSP(5);
		
		// Declare and initialize each speed controller array
		SpeedController[] leftSideMotors = {leftFront, leftMiddle, leftBack};
		SpeedController[] rightSideMotors = {rightFront, rightMiddle, rightBack};
		
		// Initialize the speed controller arrays (making them act as one speed controller each)
		leftSide = new SpeedControllerArray(leftSideMotors);
		rightSide = new SpeedControllerArray(rightSideMotors);
		
		// Initialize the drive train
		driveRobot = new RobotDrive(leftSide, rightSide);
	    driveRobot.setSafetyEnabled(false);
	} // End of method
	
	// Use to drive subsystem in teleop mode
	public void drive(XboxController driveController){
		driveRobot.arcadeDrive(driveController);
	} // End of method
	
	// Use these methods for autonomous mode
	public void drive(double straight, double turn){
		driveRobot.arcadeDrive(straight, turn);
	} // End of method
	public void stopDT(){
		driveRobot.arcadeDrive(0,0);
	} // End of method
	
	// Initial command launched by this subsystem
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    } // End of method
} // End of class
