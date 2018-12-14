package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurnSeconds extends Command {

	long startTime;
	long targetTime;
	long error;
	double speed;
	
    public DriveTurnSeconds(long durationSeconds, double speed) {
        startTime = System.currentTimeMillis();
        targetTime = startTime + 1000*durationSeconds;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = (targetTime - System.currentTimeMillis())/(targetTime-startTime);
    	Robot.drivetrain.arcadeDrive(0, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= targetTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
