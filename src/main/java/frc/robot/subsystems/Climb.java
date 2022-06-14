// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

  private WPI_TalonFX leftClimbMotor;
  private WPI_TalonFX rightClimbMotor;

  /** Creates a new Climb. */
  public Climb() {
    leftClimbMotor = new WPI_TalonFX(11);
    leftClimbMotor.setInverted(true);
    leftClimbMotor.setNeutralMode(NeutralMode.Brake);

    rightClimbMotor = new WPI_TalonFX(12);
    rightClimbMotor.setInverted(true);
    rightClimbMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setClimbSpeed(double speed) {
      leftClimbMotor.set(ControlMode.PercentOutput, speed);
      rightClimbMotor.set(ControlMode.PercentOutput, speed);
  }
}
