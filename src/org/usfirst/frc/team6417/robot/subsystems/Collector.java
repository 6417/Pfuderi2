package org.usfirst.frc.team6417.robot.subsystems;

import org.usfirst.frc.team6417.robot.Fridolin;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

	private Fridolin collector;

	public Collector() {
		collector = new Fridolin(RobotMap.MOTOR.BALL_COLLECTOR);
	}

	public Fridolin getCollector() {
		return collector;
	}

	public void setCollectorSpeed(double speed) {
		collector.set(speed);
	}

	public void stop() {
		collector.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
