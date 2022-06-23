// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.lib.oi.controller.TriggerButton;
import frc.robot.commands.AutoIntake;
import frc.robot.commands.ChangeShooterSpeed;
import frc.robot.commands.ClimbSticks;
import frc.robot.commands.Dejam;
import frc.robot.commands.DeployIntake;
import frc.robot.commands.DriveSticks;
import frc.robot.commands.MoveClimb;
import frc.robot.commands.PanicIntake;
import frc.robot.commands.SetHighGoalShooter;
import frc.robot.commands.SetLowGoalShooter;
import frc.robot.commands.Shoot;
import frc.robot.commands.StartBallFeed;
import frc.robot.commands.StartShooter;
import frc.robot.commands.StopAutoIntake;
import frc.robot.commands.StopBallFeed;
import frc.robot.commands.StopBottomBallFeed;
import frc.robot.commands.StopIntake;
import frc.robot.commands.StopShooter;
import frc.robot.commands.Autonomous.OneBallAuto;
import frc.robot.subsystems.TopBallFeed;
import frc.robot.subsystems.BottomBallFeed;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  private final DriveTrain mDriveTrain;
  private final Intake mIntake;
  private final Shooter mShooter;
  private final TopBallFeed mTopBallFeed;
  public final Climb mClimb;
  public final BottomBallFeed mBottomBallFeed;

  public XboxController controller1;
  public XboxController controller0;

  private SendableChooser<Command> autoChooser;

  public RobotContainer() {
    // Configure the button bindings
    mDriveTrain = new DriveTrain();
    mDriveTrain.setDefaultCommand(new DriveSticks(mDriveTrain));
    SmartDashboard.putData(mDriveTrain);

    mIntake = new Intake();
    mIntake.setDefaultCommand(new StopIntake(mIntake));
    SmartDashboard.putData(mIntake);

    mShooter = new Shooter();
    mShooter.setDefaultCommand(new StopShooter(mShooter));
    SmartDashboard.putData(mShooter);

    mTopBallFeed = new TopBallFeed();
    mTopBallFeed.setDefaultCommand(new StopBallFeed(mTopBallFeed));
    SmartDashboard.putData(mTopBallFeed);

    mClimb = new Climb();
    mClimb.setDefaultCommand(new ClimbSticks(mClimb));
    SmartDashboard.putData(mClimb);

    mBottomBallFeed = new BottomBallFeed();
    mBottomBallFeed.setDefaultCommand(new StopBottomBallFeed(mBottomBallFeed));

    controller0 = new XboxController(0);
    controller1 = new XboxController(1);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    SmartDashboard.putData("Deploy Intake", new DeployIntake(mIntake, true));
    SmartDashboard.putData("Retract Intake", new DeployIntake(mIntake, false));


    SmartDashboard.putData("Start BallFeed", new StartBallFeed(mTopBallFeed, 0.2));
    SmartDashboard.putData("Stop BallFeed", new StopBallFeed(mTopBallFeed));
  

    SmartDashboard.putData("Start Shooter", new StartShooter(mShooter));
    SmartDashboard.putData("Stop Shooter", new StopShooter(mShooter));

    SmartDashboard.putData("50 Increase Shooter RPM", new ChangeShooterSpeed(mShooter, 50));
    SmartDashboard.putData("50 Decrease Shooter RPM", new ChangeShooterSpeed(mShooter, -50));
    SmartDashboard.putData("200 Increase Shooter RPM", new ChangeShooterSpeed(mShooter, 200));
    SmartDashboard.putData("200 Decrease Shooter RPM", new ChangeShooterSpeed(mShooter, -200));


    //Controller 0
    JoystickButton autoIntakeButton = new JoystickButton(controller0, XboxController.Button.kA.value);
    autoIntakeButton.whenPressed(new AutoIntake(mIntake, mBottomBallFeed));
    
    JoystickButton stopAutoIntakeButton = new JoystickButton(controller0, XboxController.Button.kB.value);
    stopAutoIntakeButton.whenPressed(new StopAutoIntake(mIntake, mBottomBallFeed));

    JoystickButton toggleAutoIntakeButton = new JoystickButton(controller0, XboxController.Button.kLeftBumper.value);
    toggleAutoIntakeButton.whenPressed(new PanicIntake(mIntake, mBottomBallFeed, mIntake.getIntakeSolenoid()));


    

    // Controller 1
    POVButton climbUPButton = new POVButton(controller1, 0);
    climbUPButton.whenHeld(new MoveClimb(mClimb, .5), true);

    POVButton climbDownButton = new POVButton(controller1, 180);
    climbDownButton.whenHeld(new MoveClimb(mClimb, -.5), true);

    TriggerButton dejamButton = new TriggerButton(controller1, 0.3, 'l');
    dejamButton.whenActive(new Dejam(mIntake, mBottomBallFeed, mTopBallFeed));

    TriggerButton shootButton = new TriggerButton(controller1, 0.3, 'r');
    shootButton.whenActive(new Shoot(mShooter, mTopBallFeed));

    JoystickButton startShooterButton = new JoystickButton(controller1, XboxController.Button.kX.value);
    startShooterButton.whenPressed(new StartShooter(mShooter));

    JoystickButton stopShooterButton = new JoystickButton(controller1, XboxController.Button.kY.value);
    stopShooterButton.whenPressed(new StopShooter(mShooter));

    JoystickButton setLowGoalButton = new JoystickButton(controller1, XboxController.Button.kLeftBumper.value);
    setLowGoalButton.whenPressed(new SetLowGoalShooter(mShooter));

    JoystickButton setHighGoalButton = new JoystickButton(controller1, XboxController.Button.kRightBumper.value);
    setHighGoalButton.whenPressed(new SetHighGoalShooter(mShooter));


    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  private void setupAutoSelector() {
    // Auto Commands
    Command oneBallAuto = new OneBallAuto(mShooter, mDriveTrain, mTopBallFeed);
    autoChooser = new SendableChooser<>();

    autoChooser.setDefaultOption("Do Nothing", null);
    autoChooser.addOption("1 Ball Auto", oneBallAuto);

    SmartDashboard.putData("Auto Selector", autoChooser);
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoChooser.getSelected();
  }
}
