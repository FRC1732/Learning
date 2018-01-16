package org.usfirst.frc.team1732.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private TalonSRX leftTalonMaster;
	private TalonSRX rightTalonMaster;

	private final boolean reverseLeftSide = false;
	private final boolean reverseRightSide = !reverseLeftSide;

	public final Encoder leftEncoder = new Encoder(0, 0, reverseLeftSide);
	public final Encoder rightEncoder = new Encoder(0, 0, reverseRightSide);

	private static final int CONFIG_TIMEOUT = 10; // recommended timeout by CTRE
	private static final double DRIVE_DEADBAND = 0.04; // CTRE default, but also need to pass to DifferentialDrive
	private static final double DISTANCE_PER_PULSE = 0.1;

	public Drivetrain() {
		leftTalonMaster = configureMasterTalon(13, reverseLeftSide);
		configureFollowerTalon(14, leftTalonMaster.getDeviceID());
		configureFollowerTalon(15, leftTalonMaster.getDeviceID());
		rightTalonMaster = configureMasterTalon(19, reverseRightSide);
		configureFollowerTalon(20, rightTalonMaster.getDeviceID());
		configureFollowerTalon(21, rightTalonMaster.getDeviceID());
		leftEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	}

	private void configureFollowerTalon(int CANid, int masterCANid) {
		TalonSRX talon = new TalonSRX(CANid);
		talon.set(ControlMode.Follower, masterCANid);
		talon.setNeutralMode(NeutralMode.Coast);
	}

	private TalonSRX configureMasterTalon(int CANid, boolean isInverted) {
		TalonSRX talon = new TalonSRX(CANid);
		talon.setNeutralMode(NeutralMode.Coast);
		talon.setInverted(isInverted);
		talon.configNeutralDeadband(DRIVE_DEADBAND, CONFIG_TIMEOUT);
		return talon;
	}

	public void drive(double leftSpeed, double rightSpeed) {
		leftTalonMaster.set(ControlMode.PercentOutput, leftSpeed);
		rightTalonMaster.set(ControlMode.PercentOutput, rightSpeed);
	}

	@Override
	protected void initDefaultCommand() {
	}

}