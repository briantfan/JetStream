package org.usfirst.frc.team2710.robot.subsystems;

import org.usfirst.frc.team2710.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Intake to gather blocks.
 */
public class Intake extends Subsystem {

	public static final boolean DEBUG = false;

	private WPI_VictorSPX leftVictor;
	private WPI_VictorSPX rightVictor;
	
	private Solenoid intakeSolenoid;
	
	public Intake() {
		super();
		debug("constructor called");
		leftVictor = Util.createVictor(RobotMap.INTAKE_LEFT_VICTOR);
		rightVictor = Util.createVictor(RobotMap.INTAKE_RIGHT_VICTOR);
		intakeSolenoid = new Solenoid(RobotMap.INTAKE_SOLENOID);
	}
	
	public void intakeMotorFront() {
		rightVictor.set(ControlMode.PercentOutput, -0.5);
		leftVictor.set(ControlMode.PercentOutput, -0.5);
	}
	
	public void intakeMotorBack() {
		rightVictor.set(ControlMode.PercentOutput, 0.5);
		leftVictor.set(ControlMode.PercentOutput, 0.5);
	}
	
	public void stopIntake() {
		rightVictor.set(ControlMode.PercentOutput, 0);
		leftVictor.set(ControlMode.PercentOutput, 0);
	}
	
	public void openIntake() {
		intakeSolenoid.set(true);
	}
	
	public void closeIntake() {
		intakeSolenoid.set(false);
	}

	@Override
    public void initDefaultCommand() {
    }
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("Intake Subsystem: " + s);
		}
	}
}

