// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.BottomBallFeed;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoPanicIntake extends ParallelCommandGroup {

   private Intake mIntake;
  /** Creates a new AutoPanicIntake. */
  public AutoPanicIntake(Intake subsystem, BottomBallFeed mBottomBallFeed,boolean intakeState) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    mIntake = subsystem;
boolean mIntakeState = mIntake.intakeDeployed;

    if (mIntakeState){
    addCommands(new DeployIntake(mIntake, false),
    new StopIntake(mIntake),
    new StopBottomBallFeed(mBottomBallFeed)
    );
    }

    else{
      addCommands(
        new DeployIntake(mIntake, true),
      new SpinIntake(mIntake, 0.75),
      new MoveBottomBallFeed(mBottomBallFeed, 0.5)
      );
    }


  }
}
