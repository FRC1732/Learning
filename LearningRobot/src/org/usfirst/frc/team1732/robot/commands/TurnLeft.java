package org.usfirst.frc.team1732.robot.commands;

import org.usfirst.frc.team1732.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnLeft extends Command {
	public TurnLeft() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Robot.drivetrain.drive(-0.2, 0.2);
		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.rightEncoder.reset();
	}

	protected boolean isFinished() {
		double DistanceToTurn = (((360 / (10 * Math.PI)) / 4) * 5);
		return Robot.drivetrain.leftEncoder.getDistance() < -1 * DistanceToTurn
				&& Robot.drivetrain.rightEncoder.getDistance() > DistanceToTurn;
	}
}
