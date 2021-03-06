package org.usfirst.frc.team3756.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3756.robot.commandgroups.AutoCommandGroup1;
import org.usfirst.frc.team3756.robot.commandgroups.AutoCommandGroup2;
import org.usfirst.frc.team3756.robot.subsystems.DriveEncoder;
import org.usfirst.frc.team3756.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3756.robot.subsystems.LimitSwitch;

/**
 * The VM (Virtual Machine) is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	// Declare subsystems
	public static DriveTrain driveTrain;
	public static LimitSwitch limitSwitch;
	public static DriveEncoder encoder;
	public static UsbCamera lifeCam;
	
	// Declare Controller Mapping Class
	public static OI oi;
	
	// Declare autonomous command
	Command autonomousCommand;
	
	// Declare SendableChooser (to allow for the ability to choose commands on the SmartDashboard)
	SendableChooser<Command> autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Initialize all subsystems
        driveTrain = new DriveTrain();
		oi = new OI();
		limitSwitch = new LimitSwitch();                                                                                                                                                                                                                                                               
		encoder = new DriveEncoder();

		// Configure camera                           
		lifeCam = CameraServer.getInstance().startAutomaticCapture();
		lifeCam.setResolution(320, 240);
		lifeCam.setFPS(15);
		
		// Initialize chooser, add commands to chooser and display on the SmartDashboard
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Default Command", new AutoCommandGroup1());
		autoChooser.addObject("Position 1 Command", new AutoCommandGroup2());
		
		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData("autoChooser", autoChooser);
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(limitSwitch); 
	} // End of method
	
	/*
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable\\
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = autoChooser.getSelected();

		// Starts the command as long as one exists
		if (autonomousCommand != null)
			autonomousCommand.start();
	} // End of method

	// This function is called periodically during autonomous
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		// Update numbers on SmartDashboard
		SmartDashboard.putNumber("Current Distance of Left Encoder", encoder.getLeftWheelDistance());
	    SmartDashboard.putNumber("Current Distance of Right Encoder", encoder.getRightWheelDistance());
	    SmartDashboard.putNumber("Current Count of Left Encoder", encoder.showLeftClicks());
	    SmartDashboard.putNumber("Current Count of Right Encoder", encoder.showRightClicks());
	} // End of method

	@Override
	public void teleopInit() {
		// Stops autonomous command from continuing when tele-operated period has started
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		// Reset the encoders
		encoder.reset();
	} // End of method

	// This function is called periodically during operator control
	@Override
	public void teleopPeriodic() {
	  Scheduler.getInstance().run();
	  
	  // Update numbers on SmartDashboard
      SmartDashboard.putNumber("Current Distance of Left Encoder", encoder.getLeftWheelDistance());
      SmartDashboard.putNumber("Current Distance of Right Encoder", encoder.getRightWheelDistance());
      SmartDashboard.putNumber("Current Count of Left Encoder", encoder.showLeftClicks());
      SmartDashboard.putNumber("Current Count of Right Encoder", encoder.showRightClicks());
	} // End of method

	// This function is called periodically during test mode
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	} // End of method
} // End of class
