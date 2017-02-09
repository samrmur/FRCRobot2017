package org.usfirst.frc.team3756.robot.commandgroups;

import org.usfirst.frc.team3756.robot.commands.DriveAngle;
import org.usfirst.frc.team3756.robot.commands.DriveToDistance;
import edu.wpi.first.wpilibj.command.CommandGroup;

// Start of AutoCommandGroup1
public class AutoCommandGroup1 extends CommandGroup {
    public AutoCommandGroup1() {
    	addSequential(new DriveToDistance(2, -0.5));
    	addSequential(new DriveAngle(-1));
    	addSequential(new DriveToDistance(2, -0.5));
    } // End of Method
} // End of class