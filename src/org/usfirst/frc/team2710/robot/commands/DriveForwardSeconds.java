package org.usfirst.frc.team2710.robot.commands;

import org.usfirst.frc.team2710.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardSeconds extends Command {

	private long startingTime;
	private int seconds;
	private long time; 
	private double speed;
    public DriveForwardSeconds(int seconds, double speed) {
        this.seconds = seconds;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("DriveForwardSeconds Called");
    	startingTime = System.currentTimeMillis();
    	System.out.println("GO");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0.4,0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	time = System.currentTimeMillis();
        if (time - startingTime >= seconds*1000)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.arcadeDrive(0, 0);
		System.out.println("STOP");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("DriveForwardSeconds Interrupted");
    	end();
    }
}
 