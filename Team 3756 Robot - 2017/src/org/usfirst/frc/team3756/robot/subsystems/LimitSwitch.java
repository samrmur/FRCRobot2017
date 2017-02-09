/**
 * NAME: Samer Alabi
 * CLASS: LimitSwitch
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class creates a limit switch subsystem which will do something based on whether the limit 
 * switch s activated
 */

package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

// Start of LimitSwitch
public class LimitSwitch extends Subsystem {
	private DigitalInput leftLimitSwitch;
	private DigitalInput rightLimitSwitch;
	
	/**
	 * Limit Switch subsystem used only in autonomous mode
	 */
	public LimitSwitch() {
		leftLimitSwitch = new DigitalInput(8);
		rightLimitSwitch = new DigitalInput(9);
	} // End of constructor

	/**
	 * Gets the boolean of true or false dependent on if the left side limit switch is activated
	 */
	public Boolean getLeftValue() {
		if (leftLimitSwitch.get()) {
			return true;
		} 
		else {
			return false;
		} // End of if statement
	} // End of method
	
	/**
	 * Gets the boolean of true or false dependent on if the right side limit switch is activated
	 */
	public Boolean getRightValue() {
		if (rightLimitSwitch.get()) {
			return true;
		} 
		else {
			return false;
		} // End of if statement
	} // End of method
	
    public void initDefaultCommand() {
    } // End of method
} // End of class

