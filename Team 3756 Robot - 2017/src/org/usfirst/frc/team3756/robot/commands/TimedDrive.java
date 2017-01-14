/**
 * NAME: Samer Alabi
 * CLASS: TimedDrive
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class is an autonomous command called when the robot is required to move to a position on its own
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

// Start of TimedDrive
public class TimedDrive extends Command {
	// Declare variables
	private Timer timer;
	private double time;
	private double speed;
	private double turn;
	
	/**
	 * Moves the robot autonomously for a certain amount of time and speed.
	 * @param providedTime is the amount of time the robot will use the command for 
	 * @param providedSpeed is the speed the robot will travel at (+ for forwards, - for backwards)
	 * @param providedTurn is the speed the robot will turn at
	 */
    public TimedDrive(double providedTime, double providedSpeed, double providedTurn) {
    	// Initialize or change variables based on parameters
    	time = providedTime;
    	speed = providedSpeed;
    	turn = providedTurn;
    	
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    } // End of method

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.start();
    } // End of method

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.drive(speed, turn);
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get() >= time){
    		return true;
    	}
    	else return false;
    } // End of method

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0,0);
    	timer.stop();
    } // End of method

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    } // End of method
} //End of class
