// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //DriveTrain
    public static final double joystickDeadband = 0.2;
    public static final boolean isArcadeDrive = true;

    //Shooter
    public static final double highGoalShooterSpeed = 2500;
    public static final double lowGoalShooterSpeed = 1000;
    public static final double shooterEncoderPulses = 2048;

    //Ball Feed
    public static final double ballFeedSpeed = 0.4;

    //Intake
    public static final double intakeMotorSpeed = 0.2;

    //Climb
    public static final double upperLeftClimbLimit = 150000;
    public static final double upperRightClimbLimit = 150000;
}
