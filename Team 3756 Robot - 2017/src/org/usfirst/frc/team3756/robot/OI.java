/**
 * NAME: Samer Alabi
 * CLASS: OI
 * PROJECT: Team 3756 Robot - 2017
 * DESCRIPTION: This class is the glue that binds the controls on the physical operator interface to the 
 * commands and command groups that allow control of the robot.
 */

package org.usfirst.frc.team3756.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// Start of OI class
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
		//xboxStartButton.whenPressed(new someCommand());
		
		JoystickButton xboxStartButton = new JoystickButton(userController, 8);
		//xboxStartButton.whenPressed(new someCommand());
		
		JoystickButton xboxLeftStickButton = new JoystickButton(userController, 9);
		//xboxLeftStickButton.whenPressed(new someCommand());
		
		JoystickButton xboxRightStickButton = new JoystickButton(userController, 10);
		//xboxRightStickButton.whenPressed(new someCommand());
	} // End of constructor
	
	public XboxController getController() {
		return userController;
	} // End of method
} // End of class
