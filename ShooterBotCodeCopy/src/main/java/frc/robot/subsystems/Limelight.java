/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;
import java.lang.Math;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  double hOffsetVar = tx.getDouble(0.0);
  double distance = ((LimelightConstants.targetHeight - LimelightConstants.cameraHeight) / Math.tan(LimelightConstants.cameraAngle + ty.getDouble(0.0)));
  public Limelight() {
    
  }/*
  public double calculateDistance(){
    double distance = ((LimelightConstants.targetHeight - LimelightConstants.cameraHeight) / Math.tan(LimelightConstants.cameraAngle + ty.getDouble(0.0)));
    return distance;
  }*/
  
  public double determineShooterAngle() {
    double shootAngle = 1;
    return shootAngle;
  }
  // Calculates the speed in meters (not translatable to pass to motors yet)
  public double determineSpinSpeed(){
    double speed; //in meters
    double gravity = 9.086;
    // distance = ((LimelightConstants.targetHeight - LimelightConstants.cameraHeight) / Math.tan(LimelightConstants.cameraAngle + ty.getDouble(0.0)));
    double m_shootAngle = determineShooterAngle();
    double initialBallHeight = 1;
    speed = Math.sqrt(
      (gravity*distance*distance)/
      (2.0*Math.cos(m_shootAngle)*(initialBallHeight+distance*Math.tan(m_shootAngle)-LimelightConstants.targetHeight)));
    SmartDashboard.putNumber("Spin speed: ", speed);
    speed = (speed * LimelightConstants.metersToEncoderMultipier);
    return speed;
    
  }

  public double hOffset(){
    return tx.getDouble(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    distance = ((LimelightConstants.targetHeight - LimelightConstants.cameraHeight) / Math.tan(LimelightConstants.cameraAngle + ty.getDouble(0.0)));
    SmartDashboard.putNumber("Limelight X: ", x);
    SmartDashboard.putNumber("Limelight Y: ", y);
    SmartDashboard.putNumber("Limelight Area: ", area);
    SmartDashboard.putNumber("Distance: ", distance);
  }
}
