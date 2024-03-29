// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climb;

public class ClimbSticks extends CommandBase {

  private Climb mClimb;

  /** Creates a new ClimbSticks. */
  public ClimbSticks(Climb subsystem) {

    mClimb = subsystem;
    addRequirements(mClimb);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double climbY;

    climbY = -Robot.mRobotContainer.controller1.getRightY();

    if (Math.abs(climbY) <= Constants.joystickDeadband*2){
      climbY = 0.0;
    }      
    climbY = climbY * climbY * climbY;

    mClimb.setClimbSpeed(climbY);

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
