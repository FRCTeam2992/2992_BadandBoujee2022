// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.filter.Debouncer.DebounceType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BottomBallFeed extends SubsystemBase {
  

  private TalonSRX funnelMotor;

  // private DigitalInput liftSensor;
  // private Debouncer sensorDebouncer;
  
  // public boolean sensorState;
  /** Creates a new BottomBallFeed. */
  public BottomBallFeed() {

    funnelMotor = new TalonSRX(13) ;
    funnelMotor.setNeutralMode(NeutralMode.Brake);
    funnelMotor.setInverted(false);

    // liftSensor = new DigitalInput(0);

    // sensorDebouncer = new Debouncer(.1, DebounceType.kFalling);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // SmartDashboard.putBoolean("Ball Feed sensor", sensorState);

  }

  public void setFeedSpeed(double speed){
    funnelMotor.set(ControlMode.PercentOutput, speed);
  }
}
