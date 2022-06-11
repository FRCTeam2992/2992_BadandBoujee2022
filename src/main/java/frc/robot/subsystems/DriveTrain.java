// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  private CANSparkMax frontLeftMotor;
  private CANSparkMax backLeftMotor;

  private CANSparkMax frontRightMotor;
  private CANSparkMax backRightMotor;

  private Solenoid gearShifter;

  private boolean mGearState;
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    frontLeftMotor.setIdleMode(IdleMode.kBrake);
    frontLeftMotor.setInverted(false);

    frontRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    frontRightMotor.setIdleMode(IdleMode.kBrake);
    frontRightMotor.setInverted(false);

    backLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    backLeftMotor.follow(frontLeftMotor);
  
    backRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    backRightMotor.follow(frontRightMotor);


    gearShifter = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setTankSpeed(double leftSpeed, double rightSpeed){
    leftSpeed = Math.max(-1, Math.min(leftSpeed, 1));
    rightSpeed = Math.max(-1, Math.min(rightSpeed, 1));

    frontLeftMotor.set(leftSpeed);
    frontRightMotor.set(rightSpeed);
  }

  public void setArcadeSpeed(double move, double rotate){
    
    double leftSpeed = move - rotate;
    double rightSpeed = move + rotate;

    double max = Math.max(Math.abs(leftSpeed), Math.abs(rightSpeed));

    if(max > 0){
      leftSpeed /= max;
      rightSpeed /= max;
    }

    setTankSpeed(leftSpeed, rightSpeed);
  }

  public void setGearState(boolean gearState){
    mGearState = gearState;

    gearShifter.set(mGearState);
  }

  public boolean getGearState(){
    return mGearState;
  }
  
}
