/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;



public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  
  WPI_TalonFX leftFront = new WPI_TalonFX(0);
  WPI_TalonFX leftBack = new WPI_TalonFX(3);
  WPI_TalonFX rightFront = new WPI_TalonFX(12);
  WPI_TalonFX rightBack = new WPI_TalonFX(15);
  SpeedControllerGroup leftDrive = new SpeedControllerGroup(leftBack, leftFront);
  SpeedControllerGroup rightDrive = new SpeedControllerGroup(rightBack, rightFront);
  DifferentialDrive diffDrive = new DifferentialDrive(leftDrive, rightDrive);
 
  public Drivetrain() {
    // leftBack.configFactoryDefault();
    // leftFront.configFactoryDefault();
    // rightBack.configFactoryDefault();
    // rightFront.configFactoryDefault();
  }
   public void curvatureDrive(double speed, double rotation, Boolean isQuickTurn){
     diffDrive.curvatureDrive(speed, rotation, isQuickTurn);
   }

  public void test(){
    leftFront.set(ControlMode.PercentOutput, 0.1);
    leftBack.set(ControlMode.PercentOutput, 0.1);
    rightBack.set(ControlMode.PercentOutput, 0.1);
    rightFront.set(ControlMode.PercentOutput, 0.1);
    //test.set(ControlMode.PercentOutput, 0.1);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
