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
public class MoveUntilClick extends Command {
	// Declare variables
	private double speed;
	private double turn;
	
	/**
	 * Moves the robot until a limit switch is activated using programmer provided speed and turn
	 * @param speed is the speed the robot will travel at (between +1 to -1 only)
	 * @param turn is the speed that the robot will turn at
	 */
    public MoveUntilClick(double speed, double turn) {
    	// Get required subsystems
    	requires(Robot.driveTrain);
        requires(Robot.limitSwitch);
        
        // Store parameter values into class variables
        this.speed = speed;
        this.turn = turn;
    } // End of constructor 

    // Called just before this Command runs the first time
    protected void initialize() {
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.drive(speed, turn);
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Run command until limit switch is activated
    	if (Robot.limitSwitch.getValue()) {
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
