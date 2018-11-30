package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	public static final boolean DEBUG = true;
	
	// Specifies which direction we want the intake to run.
	private boolean isFront;

    public IntakeCommand(boolean front) {
		debug("constructor called, front: " + front);
		isFront = front;
		requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
		debug("initialize, front: " + isFront);
		if (isFront) {
			Robot.intake.intakeMotorFront();
		} else {
			Robot.intake.intakeMotorBack();
		}
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
		debug("end called");
		Robot.intake.stopIntake();
    }

    @Override
    protected void interrupted() {
		debug("end called");
    	end();
    }

	private void debug(String s) {
		if (DEBUG) {
			System.out.println("DriveShiftUp Command: " + s);
		}
	}
}
