/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2710.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int DRIVETRAIN_FRONT_LEFT_TALON = 1;
	public static final int DRIVETRAIN_REAR_LEFT_TALON = 0;
	
	public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 3;	
	public static final int DRIVETRAIN_REAR_RIGHT_TALON = 2;
	
	public static final int DRIVETRAIN_ENCODER_A = 3;
	public static final int DRIVETRAIN_ENCODER_B = 4;	
	public static final int DRIVETRAIN_SOLENOID = 2;
	
	public static final int JOYSTICK_DRIVER = 0;
	
	public static final int LOW_GEAR = 1;
	public static final int HIGH_GEAR = 2;
	
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 2;
}
