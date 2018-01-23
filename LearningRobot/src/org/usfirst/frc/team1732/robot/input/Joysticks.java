package org.usfirst.frc.team1732.robot.input;

import org.usfirst.frc.team1732.robot.config.Node;

import edu.wpi.first.wpilibj.Joystick;

public class Joysticks {

	public final Joystick left;
	public final Joystick right;
	public final Joystick buttons;

	public Joysticks(Node joysticksNode) {
		left = new Joystick(joysticksNode.getNode("left").getData("port"));
		right = new Joystick(joysticksNode.getNode("right").getData("port"));
		buttons = new Joystick(joysticksNode.getNode("buttons").getData("port"));
	}

	public double getLeft() {
		return -left.getRawAxis(1);
	}

	public double getRight() {
		return -right.getRawAxis(1);
	}

	public boolean isReversed() {
		return buttons.getRawButton(5);
	}
}