package org.usfirst.frc.team1732.robot.commands;

import org.usfirst.frc.team1732.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackwardsTwice extends CommandGroup {

	public DriveBackwardsTwice() {
		addSequential(new DriveBackwards(Robot.drivetrain.leftEncoder.makeReader(),
				Robot.drivetrain.rightEncoder.makeReader()));
		addSequential(new DriveBackwards(Robot.drivetrain.leftEncoder.makeReader(),
				Robot.drivetrain.rightEncoder.makeReader()));
	}
}
