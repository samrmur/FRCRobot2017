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
	public DigitalInput limitSwitch;
	
	/**
	 * Limit Switch subsystem used only in autonomous mode
	 */
	public LimitSwitch() {
		limitSwitch = new DigitalInput(9);
	} // End of constructor

	/**
	 * Gets the boolean of true or false dependent on if the limit switch is activated
	 */
	public Boolean getValue() {
		if (limitSwitch.get()) {
			return true;
		} 
		else {
			return false;
		} // End of if statement
	} // End of method
	
    public void initDefaultCommand() {
    } // End of method
} // End of class

