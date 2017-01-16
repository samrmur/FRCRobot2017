/**
 * NAME: Samer Alabi
 * CLASS: DriveToDistance
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class is a command which will make the robot drive for a certain distance then it will stop
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// Start of DriveToDistance
public class DriveToDistance extends Command {
	// Declare distance variable
	private double distance;
	private double speed;
	private double curve;
	
	/**
	 * Robot will drive until it hits a certain distance (in meters)
	 * @param distance is the distance the robot will travel
	 * @param speed is the speed the robot will travel at (+1 to -1)
	 * @param curve is the speed the robot will turn at
	 */
    public DriveToDistance(double distance, double speed, double curve) {
    	// Get required subsystems
    	requires(Robot.driveTrain);
        requires(Robot.encoder);
        
        // Store parameter variables
        this.distance = distance;
        this.speed = speed;
        this.curve = curve;
    } // End of constructor

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.encoder.reset();
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.drive(speed, curve);
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.encoder.getDistance() >= distance) {
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
    } // End of method
} // End of class
