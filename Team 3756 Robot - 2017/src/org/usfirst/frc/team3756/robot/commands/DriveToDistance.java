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
	private double speedLeft;
	private double speedRight;
	
	/**
	 * Robot will drive until it hits a certain distance (in meters)
	 * @param distance is the distance the robot will travel
	 * @param speedLeft is the speed the left side of the robot will travel at (+1 to -1)
	 * @param speedRight is the speed the right side of the robot will turn at
	 */
    public DriveToDistance(double distance, double speedLeft, double speedRight) {
    	// Get required subsystems
    	requires(Robot.driveTrain);
        requires(Robot.encoder);
        
        // Store parameter variables
        this.distance = distance;
        this.speedLeft = speedLeft;
        this.speedRight = speedRight;
    } // End of constructor

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Resets the encoder value
    	Robot.encoder.reset();
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Checks if robot is close to its destination
    	if (Robot.encoder.getLeftWheelDistance() >= (distance - 0.3) || Robot.encoder.getRightWheelDistance() >= (distance - 0.3)) {
    		// If close, close down the robot
    		Robot.driveTrain.driveSpeedControllers(-0.2, -0.2);
    	} // End of if statement
    	
    	// Checks if both encoder values fall within 10 clicks of each other
    	if ((Robot.encoder.showLeftClicks() - 10) > Robot.encoder.showRightClicks()) {
    		// If left side - 10 is bigger than right side, slow the speed of the left side down
    		Robot.driveTrain.driveSpeedControllers(speedLeft + 0.1, speedRight);
    	}
    	else if (Robot.encoder.showLeftClicks() < (Robot.encoder.showRightClicks() - 10)) {
    		// If right side - 10 is bigger than left side, slow the speed of the right side down
    		Robot.driveTrain.driveSpeedControllers(speedLeft, speedRight + 0.1);
    	}
    	else {
    		Robot.driveTrain.driveSpeedControllers(speedLeft, speedRight);
    	} // End of if statement
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// If one encoder value exceeds the required distance, stop the command
        if (Math.abs(Robot.encoder.getRightWheelDistance()) >= distance || Math.abs(Robot.encoder.getLeftWheelDistance()) >= distance) {
        	return true;
        }
        else {	
        	return false;
        } // End of if statement
    } // End of method

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.driveSpeedControllers(0, 0);
    } // End of method

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    } // End of method
} // End of class
