package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;
import org.usfirst.frc.team2710.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorCommand extends Command {

	public static final boolean DEBUG = false;

	public ElevatorCommand() {
		debug("constructor called");
		requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
	@Override
    protected void initialize() {
		debug("initialize called");
    }

    // Called repeatedly when this Command is scheduled to run
	@Override
    protected void execute() {
		double moveSpeed = Robot.oi.joystick2.getRawAxis(RobotMap.AUX_ELEVATOR_AXIS);
		debug("execute movespeed: " + moveSpeed);
		Robot.elevator.moveElevator(moveSpeed);
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
		Robot.elevator.moveElevator(0d);
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
			System.out.println("ElevatorCommand: " + s);
		}
	}
}
