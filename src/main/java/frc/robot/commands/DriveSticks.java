// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
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
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Constants.isArcadeDrive) {

      double y1;
      double x2;

      x2 = -Robot.mRobotContainer.controller1.getRawAxis(4);
      y1 = -Robot.mRobotContainer.controller1.getRawAxis(1);

      if (Robot.mRobotContainer.controller1.getRightBumper()) {
        mDriveTrain.setGearState(true);
      } else {
        mDriveTrain.setGearState(false);
      }

      if (Math.abs(y1) <= Constants.joystickDeadband) {
        y1 = 0.0;
      }
      if (Math.abs(x2) <= Constants.joystickDeadband) {
        x2 = 0.0;
      }

      x2 = Math.pow(x2, 3);
      y1 = Math.pow(y1, 3);

      mDriveTrain.setArcadeSpeed(y1, x2);




    } else {
      double y1;
      double y2;

      y1 = -Robot.mRobotContainer.controller1.getLeftY();
      y2 = -Robot.mRobotContainer.controller1.getRightY();

      if (Robot.mRobotContainer.controller1.getLeftTriggerAxis() > 0.5) {
        mDriveTrain.setGearState(true);
      } else {
        mDriveTrain.setGearState(false);
      }

      if (Math.abs(y1) <= Constants.joystickDeadband) {
        y1 = 0.0;
      }
      if (Math.abs(y2) <= Constants.joystickDeadband) {
        y2 = 0.0;
      }
     
      y1 = Math.pow(y1, 3);
      y2 = Math.pow(y2, 3);

      mDriveTrain.setTankSpeed(y1, y2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
