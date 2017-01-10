/**
 * NAME: Samer Alabi
 * CLASS: DriveWithController
 * PROJECT: Team 3756 - Robot
 * DESCRIPTION: This command will allow the robot to drive using in Command format with an Xbox Controller
 */

package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// Start of DriveWithController
public class DriveWithController extends Command {

    public DriveWithController() {
    	// Get the subsystem
    	requires(Robot.driveTrain);
    } // End of method

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.drive(Robot.oi.getController(), 2, 4);
    } // End of method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
