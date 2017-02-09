/**
 * NAME: Samer Alabi
 * CLASS: DriveTrain
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class creates the subsystem needed to control the robot's drive train.
 */

package org.usfirst.frc.team3756.robot.subsystems;

import org.usfirst.frc.team3756.robot.commands.DriveWithController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of DriveTrain
public class DriveTrain extends Subsystem {
	// Declare each separate speed controller
	private SpeedController motorR1;
	private SpeedController motorR2;
	private SpeedController motorR3;
	private SpeedController motorL1;
	private SpeedController motorL2;
	private SpeedController motorL3;

	// Declare each Speed Controller (which will contain an array of speed controllers that will act as one)
	private SpeedController leftSide;
	private SpeedController rightSide;
	                
	private DoubleSolenoid shift = new DoubleSolenoid(1, 0);
	
	// Declare the robot drive train and autonomous drives
	private RobotTriggerDrive driveRobot;
	
	/**
	 * Creates a subsystem which will allow the robot to drive. This class allows the program to identify the victor 
	 * speed controllers connected to the robot by port. It also connects the robot's drive train speed controllers 
	 * (dependent on the side) in order to make them act two speed controllers (left and right).
	 */
	public DriveTrain() {
		// Initialize each speed controller
		motorR1 = new VictorSP(0);
		motorR2 = new VictorSP(1);
		motorR3 = new VictorSP(2);
		motorL1 = new VictorSP(3);
		motorL2 = new VictorSP(4);
		motorL3 = new VictorSP(5);

		// Declare and initialize each speed controller array
		SpeedController[] leftSideMotors = {motorL1, motorL2, motorL3};
		SpeedController[] rightSideMotors = {motorR1, motorR2, motorR3};
		
		// Initialize the speed controller arrays (making them act as one speed controller each)
		leftSide = new SpeedControllerArray(leftSideMotors);
		rightSide = new SpeedControllerArray(rightSideMotors);
		
		// Initialize the drive train
		driveRobot = new RobotTriggerDrive(leftSide, rightSide);
	    driveRobot.setSafetyEnabled(false);
	} // End of method
	
	/**
	 * Shifts the robot to high gear
	 */
	public void shiftHigh(){
		shift.set(DoubleSolenoid.Value.kForward);
	} // End of shiftHigh() method
	
	/**
	 * Shifts the robot to low gear
	 */
	public void shiftLow(){
		shift.set(DoubleSolenoid.Value.kReverse);
	} // End of shiftLow() method
	
	/**
	 * Allows the robot to be driven by an Xbox Controller using any axis from either joystick on the controller 
	 * for vertical movement and horizontal movement.
	 * @param driveController is an Xbox Controller connecting to the drive station.
	 * @param forwardsTrigger is the trigger axis being used to control the forward movement of the robot
	 * @param backwardsTrigger is the trigger axis being used to control the backward movement of the robot
	 * @param rotateAxis is the port for the controller's left or right stick axis used to move the robot left or right.
	 */
	public void drive(XboxController driveController, int forwardAxis, int backwardAxis, int rotateAxis){
		driveRobot.arcadeDrive(driveController, forwardAxis, backwardAxis, rotateAxis);
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
	
	/**
	 * Drives the robot separately by speed controller
	 * @param speedLeft is the speed of the left side of the robot
	 * @param speedRight is the speed of the right side of the robot
	 */
	public void driveSpeedControllers(double speedLeft, double speedRight) {
		leftSide.set(speedLeft);
		
		// Sets the right side of the robot to inverted to account for the backward gearboxes
		rightSide.setInverted(true);
		rightSide.set(speedRight);
	} // End of method
	
	// Initial command launched by this subsystem
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithController());
    } // End of method
} // End of class
