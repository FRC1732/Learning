package org.usfirst.frc.team1732.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackwardsTwice extends CommandGroup {

	public DriveBackwardsTwice() {
		addSequential(new DriveBackwards());
		addSequential(new DriveBackwards());
	}
}
