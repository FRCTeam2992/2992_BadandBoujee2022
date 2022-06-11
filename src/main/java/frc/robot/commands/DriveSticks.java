// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class DriveSticks extends CommandBase {
  private DriveTrain mDriveTrain;

  /** Creates a new DriveSticks. */
  public DriveSticks(DriveTrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    mDriveTrain = subsystem;

    addRequirements(mDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double y1;
    double x2;
    
    x2 = -Robot.mRobotContainer.controller1.getRawAxis(4);
    y1 = -Robot.mRobotContainer.controller1.getRawAxis(1);

    x2 = Math.pow(x2, 3);
    y1 = Math.pow(y1, 3);

    if (Math.abs(y1) <= Constants.joystickDeadband) {
      x2 = 0.0;
    }

    if (Math.abs(x2) <= Constants.joystickDeadband) {
      x2 = 0.0;
    }

    mDriveTrain.setArcadeSpeed(y1, x2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
