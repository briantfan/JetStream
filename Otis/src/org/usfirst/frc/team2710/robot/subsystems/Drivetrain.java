package org.usfirst.frc.team2710.robot.subsystems;

import org.usfirst.frc.team2710.robot.RobotMap;
import org.usfirst.frc.team2710.robot.commands.DriveCommand;

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
	
	public static final boolean DEBUG = false;
	// TODO: figure out the diameter
	// diameter is 6 inches, convert to feet
	public static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI / 12;

	private WPI_TalonSRX leftTalon;
	private WPI_TalonSRX rightTalon;
	
	private WPI_VictorSPX leftVictor;
	private WPI_VictorSPX rightVictor;
	
	private Solenoid driveSolenoid;
	
	private Encoder driveEncoder;
	
	private DifferentialDrive differentialDrive;
	
	public Drivetrain() {
		super();
		debug("constructor called");
		leftTalon = Util.createTalon(RobotMap.DRIVETRAIN_LEFT_TALON);
		rightTalon = Util.createTalon(RobotMap.DRIVETRAIN_RIGHT_TALON);
		
		leftVictor = Util.createVictor(RobotMap.DRIVETRAIN_LEFT_VICTOR);
		rightVictor = Util.createVictor(RobotMap.DRIVETRAIN_RIGHT_VICTOR);
		
		SpeedControllerGroup leftGroup = new SpeedControllerGroup(leftTalon, leftVictor);
		SpeedControllerGroup rightGroup = new SpeedControllerGroup(rightTalon, rightVictor);
		
		/*
		// TODO: figure out if this is useful or else delete it
		leftVictor.follow(leftTalon);
		rightVIctor.follow(rightTalon);
		*/
		
		driveSolenoid = new Solenoid(RobotMap.DRIVETRAIN_SOLENOID);
		
		driveEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_A, RobotMap.DRIVETRAIN_ENCODER_B);
		driveEncoder.setDistancePerPulse(WHEEL_CIRCUMFERENCE);
		
		differentialDrive = new DifferentialDrive(leftGroup, rightGroup);
		differentialDrive.setSafetyEnabled(false);
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
		debug("shiftUp called");
		// TODO: VERIFY SHIFTING UP IS TRUE/FALSE
		driveSolenoid.set(true);
	}
	
	public void shiftDown() {
		debug("shiftDown called");
		// TODO: VERIFY SHIFTING UP IS TRUE/FALSE
		driveSolenoid.set(false);
	}
	
	public void resetDistance() {
		debug("resetDistance called");
		driveEncoder.reset();
	}

	public double getDistance() {
		debug("getDistance: " + driveEncoder.getDistance());
		return driveEncoder.getDistance();	
	}
	
	@Override
	public void initDefaultCommand() {
		debug("initDefaultCommand to DriveCommand");
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveCommand());
	}
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("Drivetrain Subsystem: " + s);
		}
	}
}
