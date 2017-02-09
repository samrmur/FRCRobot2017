/**
 * NAME: Omar Lopez
 * CLASS: ShiftGears
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: Shift the robot between low gear and high gear
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// Start of ShiftGears
public class ShiftGears extends Command {
	// Declare instance variables
	private String changeGears;
	
	/**
	 * Shifts the robot between high and low gear
	 * @param changeGears is a string containing the gear switch
	 */
    public ShiftGears(String changeGears){
    	// Get required subsystems
    	requires(Robot.driveTrain);
    	
    	// Initialize instance variables
    	this.changeGears = changeGears;
    } // End of constructor

    // Called just before this Command runs the first time
    protected void initialize() {
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(changeGears.equals("High")){
    		Robot.driveTrain.shiftHigh();
    	}
    	else if(changeGears.equals("Low")){
    		Robot.driveTrain.shiftLow();
    	} // End of if statement
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    } // End of method

    // Called once after isFinished returns true
    protected void end() {
    } // End of method

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    } // End of method
} // End of class
