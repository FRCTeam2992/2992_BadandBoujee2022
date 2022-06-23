// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BottomBallFeed;

public class MoveBottomBallFeed extends CommandBase {

  private BottomBallFeed mBottomBallFeed;
  
  private double mSpeed;
  /** Creates a new MoveBottomBallFeed. */
  public MoveBottomBallFeed(BottomBallFeed subsystem, double speed) {

    mBottomBallFeed = subsystem;
    addRequirements(mBottomBallFeed);

    mSpeed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mBottomBallFeed.setFeedSpeed(mSpeed);
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
