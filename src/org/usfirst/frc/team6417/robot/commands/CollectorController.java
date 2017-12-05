package org.usfirst.frc.team6417.robot.commands;

import org.usfirst.frc.team6417.robot.Robot;
import org.usfirst.frc.team6417.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorController extends Command {

	private Controller controllerType;
	private double collectorSpeed = RobotMap.SPEED.COLLECTOR;

	public static enum Controller {
		XBOX, JOYSTICK
	}

	public CollectorController() {
		setControllerType(Controller.JOYSTICK);
		if (Robot.joystickOne.getIsXbox()) {
			setControllerType(Controller.XBOX);
		}

		requires(Robot.collector);
	}

	public CollectorController setControllerType(Controller c) {
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
			if (Robot.collectXBox.get()) {
				Robot.collector.setCollectorSpeed(collectorSpeed);
			}
			else {
				Robot.collector.setCollectorSpeed(0);
			}
			break;

		case JOYSTICK:
			if (Robot.collectJoystick.get()) {
				Robot.collector.setCollectorSpeed(collectorSpeed);
			}
			else if(Robot.reverseJoystick.get()){
				Robot.collector.setCollectorSpeed(-collectorSpeed);
			}
			else {
				Robot.collector.setCollectorSpeed(0);
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
		System.out.println("CollectorController stopped");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
