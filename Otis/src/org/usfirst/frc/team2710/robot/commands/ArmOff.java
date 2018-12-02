package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmOff extends Command {

	public static final boolean DEBUG = true;

	public ArmOff() {
		debug("constructor called");
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		debug("initialize: arm off");
		Robot.elevator.setArm(false);
	}
	
	@Override
	protected void execute() {
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void end() {
		debug("end called");
	}
	
	@Override
	protected void interrupted() {
		debug("interrupted");
		end();
	}
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("ArmOff Command: " + s);
		}
	}
}
