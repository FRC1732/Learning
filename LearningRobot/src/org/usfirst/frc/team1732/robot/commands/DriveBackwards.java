package org.usfirst.frc.team1732.robot.commands;

import org.usfirst.frc.team1732.robot.Robot;
import org.usfirst.frc.team1732.robot.sensors.encoders.EncoderReader;

import edu.wpi.first.wpilibj.command.Command;

// just an example, make your own command
public class DriveBackwards extends Command {

	private EncoderReader leftEncoder;
	private EncoderReader rightEncoder;

	public DriveBackwards(EncoderReader leftEncoder, EncoderReader rightEncoder) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		this.leftEncoder = leftEncoder;
		this.rightEncoder = rightEncoder;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drivetrain.drive.tankDrive(-0.2, -0.2);
		leftEncoder.zero();
		rightEncoder.zero();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return leftEncoder.getPosition() < -20 && rightEncoder.getPosition() < -20;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.drive.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drivetrain.drive.tankDrive(0, 0);
	}
}
