/**
 * NAME: Samer Alabi
 * CLASS: DriveAngle
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: Drives the robot in 90 degree increment
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// Start of DriveAngle
public class DriveAngle extends Command {
	// Declare instance variables
	private int angleDirection;
	
	/**
	 * Drives the robot in 90 degree increments
	 * @param angleDirection is the direction the robot will move in (-1 for left, 1 for right)
	 */
    public DriveAngle(int angleDirection) {
    	// Get required subsystems
        requires(Robot.encoder);
        requires(Robot.driveTrain);
        
        // Initialize instance variables
        this.angleDirection = angleDirection;
    } // End of the constructor

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Reset encoder values
    	Robot.encoder.reset();
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// If direction is left, spin left 90 degrees, if right, spin right 90 degrees, else don't move
    	if (angleDirection == -1) {
    		Robot.driveTrain.driveSpeedControllers(-0.5, 0.5);
    	}
    	else if (angleDirection == 1) {
    		Robot.driveTrain.driveSpeedControllers(-0.5, 0.5);
    	}
    	else {
    		Robot.driveTrain.driveSpeedControllers(0, 0);
    	} // End of if statement
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.encoder.showLeftClicks() > 925 || Robot.encoder.showRightClicks() < -925) {
    		return true;
    	}
    	else {
    		return false;
    	}
    } // End of method

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the robot from moving
    	Robot.driveTrain.driveSpeedControllers(0, 0);
    } // End of method

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    } // End of method
} // End of class
