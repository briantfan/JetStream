package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeClose extends Command {

	public static final boolean DEBUG = true;

	public IntakeClose() {
		debug("constructor called");
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
		debug("initialize");
		Robot.intake.closeIntake();
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
			System.out.println("IntakeClose Command: " + s);
		}
	}
}
