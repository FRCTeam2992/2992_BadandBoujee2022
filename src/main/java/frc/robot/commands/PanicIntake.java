// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.subsystems.BottomBallFeed;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PanicIntake extends CommandBase {

  private Intake mIntake;
  private BottomBallFeed mBottomBallFeed;
  private boolean mIntakeState;
  /** Creates a new PanicIntake. */
  public PanicIntake(Intake intake, BottomBallFeed bottomBallFeed, boolean intakeState) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    mIntake = intake;
    mBottomBallFeed = bottomBallFeed;
    mIntakeState = intakeState;

  }

  @Override
  public void execute() {
    
    if (mIntakeState){
      new DeployIntake(mIntake, false);
      new StopIntake(mIntake);
      new StopBottomBallFeed(mBottomBallFeed);
    }

    else{
      new DeployIntake(mIntake, true);
      new SpinIntake(mIntake, 0.2);
      new MoveBottomBallFeed(mBottomBallFeed, 0.2);
    }


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
