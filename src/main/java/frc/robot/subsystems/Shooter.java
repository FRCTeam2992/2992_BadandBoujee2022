// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private TalonFX shooterMotor;

  private double shooterSetRPM = Constants.highGoalShooterSpeed;

  /** Creates a new Shooter. */
  public Shooter() {
    shooterMotor = new TalonFX(10);
    shooterMotor.setNeutralMode(NeutralMode.Coast);
    shooterMotor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Target", getShooterTargetRPM());
    SmartDashboard.putNumber("Shooter Speed", getShooterRPM());
  }

  public void setShooterSpeed(double speed){
    shooterMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setShooterVelocity(double velocity){
    shooterMotor.set(ControlMode.Velocity, velocity);
  }
  
  public void setShooterToTargetRPM() {
    double speed = (shooterSetRPM / 600.0) * (Constants.shooterEncoderPulses * 2);
    setShooterRawVelocity(speed);
  }

  private void setShooterRawVelocity(double velocity) {
    shooterMotor.set(ControlMode.Velocity, velocity);
  }

  public double getShooterRPM() {
    return (shooterMotor.getSelectedSensorVelocity() * 600) / (Constants.shooterEncoderPulses * 2);
  }

  public double getShooterTargetRPM() {
    return shooterSetRPM;
  }

  public void setShooterTargetRPM(double shooterSetSpeed) {
    this.shooterSetRPM = shooterSetSpeed;
  }

  public boolean atShooterRPM() {
    return (Math.abs(getShooterTargetRPM() - getShooterRPM()) < 200.0);
  }
}
