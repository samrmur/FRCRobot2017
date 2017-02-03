/**
 * NAME: Samer Alabi
 * CLASS: DriveEncoder
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION:
 */

package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;

// Start of DriveEncoder
public class DriveEncoder extends Subsystem {
	// Declare Encoder object
	private Encoder rightWheelEncoder;
	private Encoder leftWheelEncoder;
	
	/* Declare and initialize variables 
	 * These variables are measured by the team and not by the program 
	 * Once you are able to see counts/pulses, you can push your robot 
	 * a fixed distance and enter the distance you pushed it below 
	 * and the number of counts your encoder reported for the distance
	 */
	private static final double DISTANCE_MEASURED = 3; // Change as needed
	private static final double PULSE_MEASURED = 2; // Change as needed
	
	// Get the distance per pulse
	private static final double DISTANCE_PER_PULSE = DISTANCE_MEASURED / PULSE_MEASURED;
	
	/**
	 * Creates an Encoder object that will detect the distance the robot has traveled
	 */
	public DriveEncoder() {
		// Instantiate Encoder object
		// Connection is at 4 instead of 1 because there seems t be a problem with port 1
		rightWheelEncoder = new Encoder(0, 4, true, Encoder.EncodingType.k4X);
		leftWheelEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
	
		// Setup Encoder object
		rightWheelEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		leftWheelEncoder.setDistancePerPulse(DISTANCE_PER_PULSE); 
	
//		rightWheelEncoder.setMaxPeriod(0.1);
//		rightWheelEncoder.setMinRate(10);
//		rightWheelEncoder.setReverseDirection(true);
//		rightWheelEncoder.setSamplesToAverage(7);
//		
//		leftWheelEncoder.setMaxPeriod(0.1);
//		leftWheelEncoder.setMinRate(10);
//		leftWheelEncoder.setReverseDirection(true);
//		leftWheelEncoder.setSamplesToAverage(7);
	} // End of constructor 
	
	public int showRightClicks(){
		return rightWheelEncoder.getRaw();
	}
	
	public int showLeftClicks(){
		return leftWheelEncoder.getRaw();
	}
	
	/**
	 *  Reset the count of the encoder
	 */
	public void reset() {
		rightWheelEncoder.reset();
		leftWheelEncoder.reset();
	} // End of method
	
	/**
	 * Get the current distance the robot has traveled
	 */
	public double getRightWheelDistance() {
		return rightWheelEncoder.getDistance();
	} // End of method
	
	public double getLeftWheelDistance() {
		return leftWheelEncoder.getDistance();
	} // End of method
	
	public ITable getRightTable(){
		return rightWheelEncoder.getTable();
	}
	
	public ITable getLeftTable(){
		return leftWheelEncoder.getTable();
	}
	
	public double getRightRate(){
		return rightWheelEncoder.getRate();
	}
	
	public double getLeftRate(){
		return leftWheelEncoder.getRate();
	}
	
	public void initDefaultCommand() {
    } // End of method
} // End of class
