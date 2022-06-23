// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TopBallFeed;

public class StartBallFeed extends CommandBase {

  private TopBallFeed mBallFeed;
  private double mSpeed;
  /** Creates a new StartBallFeed. */
  public StartBallFeed(TopBallFeed subsystem, double speed) {

    mBallFeed = subsystem;

    mSpeed = speed;

    addRequirements(mBallFeed);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mBallFeed.setFeedMotor(mSpeed);
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
