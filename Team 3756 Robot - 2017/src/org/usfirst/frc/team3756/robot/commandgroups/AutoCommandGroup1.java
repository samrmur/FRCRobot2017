package org.usfirst.frc.team3756.robot.commandgroups;

import org.usfirst.frc.team3756.robot.commands.TimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

// Start of autoCommandGroup1
public class AutoCommandGroup1 extends CommandGroup {

    public AutoCommandGroup1() {
        // Example Group
    	addSequential(new TimedDrive(2.5, 1, 1));
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    } // End of Method
} // End of class
