/**
 * NAME: Samer Alabi
 * CLASS: ConveyerBelt
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class is defines the conveyer belt subsystem into the program which will be used to collect fuel 
 * balls off the field so that points can be scored with them.
 */
package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of ConveyerBelt
public class ConveyerBelt extends Subsystem {
	// Declare object
	public Relay spikeRelay;
	
	/**
	 * Controls the conveyer belt subsystem that takes in and scores fuel balls 
	 */
	public ConveyerBelt() {
		// Instantiate object
		spikeRelay = new Relay(0);
	} // End of constructor
	
	/**
	 * Sets relay to forward mode
	 */
	public void relayForward() {
		spikeRelay.set(Relay.Value.kForward);
	} // End of method
	
	/**
	 * Sets relay to reverse mode
	 */
	public void relayReverse() {
		spikeRelay.set(Relay.Value.kReverse);
	} // End of method
	
	/**
	 * Turns both relay outputs off
	 */
	public void relayOff() {
		spikeRelay.set(Relay.Value.kOff);
	} // End of method

    public void initDefaultCommand() {
    } // End of method
} // End of class

