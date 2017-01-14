/**
 * NAME: Samer Alabi
 * CLASS: DriveTrain
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class creates the subsystem needed to control the robot's drive train.
 */

package org.usfirst.frc.team3756.robot.subsystems;

import org.usfirst.frc.team3756.robot.commands.DriveWithController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of DriveTrain
public class DriveTrain extends Subsystem {
	// Declare each separate speed controller
	private SpeedController leftFront;
	private SpeedController leftMiddle;
	private SpeedController leftBack;
	private SpeedController rightFront;
	private SpeedController rightMiddle;
	private SpeedController rightBack;
	
	// Declare each Speed Controller (which will contain an array of speed controllers that will act as one)
	private SpeedController leftSide;
	private SpeedController rightSide;
	
	// Declare the robot drive train
	public RobotDrive driveRobot;
	
	/**
	 * Creates a subsystem which will allow the robot to drive. This class allows the program to identify the victor 
	 * speed controllers connected to the robot by port. It also connects the robot's drive train speed controllers 
	 * (dependent on the side) in order to make them act two speed controllers (left and right).
	 */
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
	
	/**
	 * Allows the robot to be driven by an Xbox Controller using any axis from either joystick on the controller 
	 * for vertical movement and horizontal movement.
	 * @param driveController is an Xbox Controller connecting to the drive station.
	 * @param moveAxis is the port for the controller's left or right stick axis used to move the robot forwards or backwards.
	 * @param rotateAxis is the port for the controller's left or right stick axis used to move the robot left or right.
	 */
	public void drive(XboxController driveController, int moveAxis, int rotateAxis){
		driveRobot.arcadeDrive(driveController, moveAxis, driveController, rotateAxis);
	} // End of method
	
	/**
	 * Allows the robot to be driven autonomously using 
	 * @param straight is an Xbox Controller connecting to the drive station.
	 * @param turn is the port for the controller's left or right stick axis used to move the robot forwards or backwards.
	 */
	public void drive(double straight, double turn){
		driveRobot.arcadeDrive(straight, turn);
	} // End of method
	
	/**
	 * Stops the robot from moving at all
	 */
	public void stopDT(){
		driveRobot.arcadeDrive(0,0);
	} // End of method
	
	// Initial command launched by this subsystem
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithController());
    } // End of method
} // End of class
