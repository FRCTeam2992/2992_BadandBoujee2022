// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallFeed extends SubsystemBase {

  private VictorSPX feedMotor;
  private boolean mFeedState;

  /** Creates a new BallFeed. */
  public BallFeed() {
    feedMotor = new VictorSPX(7);
    feedMotor.setNeutralMode(NeutralMode.Brake);
    feedMotor.setInverted(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setFeedMotor(boolean feedState) {
    mFeedState = feedState;

    if (mFeedState){
      feedMotor.set(ControlMode.PercentOutput, Constants.ballFeedSpeed);
    } else{
      feedMotor.set(ControlMode.PercentOutput, 0);
    }
  }
  
  public boolean getFeedState(){
    return mFeedState; 
  }
}