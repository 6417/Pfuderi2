package org.usfirst.frc.team6417.robot.subsystems;

import org.usfirst.frc.team6417.robot.Fridolin;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private Fridolin motorOne, motorTwo;
	private Encoder encoderShooter;

	/**
	 * Enables all Drive class features, like access to motor control or to
	 * encoders
	 */
	public Shooter() {
		motorOne = new Fridolin(RobotMap.MOTOR.FLYWHEEL_ONE);
		motorTwo = new Fridolin(RobotMap.MOTOR.FLYWHEEL_TWO);
		
		encoderShooter = new Encoder(RobotMap.ENCODER.FLYWHEEL_A, RobotMap.ENCODER.FLYWHEEL_B);
		
		this.initializeEncoders();
	}

	/**
	 * Put initialize code for the encoders in this method.
	 */
	private void initializeEncoders() {
		encoderShooter.setDistancePerPulse(RobotMap.ROBOT.DIST_PER_PULSE);
		//encoderShooter.setReverseDirection(true);
	}

	/**
	 * Returns the current count from the Encoder
	 */
	public int getShooterEncoder() {
		return encoderShooter.get();
	}

	/**
	 * Returns the distance driven since the last reset in centimeters
	 */
	public double getShooterDistance() {
		return encoderShooter.getDistance();
	}

	/**
	 * Resets the Encoders distance to zero. Resets the current count to zero on
	 * the encoders.
	 */
	public void resetEncoders() {
		encoderShooter.reset();
	}

	/**
	 * Set motorFrontRight speed
	 * 
	 * @param speed
	 */
	public void setShooterSpeed(double speed) {
		motorOne.set(speed);
		motorTwo.set(speed);
	}


	/**
	 * Stops robot form driving
	 */
	public void stop() {
		this.motorOne.stopMotor();
		this.motorTwo.stopMotor();
	}
	public void resetRobot() {
		this.resetEncoders();
		this.stop();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
