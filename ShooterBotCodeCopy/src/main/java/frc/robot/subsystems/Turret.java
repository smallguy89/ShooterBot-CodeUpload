/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Turret extends SubsystemBase {
  /**
   * Creates a new Turret.
   */
  WPI_TalonFX topWheel = new WPI_TalonFX(MotorConstants.intakeTopTowerWheelMotorID);
  WPI_TalonSRX bottomWheel = new WPI_TalonSRX(MotorConstants.intakeBottomTowerWheelMotorID);
  WPI_TalonSRX turretSpin = new WPI_TalonSRX(MotorConstants.turretTurnMotorID);

  // DigitalInput sensor = new DigitalInput(TurretConstants.photoElectricSensorID);

  DoubleSolenoid hoodSolenoid = new DoubleSolenoid(MotorConstants.turretHoodSolenoidExtended, MotorConstants.turretHoodSolenoidRetracted);

  public Turret() {
    topWheel.configFactoryDefault();
    // bottomWheel.configFactoryDefault();
    //turretSpin.configFactoryDefault();
  }
  
  public void spinTopWheel(double speed) {
    topWheel.set(ControlMode.PercentOutput, speed);
  }
  public void spinBottomWheel(double speed){
    // bottomWheel.set(ControlMode.PercentOutput, speed);
  }
  public void stopWheel(){
    topWheel.set(ControlMode.PercentOutput, 0);
    // bottomWheel.set(ControlMode.PercentOutput, 0);
  }
  public void spinTurret(double speed){
    //turretSpin.set(ControlMode.PercentOutput, speed);
  }
  public void stopTurret(){
    //turretSpin.set(ControlMode.PercentOutput, 0.0);
  }

  // public Boolean ballInTurret(){
  //   return sensor.get();
  // }

  public void extendHood(){
    hoodSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void retractHood(){
    hoodSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
