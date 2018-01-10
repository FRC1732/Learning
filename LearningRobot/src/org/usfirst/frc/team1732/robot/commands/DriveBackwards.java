package org.usfirst.frc.team1732.robot.commands;

import org.usfirst.frc.team1732.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

// just an example, make your own command
public class DriveBackwards extends Command {

	public DriveBackwards() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drivetrain.drive(-0.2, -0.2);
		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.drivetrain.leftEncoder.getDistance() < -20 && Robot.drivetrain.rightEncoder.getDistance() < -20;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
}
