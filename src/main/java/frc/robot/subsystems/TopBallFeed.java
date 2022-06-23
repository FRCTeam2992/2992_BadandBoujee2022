// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.filter.Debouncer.DebounceType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TopBallFeed extends SubsystemBase {

  private TalonSRX feedMotor;



  /** Creates a new BallFeed. */
  public TopBallFeed() {
    feedMotor = new TalonSRX(7);
    feedMotor.setNeutralMode(NeutralMode.Brake);
    feedMotor.setInverted(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void setFeedMotor(double speed) {

      feedMotor.set(ControlMode.PercentOutput, speed);
  }

}
