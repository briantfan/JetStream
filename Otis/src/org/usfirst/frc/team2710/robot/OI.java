package org.usfirst.frc.team2710.robot;

import org.usfirst.frc.team2710.robot.commands.ArmOff;
import org.usfirst.frc.team2710.robot.commands.ArmOn;
import org.usfirst.frc.team2710.robot.commands.DriveShiftDown;
import org.usfirst.frc.team2710.robot.commands.DriveShiftUp;
import org.usfirst.frc.team2710.robot.commands.IntakeClose;
import org.usfirst.frc.team2710.robot.commands.IntakeCommand;
import org.usfirst.frc.team2710.robot.commands.IntakeOpen;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	public Joystick joystick1 = new Joystick(RobotMap.JOYSTICK_DRIVER);
	
	public Button D1 = new JoystickButton(joystick1, RobotMap.LOW_GEAR);
	public Button D2 = new JoystickButton(joystick1, RobotMap.HIGH_GEAR);
	
	public Joystick joystick2 = new Joystick(RobotMap.JOYSTICK_AUX);
	
	public Button A1 = new JoystickButton(joystick2, RobotMap.INTAKE_FRONT);
	public Button A2 = new JoystickButton(joystick2, RobotMap.INTAKE_BACK);
	public Button A3 = new JoystickButton(joystick2, RobotMap.INTAKE_OPEN);
	public Button A4 = new JoystickButton(joystick2, RobotMap.INTAKE_CLOSE);
	public Button A5 = new JoystickButton(joystick2, RobotMap.ARM_ON);
	public Button A6 = new JoystickButton(joystick2, RobotMap.ARM_OFF);

	public OI() {
		D1.whenPressed(new DriveShiftDown());
		D2.whenPressed(new DriveShiftUp());
		
		A1.whileHeld(new IntakeCommand(true));
		A2.whileHeld(new IntakeCommand(false));
		A3.whenPressed(new IntakeOpen());
		A4.whenPressed(new IntakeClose());
		A5.whenPressed(new ArmOn());
		A6.whenPressed(new ArmOff());
	}
}
