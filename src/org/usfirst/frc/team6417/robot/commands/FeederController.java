package org.usfirst.frc.team6417.robot.commands;

import org.usfirst.frc.team6417.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FeederController extends Command {

	private Controller controllerType;
	private double feederSpeed = 0.7;

	public static enum Controller {
		XBOX, JOYSTICK
	}

	public FeederController() {
		setControllerType(Controller.JOYSTICK);
		if (Robot.joystickOne.getIsXbox()) {
			setControllerType(Controller.XBOX);
		}

		requires(Robot.feeder);
	}

	public FeederController setControllerType(Controller c) {
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
			if (Robot.shootXBox.get()) {
				Robot.feeder.setFeederSpeed(feederSpeed);
			}
			else if(Robot.reverseXBox.get()){
				Robot.feeder.setFeederSpeed(-feederSpeed);
			}
			else {
				Robot.feeder.setFeederSpeed(0);
			}
			break;

		case JOYSTICK:
			if (Robot.shootJoystick.get()) {
				Robot.feeder.setFeederSpeed(feederSpeed);
			}
			else if(Robot.reverseJoystick.get()) {
				Robot.feeder.setFeederSpeed(-feederSpeed);
			}
			else {
				Robot.feeder.setFeederSpeed(0);
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
		System.out.println("FeederController stopped");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
