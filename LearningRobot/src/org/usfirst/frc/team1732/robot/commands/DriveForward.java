package org.usfirst.frc.team1732.robot.commands;

import org.usfirst.frc.team1732.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	public DriveForward() {
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize() {
		Robot.drivetrain.drive(0.2, 0.2);
		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return Robot.drivetrain.leftEncoder.getDistance() > 20 && Robot.drivetrain.rightEncoder.getDistance() > 20;
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
}
