package org.usfirst.frc.team2710.robot.subsystems;

import org.usfirst.frc.team2710.robot.RobotMap;
import org.usfirst.frc.team2710.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Test drivetrain for practice robot
 */
public class Drivetrain extends Subsystem {
	
	public static final boolean DEBUG = true;

	private WPI_TalonSRX frontLeftTalon = null;		
	private WPI_TalonSRX rearLeftTalon = null;
	
	private WPI_TalonSRX frontRightTalon = null;
	private WPI_TalonSRX rearRightTalon = null;
	
	// TODO: enable shifting gear via solenoid
//	private boolean lowGear = true;
//	private Solenoid driveSolenoid = null;
	
	// TODO: figure out how to use this
//	private Encoder driveEncoder = null;
	
	private DifferentialDrive differentialDrive = null;
	
	public Drivetrain() {
		super();
		frontLeftTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_FRONT_LEFT_TALON);
		rearLeftTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_REAR_LEFT_TALON);
		
		frontRightTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_FRONT_RIGHT_TALON);
		rearRightTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_REAR_RIGHT_TALON);
		
		SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeftTalon, rearLeftTalon);
		SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRightTalon, rearRightTalon);
		
		/*
		// TODO: figure out if this is useful or else delete it
		leftTalonSlave.follow(leftTalon);
		rightTalonSlave.follow(rightTalon);
		
		leftTalonSlave.setNeutralMode(NeutralMode.Brake);
		rightTalonSlave.setNeutralMode(NeutralMode.Brake);
		
		leftTalonSlave.setSafetyEnabled(false);
		rightTalonSlave.setSafetyEnabled(false);
		*/
		
//		driveSolenoid = new Solenoid(RobotMap.DRIVETRAIN_SOLENOID);
		
//		driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
		
		differentialDrive = new DifferentialDrive(leftGroup, rightGroup);
//		differentialDrive.setSafetyEnabled(false);
		debug("constructor");
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		debug("arcade drive movespeed: " + moveSpeed + " rotatespeed: " + rotateSpeed);
		differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
	public void curvatureDrive(double moveSpeed, double rotateSpeed) {
		debug("curvature drive movespeed: " + moveSpeed + " rotatespeed: " + rotateSpeed);
		differentialDrive.curvatureDrive(moveSpeed, rotateSpeed, false);
	}
	
	public void shiftUp() {
		debug("shiftUp");
		// TODO: VERIFY SHIFTING UP IS TRUE/FALSE
//		driveSolenoid.set(true);
	}
	
	public void shiftDown() {
		debug("shiftDown");
		// TODO: VERIFY SHIFTING UP IS TRUE/FALSE
//		driveSolenoid.set(false);
	}

	public void initDefaultCommand() {
		debug("initDefaultCommand to DriveArcade");
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveCommand());
	}
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("Drivetrain Subsystem: " + s);
		}
	}
}
