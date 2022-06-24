// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.SetDriveSpeed;
import frc.robot.commands.StartBallFeed;
import frc.robot.commands.StartShooter;
import frc.robot.commands.StopBallFeed;
import frc.robot.commands.StopShooter;
import frc.robot.subsystems.TopBallFeed;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class OneBallAuto extends SequentialCommandGroup {
  /** Creates a new OneBallAuto. */
  public OneBallAuto(Shooter mShooter, DriveTrain mDriveTrain, TopBallFeed mBallFeed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new WaitCommand(6),
      new StartShooter(mShooter).withTimeout(3),
      new StartBallFeed(mBallFeed, 0.5).withTimeout(1),
      new SetDriveSpeed(mDriveTrain, -0.5).withTimeout(2.5),
      new SetDriveSpeed(mDriveTrain, 0)
    );
  }
}
