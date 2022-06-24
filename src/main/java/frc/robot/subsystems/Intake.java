// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private CANSparkMax intakeMotor;

  private Solenoid intakeDeploySolenoid;

  private double intakeSpeed = 0.0;
  public boolean intakeDeployed = false;
  /** Creates a new Intake. */
  public Intake() {
    intakeMotor = new CANSparkMax(6, MotorType.kBrushless);
    intakeMotor.setInverted(false);
    intakeMotor.setIdleMode(IdleMode.kCoast);

    intakeDeploySolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Intake state", getIntakeSolenoid());
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void deployIntake(boolean toggle) {
    intakeDeploySolenoid.set(toggle);
    intakeDeployed = toggle;
  }

  public boolean getIntakeSolenoid() {
    return intakeDeploySolenoid.get();
  }

}
