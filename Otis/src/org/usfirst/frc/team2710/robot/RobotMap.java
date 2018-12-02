package org.usfirst.frc.team2710.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Drivetrain hardware
	public static final int DRIVETRAIN_LEFT_TALON = 15;
	public static final int DRIVETRAIN_RIGHT_TALON = 0;
	public static final int DRIVETRAIN_LEFT_VICTOR = 14;
	public static final int DRIVETRAIN_RIGHT_VICTOR = 1;
	
	public static final int DRIVETRAIN_SOLENOID = 2;
	public static final int DRIVETRAIN_ENCODER_A = 3;
	public static final int DRIVETRAIN_ENCODER_B = 4;	
	
	// Elevator hardware
	public static final int ELEVATOR_LEFT_TALON = 12;
	public static final int ELEVATOR_RIGHT_TALON = 3;
	public static final int ELEVATOR_LEFT_VICTOR = 11;
	public static final int ELEVATOR_RIGHT_VICTOR = 4;	
	
	public static final int ELEVATOR_ARM_SOLENOID = 0;
		
	// Intake hardware
	public static final int INTAKE_LEFT_VICTOR = 10;
	public static final int INTAKE_RIGHT_VICTOR = 5;
	public static final int INTAKE_SOLENOID = 1;

	// Drive joystick/buttons
	public static final int JOYSTICK_DRIVER = 0;
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 0;
	public static final int LOW_GEAR = 6;
	public static final int HIGH_GEAR = 5;
	
	// Aux joystick/buttons
	public static final int JOYSTICK_AUX = 1;
	public static final int AUX_ELEVATOR_AXIS = 1;
	public static final int INTAKE_FRONT = 2;
	public static final int INTAKE_BACK = 3;
	public static final int INTAKE_OPEN = 8;
	public static final int INTAKE_CLOSE = 6;
	public static final int ARM_ON = 7;
	public static final int ARM_OFF = 5;
}
