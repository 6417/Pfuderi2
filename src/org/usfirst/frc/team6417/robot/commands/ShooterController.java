package org.usfirst.frc.team6417.robot.commands;

import org.usfirst.frc.team6417.robot.Robot;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterController extends Command {

	private Controller controllerType;
	private double shooterSpeed = RobotMap.SPEED.SHOOTER;

	public static enum Controller {
		XBOX, JOYSTICK
	}

	/**
	 * Enables you to let the robot climb
	 * 
	 * @param controllerType
	 *            enter Joystick or XBox to choose your type of contoller that
	 *            you're using
	 */
	public ShooterController() {

		setControllerType(Controller.JOYSTICK);
		if (Robot.joystickOne.getIsXbox()) {
			setControllerType(Controller.XBOX);
		}
		requires(Robot.shooter);
	}

	public ShooterController setControllerType(Controller c) {
		this.controllerType = c;
		return this;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		switch (controllerType) {
		case XBOX:
			if(Robot.shootXBox.get()){
				Robot.shooter.setShooterSpeed(shooterSpeed);
			}
			else if(Robot.reverseXBox.get()){
				Robot.shooter.setShooterSpeed(-shooterSpeed);
			}
			else{
				Robot.shooter.setShooterSpeed(0);
			}
			break;

		case JOYSTICK:
			if(Robot.shootJoystick.get()){
				Robot.shooter.setShooterSpeed(((Robot.joystickOne.getThrottle() - 1)/-2));
			}
			else if(Robot.reverseJoystick.get()){
				Robot.shooter.setShooterSpeed(-shooterSpeed);
			}
			else{
				Robot.shooter.setShooterSpeed(0);
			}
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.stop();
	}
}

