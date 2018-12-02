package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmOn extends Command {

	public static final boolean DEBUG = true;

	public ArmOn() {
		debug("constructor called");
		requires(Robot.elevator);
	}
	
	@Override
	protected void initialize() {
		debug("initialize: arm on");
		Robot.elevator.setArm(true);
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
			System.out.println("ArmOn Command: " + s);
		}
	}
}
