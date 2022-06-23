// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TopBallFeed;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Shoot extends ParallelCommandGroup {
  /** Creates a new Shoot. */
  public Shoot(Shooter mShooter, TopBallFeed mBallFeed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new StartShooter(mShooter),
      new StartBallFeed(mBallFeed, 0.5)
    );
  }
}
