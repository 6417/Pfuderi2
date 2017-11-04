package org.usfirst.frc.team6417.robot.subsystems;

import org.usfirst.frc.team6417.robot.Fridolin;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sorter extends Subsystem {


	private Fridolin sorter;

	public Sorter() {
		sorter = new Fridolin(RobotMap.MOTOR.BALL_SORTER);
	}

	public Fridolin getSorter() {
		return sorter;
	}

	public void setSorterSpeed(double speed) {
		sorter.set(speed);
	}

	public void stop() {
		sorter.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}