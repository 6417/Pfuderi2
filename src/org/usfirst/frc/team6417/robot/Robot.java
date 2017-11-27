
package org.usfirst.frc.team6417.robot;


import org.usfirst.frc.team6417.robot.commands.CollectorController;
import org.usfirst.frc.team6417.robot.commands.DriveController;
import org.usfirst.frc.team6417.robot.commands.DriveController.DriveMode;
import org.usfirst.frc.team6417.robot.commands.FeederController;
import org.usfirst.frc.team6417.robot.commands.ShooterController;
import org.usfirst.frc.team6417.robot.commands.SorterController;
import org.usfirst.frc.team6417.robot.subsystems.Collector;
import org.usfirst.frc.team6417.robot.subsystems.Drive;
import org.usfirst.frc.team6417.robot.subsystems.Feeder;
import org.usfirst.frc.team6417.robot.subsystems.NavX;
import org.usfirst.frc.team6417.robot.subsystems.Shooter;
import org.usfirst.frc.team6417.robot.subsystems.Sorter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	// Controllers
	public static Joystick joystickOne;
	public static Joystick joystickTwo;
	public static JoystickButton runSorterJoystick, runSorterXBox, runCollectorJoystick, runCollectorXBox, runFeederJoystick, runFeederXBox;
	public static OI oi;

	// Subsystems
	public static Drive drive;
	public static NavX navX;
	public static Shooter shooter;
	public static Sorter sorter;
	public static Collector collector;
	public static Feeder feeder;

	// Commands
	public static DriveController driveController;
	public static ShooterController shooterController;
	public static SorterController sorterController;
	public static CollectorController collectorController;
	public static FeederController feederController;

	DriveMode driveMode;
	SendableChooser<DriveMode> driveModeChooser = new SendableChooser<DriveMode>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		joystickOne = new Joystick(RobotMap.CONTROLLER.RIGHT);
		joystickTwo = new Joystick(RobotMap.CONTROLLER.LEFT);
		
		runSorterJoystick = new JoystickButton(joystickOne, RobotMap.JOYSTICK.BUTTONS.SORTER);
		runCollectorJoystick = new JoystickButton(joystickOne, RobotMap.JOYSTICK.BUTTONS.COLLECTOR);
		runFeederJoystick = new JoystickButton(joystickOne, RobotMap.JOYSTICK.BUTTONS.FEEDER);
		
		runSorterXBox = new JoystickButton(joystickOne, RobotMap.XBOX.BUTTONS.SORTER);
		runCollectorXBox = new JoystickButton(joystickOne, RobotMap.XBOX.BUTTONS.COLLECTOR);
		runFeederXBox = new JoystickButton(joystickOne, RobotMap.XBOX.BUTTONS.FEEDER);
		

		navX = new NavX();
		drive = new Drive();
		oi = new OI();
		shooter = new Shooter();
		sorter = new Sorter();
		collector = new Collector();
		feeder = new Feeder();

		driveModeChooser.addObject("Tank", DriveMode.TANK);
		driveModeChooser.addObject("Controller", DriveMode.CONTROLLER);
		SmartDashboard.putData("Drive Mode", driveModeChooser);

		drive.resetRobot();
	}

	/**
	 * 
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		drive.resetRobot();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		driveMode = (DriveMode) driveModeChooser.getSelected();
		if (driveMode == null) {
			driveMode = DriveMode.CONTROLLER;
		}
		driveController = new DriveController(driveMode);
		driveController.start();
		
		shooterController = new ShooterController();
		shooterController.start();
		
		sorterController = new SorterController();
		sorterController.start();
		
		collectorController = new CollectorController();
		collectorController.start();
		
		feederController = new FeederController();
		feederController.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void robotPeriodic() {
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
