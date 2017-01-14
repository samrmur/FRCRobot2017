/**
 * NAME: Samer Alabi
 * CLASS: DriveEncoder
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION:
 */

package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of DriveEncoder
public class DriveEncoder extends Subsystem {
	// Declare Encoder object
	public Encoder wheelEncoder;
	
	/* Declare and initialize variables 
	 * These variables are measured by the team and not by the program 
	 * Once you are able to see counts/pulses, you can push your robot 
	 * a fixed distance and enter the distance you pushed it below 
	 * and the number of counts your encoder reported for the distance
	 */
	private static final double DISTANCE_MEASURED = 0; // Change as needed
	private static final double PULSE_MEASURED = 0; // Change as needed
	
	// Get the distance per pulse
	private static final double DISTANCE_PER_PULSE = DISTANCE_MEASURED / PULSE_MEASURED;
	
	/**
	 * Creates an Encoder object that will detect the distance the robot has traveled
	 */
	public DriveEncoder() {
		// Instantiate Encoder object
		wheelEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		
		// Setup Encoder object
		wheelEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	} // End of constructor 
	
	/**
	 *  Reset the count of the encoder
	 */
	public void reset() {
		wheelEncoder.reset();
	} // End of method
	
	/**
	 * Get the current distance the robot has traveled
	 */
	public double getDistance() {
		return wheelEncoder.getDistance();
	} // End of method
	
    public void initDefaultCommand() {
    } // End of method
} // End of class

