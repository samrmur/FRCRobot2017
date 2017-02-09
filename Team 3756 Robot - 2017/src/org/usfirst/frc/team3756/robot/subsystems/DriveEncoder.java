/**
 * NAME: Samer Alabi
 * CLASS: DriveEncoder
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: Uses an Encoder to calculate the distance a robot has traveled 
 */

package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of DriveEncoder
public class DriveEncoder extends Subsystem {
	// Declare Encoder objects
	private Encoder rightWheelEncoder;
	private Encoder leftWheelEncoder;
	
	// Declare and initialize constants
	private static final double WHEEL_CIRCUMFERENCE = 1.0 * Math.PI; // Wheel Diameter multiplied by PI (3.14....)
	private static final double PULSES_PER_REVOLUTION = 256 / 4; // PPR divided by encoding scale
	private static final double GEAR_RATIO = 1.0; 
	private static final double DISTANCE_PER_PULSE = WHEEL_CIRCUMFERENCE / (PULSES_PER_REVOLUTION * GEAR_RATIO);  // Get the distance per pulse
	
	/**
	 * Creates an Encoder object that will detect the distance the robot has traveled
	 */
	public DriveEncoder() {
		// Instantiate Encoder objects
		rightWheelEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		leftWheelEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		
		// Sets distance per pulse for both encoders
		leftWheelEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightWheelEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	} // End of constructor 
	
	/**
	 * Gets clicks of the right encoder based on encoding type 
	 * @return clicks as an integer
	 */
	public int showRightClicks(){
		return rightWheelEncoder.get();
	} // End of method
	
	/**
	 * Gets clicks of the left encoder based on encoding type
	 * @return clicks as an integer
	 */
	public int showLeftClicks(){
		return leftWheelEncoder.get();
	} // End of method

	/**
	 * Get the current distance the robot has traveled from the right encoder
	 */
	public double getRightWheelDistance() {
		return rightWheelEncoder.getDistance();
	} // End of method
	
	/**
	 * Get the current distance the robot has traveled from the left encoder
	 */
	public double getLeftWheelDistance() {
		return leftWheelEncoder.getDistance();
	} // End of method
	
	/**
	 *  Reset the count of both encoders
	 */
	public void reset() {
		rightWheelEncoder.reset();
		leftWheelEncoder.reset();
	} // End of method
	
	public void initDefaultCommand() {
    } // End of method
} // End of class
