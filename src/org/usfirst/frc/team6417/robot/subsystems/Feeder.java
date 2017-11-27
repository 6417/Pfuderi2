package org.usfirst.frc.team6417.robot.subsystems;

import org.usfirst.frc.team6417.robot.Fridolin;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {

	private Fridolin feeder;

	public Feeder() {
		feeder = new Fridolin(RobotMap.MOTOR.BALL_FEEDER);
	}

	public Fridolin getFeeder() {
		return feeder;
	}

	public void setFeederSpeed(double speed) {
		feeder.set(speed);
	}

	public void stop() {
		feeder.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
