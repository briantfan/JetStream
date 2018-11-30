package org.usfirst.frc.team2710.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Util {
	
	public static WPI_TalonSRX createTalon(int port) {
		WPI_TalonSRX talon = new WPI_TalonSRX(port);
		talon.setNeutralMode(NeutralMode.Brake);
		talon.setSafetyEnabled(false);
		return talon;
	}
	
	public static WPI_VictorSPX createVictor(int port) {
		WPI_VictorSPX victor = new WPI_VictorSPX(port);
		victor.setNeutralMode(NeutralMode.Brake);
		victor.setSafetyEnabled(false);
		return victor;
	}
}
