package org.usfirst.frc.team3756.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3756.robot.commandgroups.autoCommandGroup1;
import org.usfirst.frc.team3756.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Declare and instantiate the Xbox controller object
	private XboxController userController = new XboxController(0);
	
	// Constructor of the class
	public OI() {
		// Create JoystickButton objects for any required buttons to control the robot
		JoystickButton xboxAButton = new JoystickButton(userController, 1);
		//xboxAButton.whileHeld(new someCommand());
		//xboxAButton.whenReleased(new someCommand());
		JoystickButton xboxBButton = new JoystickButton(userController, 2);
		//xboxBButton.whileHeld(new someCommand());
		//xboxBButton.whenReleased(new someCommand());
		JoystickButton xboxXButton = new JoystickButton(userController, 3);
		//xboxXButton.whileHeld(new someCommand());
		//xboxXButton.whenReleased(new someCommand());
		JoystickButton xboxYButton = new JoystickButton(userController, 4);
		//xboxYButton.whileHeld(new someCommand());
		//xboxYButton.whenReleased(new someCommand());
		JoystickButton xboxLeftBumper = new JoystickButton(userController, 5);
		//xboxLeftBumper.whileHeld(new someCommand());
		//xboxLeftBumper.whenReleased(new someCommand());
		JoystickButton xboxRightBumper = new JoystickButton(userController, 6);
		//xboxRightBumper.whileHeld(new someCommand());
		//xboxRightBumper.whenReleased(new someCommand());
		JoystickButton xboxBackButton = new JoystickButton(userController, 7);
		//xboxBackButton.whileHeld(new someCommand());
		//xboxBackButton.whileReleased(new someCommand());
	} // End of constructor
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
