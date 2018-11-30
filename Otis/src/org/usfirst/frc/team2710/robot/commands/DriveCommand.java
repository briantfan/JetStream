package org.usfirst.frc.team2710.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2710.robot.Robot;
import org.usfirst.frc.team2710.robot.RobotMap;

public class DriveCommand extends Command {
	
	public static final boolean DEBUG = false;
	
	public DriveCommand() {
		debug("constructor called");
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		debug("initialize called");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double moveSpeed = Robot.oi.joystick1.getRawAxis(RobotMap.DRIVER_MOVE_AXIS);
		double rotateSpeed = Robot.oi.joystick1.getRawAxis(RobotMap.DRIVER_ROTATE_AXIS);
		debug("execute movespeed: " + moveSpeed + " rotateSpeed: " + rotateSpeed);
		Robot.drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
//		Robot.drivetrain.curvatureDrive(moveSpeed, rotateSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		debug("end called");
		Robot.drivetrain.arcadeDrive(0d, 0d);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		debug("interrupted called");
		end();
	}
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println("DriveCommand: " + s);
		}
	}
}
