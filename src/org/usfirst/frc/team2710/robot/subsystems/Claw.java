package org.usfirst.frc.team2710.robot.subsystems;

import org.usfirst.frc.team2710.robot.RobotMap;
import org.usfirst.frc.team2710.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {

	private Solenoid solenoidOn;
	private Solenoid solenoidOff;	
	private WPI_VictorSPX victorLeft = null;
	private WPI_VictorSPX victorRight = null;
	
	public Claw() {
		super();
		solenoidOn = new Solenoid(RobotMap.CLAW_SOLENOID_NODE, RobotMap.CLAW_SOLENOID_ON);
		solenoidOff = new Solenoid(RobotMap.CLAW_SOLENOID_NODE, RobotMap.CLAW_SOLENOID_OFF);
	
		victorLeft = new WPI_VictorSPX(RobotMap.CLAW_LEFT_VICTOR);
		victorRight = new WPI_VictorSPX(RobotMap.CLAW_RIGHT_VICTOR);
		victorLeft.setNeutralMode(NeutralMode.Brake);
		victorRight.setNeutralMode(NeutralMode.Brake);
	}
	
	public void openClaw() {
		solenoidOff.set(false);
		solenoidOn.set(true);
		System.out.print("OpenClaw");
	}
	
	public void closeClaw() {
		solenoidOn.set(false);
		solenoidOff.set(true);
		System.out.print("OpenClaw");
	}
	
	public void IntakeClaw() {
		victorLeft.set(ControlMode.PercentOutput,-.5);
		victorRight.set(ControlMode.PercentOutput,-0.5);
	}
	
	public void OuttakeClaw() {
		victorLeft.set(ControlMode.PercentOutput,0.5);
		victorRight.set(ControlMode.PercentOutput,0.5);	
	}
	
	@Override
	public void initDefaultCommand() {
	}
}


