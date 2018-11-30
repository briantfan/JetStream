package org.usfirst.frc.team2710.robot.subsystems;

import org.usfirst.frc.team2710.robot.RobotMap;
import org.usfirst.frc.team2710.robot.commands.ElevatorCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	public static final boolean DEBUG = false;

	private WPI_TalonSRX leftTalon;
	private WPI_TalonSRX rightTalon;
	
	private WPI_VictorSPX leftVictor;
	private WPI_VictorSPX rightVictor;
	
	private SpeedControllerGroup allMotors;
	
	public Elevator() {
		super();
		debug("constructor called");
		leftTalon = Util.createTalon(RobotMap.ELEVATOR_LEFT_TALON);
		rightTalon = Util.createTalon(RobotMap.ELEVATOR_RIGHT_TALON);
		
		leftVictor = Util.createVictor(RobotMap.ELEVATOR_LEFT_VICTOR);
		rightVictor = Util.createVictor(RobotMap.ELEVATOR_RIGHT_VICTOR);
		
		allMotors = new SpeedControllerGroup(rightTalon, leftTalon, rightVictor, leftVictor);
		/*
		// TODO: figure out if this is useful or else delete it
		leftVictor.follow(leftTalon);
		rightVIctor.follow(rightTalon);
		*/
		
	}
	
	public void moveElevator(double moveSpeed) {
		debug("move elevator: " + moveSpeed);
		allMotors.set(moveSpeed);
	}

	@Override
    public void initDefaultCommand() {
		debug("initDefaultCommand to ElevatorCommand");
		// Set the default command for a subsystem here.
		setDefaultCommand(new ElevatorCommand());
    }

	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("Elevator Subsystem: " + s);
		}
	}
}

