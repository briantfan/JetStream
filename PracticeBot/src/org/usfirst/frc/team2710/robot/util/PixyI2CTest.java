package org.usfirst.frc.team2710.util;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixyI2CTest {

	public PixyI2CDriver pixy;
	Port port = Port.kOnboard;
	public PixyPacket[] packet1 = new PixyPacket[7];
	public PixyPacket[] packet2 = new PixyPacket[7];

	public PixyI2CTest() {
		pixy = new PixyI2CDriver(new I2C(port, 0x54), packet1, new PixyPacket());
	}

	public void testpixy() {
		for (int i = 0; i < packet1.length; i++)
			packet1[i] = null;
		SmartDashboard.putString("pixy hello", "working");
		for (int i = 1; i < 8; i++) {
			try {
				packet1[i - 1] = pixy.readPacket(i);
			} catch (Exception e) {
				SmartDashboard.putString("pixy Error: " + i, "exception");
			}
			if (packet1[i - 1] == null) {
				SmartDashboard.putString("pixy Error: " + i, "True");
				continue;
			}
			SmartDashboard.putNumber("pixy X Value: " + i, packet1[i - 1].X);
			SmartDashboard.putNumber("pixy Y Value: " + i, packet1[i - 1].Y);
			SmartDashboard.putNumber("pixy Width Value: " + i, packet1[i - 1].Width);
			SmartDashboard.putNumber("pixy Height Value: " + i, packet1[i - 1].Height);
			SmartDashboard.putString("pixy Error: " + i, "False");
		}
	}
}
