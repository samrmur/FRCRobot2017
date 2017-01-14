package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * A SpeedController implementation that wraps an array of one or more
 * SpeedController objects so they look like a single SpeedController (a
 * software version of a PWM splitter cable).
 */
public class SpeedControllerArray implements SpeedController {
	// Array of motors to control like one
	private SpeedController[] motors;

	public SpeedControllerArray(SpeedController[] motors) {
		if (motors.length < 1) {
			throw new IllegalArgumentException("You must pass an array of at least one SpeedController");
		} //End of if statement 
		this.motors = motors;
	} //End of SpeedControllerArray

	@Override
	public void pidWrite(double output) {
		set(output);
	} //End of pidWrite

	@Override
	public double get() {
		// Since all motors have same value, return value from first one
		return motors[0].get();
	} //End of get
	
	@Override
	public void set(double speed) {
		for (SpeedController motor : motors) {
			motor.set(speed);
		} // End of for statement
	} // End of method

	@Override
	public void setInverted(boolean isInverted) {
		for (SpeedController motor : motors) {
			motor.setInverted(isInverted);
		} //End of for statement
	} //End of setInverted

	@Override
	public boolean getInverted() {
		// Since all motors have same value, return value from first one
		return motors[0].getInverted();
	} //End of getInverted

	@Override
	public void disable() {
		for (SpeedController motor : motors) {
			motor.disable();
		} //End of for statement
	} //End of disable

	@Override
	public void stopMotor() {
	} //End of for statement
} //End of class