/**
 * NAME: Samer Alabi
 * CLASS: MoveUntilClick
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class is a command that will autonomously move the robot until the limit switch is pressed down
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// Start of MoveUntilClick
public class MoveToHopper extends Command {
	// Declare instance variables
	private double speed;
	private double distance;
	
	/**
	 * Moves the robot until a limit switch is activated using programmer provided speed and turn
	 * @param speed is the speed the robot will travel at (between +1 to -1 only)
	 * @param distance is the distance from the target being traveled to 
	 */
    public MoveToHopper(double speed, double distance) {
    	// Get required subsystems
    	requires(Robot.driveTrain);
        requires(Robot.limitSwitch);
        requires(Robot.encoder);
        
        // Store parameter values into class variables
        this.speed = speed;
        this.distance = distance;
    } // End of constructor 

    // Called just before this Command runs the first time
    protected void initialize() {
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Drive the robot straight forward
    	Robot.driveTrain.driveSpeedControllers(speed, speed);
    	
    	// If robot is close to target, slow down the speed
    	if (Robot.encoder.getLeftWheelDistance() > (distance - 0.3) || Robot.encoder.getRightWheelDistance() > (distance - 0.3)) {
    		Robot.driveTrain.driveSpeedControllers(-0.2, -0.2);
    	} // End of if statement
    	
    	if (Robot.limitSwitch.getLeftValue()) {
    		Robot.driveTrain.driveSpeedControllers(0, -0.2);
    	}
    	else if (Robot.limitSwitch.getRightValue()) {
    		Robot.driveTrain.driveSpeedControllers(-0.2, 0);
    	}
    	else if (Robot.limitSwitch.getLeftValue() && Robot.limitSwitch.getRightValue()) {
    		Robot.driveTrain.stopDT();
    	}
    	
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Run command until limit switch is activated
    	if (Robot.limitSwitch.getLeftValue() && Robot.limitSwitch.getRightValue()) {
			return true;
		} 
		else {
			return false;
		} // End of if statement
    } // End of method

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopDT();
    } // End of method

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    } // End of method
} // End of class
