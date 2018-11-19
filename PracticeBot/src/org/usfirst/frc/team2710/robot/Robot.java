package org.usfirst.frc.team2710.robot;

import org.usfirst.frc.team2710.robot.subsystems.Drivetrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.usfirst.frc.team2710.robot.commands.DriveCommand;
import org.usfirst.frc.team2710.robot.commands.DriveShiftDown;
import org.usfirst.frc.team2710.robot.commands.DriveShiftUp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Drivetrain drivetrain;
	public static OI oi;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
    AHRS ahrs;


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		oi = new OI();
		m_chooser.addDefault("Default Auto", new DriveCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		ahrs = new AHRS(SPI.Port.kMXP);
		CameraServer.getInstance().startAutomaticCapture();
	}
	
	public void robotPeriodic() {
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(ahrs.getAngle());
/*
		// HACK to bypass command/subsystem architecture
		double moveSpeed = Robot.oi.joystick1.getRawAxis(RobotMap.DRIVER_MOVE_AXIS);
		double rotateSpeed = Robot.oi.joystick1.getRawAxis(RobotMap.DRIVER_ROTATE_AXIS);
		System.out.println("teleop hack movespeed: " + moveSpeed + "  rotateSpeed: " + rotateSpeed);
		Robot.drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
*/
		// HACK to show raw camera data
		Mat mat = new Mat();
		CameraServer.getInstance().getVideo().grabFrame(mat);
		for (int row = 0; row < mat.rows() && row < 10; row++) {
			StringBuilder sb = new StringBuilder();
			for (int col = 0; col < mat.cols() && col < 10; col++) {
				double[] data = mat.get(row, col);
				for (int i = 0; i < data.length; i++) {
					if (i == 0) {
						sb.append("[");
					} else {
						sb.append(",");
					}
					sb.append(data[i]);
				}
				sb.append("] ");
			}
			System.out.println(sb.toString());
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
