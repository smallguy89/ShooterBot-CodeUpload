/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(MotorConstants.intakeMotorID);
  WPI_TalonSRX centerSpin = new WPI_TalonSRX(MotorConstants.spindexerMotorID);
  // dont use because they are in the Turret class
  // WPI_TalonSRX topTowerIntake = new WPI_TalonSRX(MotorConstants.intakeBottomTowerWheelMotorID);
  // WPI_TalonSRX bottomTowerIntake = new WPI_TalonSRX(MotorConstants.intakeTopTowerWheelMotorID);
  DoubleSolenoid scoopSolenoid = new DoubleSolenoid(MotorConstants.scoopArmSolenoidRetracted, MotorConstants.scoopArmSolenoidExtended);


  public Intake() {
    intakeMotor.configFactoryDefault();
    centerSpin.configFactoryDefault();
    // topTowerIntake.configFactoryDefault();
    // bottomTowerIntake.configFactoryDefault();
  }
  public void spinSpindexer(double speed){
    centerSpin.set(ControlMode.PercentOutput, speed);
  }
  public void stopSpindexer(){
    centerSpin.set(ControlMode.PercentOutput, 0.0);
  }
  public void spinIntake(){
    intakeMotor.set(ControlMode.PercentOutput, -0.25);
    centerSpin.set(ControlMode.PercentOutput, -0.25);
  }
  public void stopIntake(){
    intakeMotor.set(ControlMode.PercentOutput, 0);
    centerSpin.set(ControlMode.PercentOutput, 0);
  }

  // public void spinTowerIntakeWheel(){
  //   bottomTowerIntake.set(ControlMode.PercentOutput, 0.25);
  // }

  // public void stopTowerIntakeWheel(){
  //   bottomTowerIntake.set(ControlMode.PercentOutput, 0);
  // }
  public void extendArm(){
    scoopSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void retractArm(){
    scoopSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
