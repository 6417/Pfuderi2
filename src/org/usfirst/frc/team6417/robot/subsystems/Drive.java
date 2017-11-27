package org.usfirst.frc.team6417.robot.subsystems;

import org.usfirst.frc.team6417.robot.Fridolin;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem responsible for driving the robot
 */
public class Drive extends Subsystem {

	private Fridolin motorRightOne, motorRightTwo, motorLeftOne, motorLeftTwo;

	/**
	 * Enables all Drive class features, like access to motor control or to
	 * encoders
	 */
	public Drive() {
		motorRightOne = new Fridolin(RobotMap.MOTOR.RIGHT_ONE);
		motorRightTwo = new Fridolin(RobotMap.MOTOR.RIGHT_TWO);
		motorLeftOne = new Fridolin(RobotMap.MOTOR.LEFT_ONE);
		motorLeftTwo = new Fridolin(RobotMap.MOTOR.LEFT_TWO);
	}


	/**
	 * Set motorFrontRight speed
	 * 
	 * @param speed
	 */
	public void setMotorRight(double speed) {
		motorRightOne.set(speed);
		motorRightTwo.set(speed);
	}

	/**
	 * Set motorRearLeft speed
	 * 
	 * @param speed
	 */
	public void setMotorLeft(double speed) {
		motorLeftOne.set(speed);
		motorLeftTwo.set(speed);
	}

	/**
	 * Drive method for tank wheeled robots.
	 * 
	 * @param y
	 *            The speed that the robot should drive in the Y direction. This
	 *            input is inverted to match the forward == -1.0 that joysticks
	 *            produce. [-1.0..1.0]
	 * @param rotation
	 *            The rate of rotation for the robot that is completely
	 *            independent of the translation. [-1.0..1.0]
	 */
	public void driveDefault(double y, double rotation) {
		this.setMotorLeft((y - rotation));
		this.setMotorRight((y + rotation));
	}

	/**
	 * Drive method for tank wheeled robots. With two joysticks driven like a
	 * tank
	 * 
	 * @param yRightJoystick
	 * @param yLeftJoystick
	 */
	public void driveTank(double yAxisRightJoystick,double yAxisLeftJoystick) {
		this.driveDefault(((yAxisLeftJoystick/2) + (yAxisRightJoystick/2)), (yAxisRightJoystick - yAxisLeftJoystick));
	}

	/**
	 * Drive method for tank wheeled robots. With a controller.
	 * 
	 * @param xAxis
	 * @param yAxis
	 */
	public void driveController(double xAxis, double yAxis) {
		this.driveDefault(yAxis, xAxis);
	}
	
	public void driveAutonomous(double y, double rotation){
		this.driveDefault(y, rotation);
	}
	
	public void forward(double speed){
		this.driveAutonomous(speed,0);
	}
	
	public void backward(double speed){
		this.driveAutonomous(-speed, 0);
	}
	
	public void turnRight(double speed){
		this.driveAutonomous(0, speed);
	}
	
	public void turnLeft(double speed){
		this.driveAutonomous(0, -speed);
	}

	/**
	 * Stops robot form driving
	 */
	public void stop() {
		this.motorLeftOne.stopMotor();
		this.motorLeftTwo.stopMotor();
		this.motorRightOne.stopMotor();
		this.motorRightTwo.stopMotor();
	}
	public void resetRobot() {
		this.stop();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}
