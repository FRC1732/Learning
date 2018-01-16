package org.usfirst.frc.team1732.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveInSquare extends CommandGroup {

	public DriveInSquare() {
		addSequential(new DriveForward());
		addSequential(new TurnLeft());
		addSequential(new DriveForward());
		addSequential(new TurnLeft());
		addSequential(new DriveForward());
		addSequential(new TurnLeft());
		addSequential(new DriveForward());
		addSequential(new TurnLeft());
	}
}
