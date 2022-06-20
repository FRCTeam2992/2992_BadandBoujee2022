// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

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
    SmartDashboard.putNumber("Right Climb", rightClimbMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("Left Climb", leftClimbMotor.getSelectedSensorPosition());
  }

  public void setClimbSpeed(double speed) {
    speed = Math.min(0.7, Math.max(-0.7, speed));
    if ((leftClimbMotor.getSelectedSensorPosition() > Constants.upperLeftClimbLimit) && (speed > 0)) {
      leftClimbMotor.set(ControlMode.PercentOutput, 0);
    } else if((leftClimbMotor.getSelectedSensorPosition() < 2000) && (speed < 0)){
      leftClimbMotor.set(ControlMode.PercentOutput, 0);
    } else {
      leftClimbMotor.set(ControlMode.PercentOutput, speed);
    }


    if ((rightClimbMotor.getSelectedSensorPosition() > Constants.upperRightClimbLimit) && (speed > 0)) {
      rightClimbMotor.set(ControlMode.PercentOutput, 0);
    } else if((rightClimbMotor.getSelectedSensorPosition() < 2000) && (speed < 0)){
      rightClimbMotor.set(ControlMode.PercentOutput, 0);
    } else {
      rightClimbMotor.set(ControlMode.PercentOutput, speed);
    }
  }

  public void resetEncoders() {
    rightClimbMotor.setSelectedSensorPosition(0.0);
    leftClimbMotor.setSelectedSensorPosition(0.0);
  }
}
