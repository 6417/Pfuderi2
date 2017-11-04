package org.usfirst.frc.team6417.robot.commands;

import org.usfirst.frc.team6417.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SorterController extends Command {

	private Controller controllerType;
	private double sorterSpeed = 0.5;

	public static enum Controller {
		XBOX, JOYSTICK
	}

	public SorterController() {
		setControllerType(Controller.JOYSTICK);
		if (Robot.joystickOne.getIsXbox()) {
			setControllerType(Controller.XBOX);
		}

		requires(Robot.sorter);
	}

	public SorterController setControllerType(Controller c) {
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
			if (Robot.runSorterXBox.get()) {
				Robot.sorter.setSorterSpeed(sorterSpeed);
			}
			break;

		case JOYSTICK:
			if (Robot.runSorterJoystick.get()) {
				Robot.sorter.setSorterSpeed(sorterSpeed);
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
		System.out.println("SorterController stopped");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
