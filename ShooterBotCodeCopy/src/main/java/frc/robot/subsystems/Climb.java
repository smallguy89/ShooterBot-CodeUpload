/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.MotorConstants;

/**
 * Add your docs here.
 */
public class Climb extends SubsystemBase {
    // WPI_TalonSRX climbMotor = new WPI_TalonSRX(MotorConstants.climbMotorID);
    public Climb(){
        // climbMotor.configFactoryDefault();
    }
    // public void setMotorPos(int position){
    //     SmartDashboard.putNumber("Climb pos: ", position);
    //     climbMotor.set(ControlMode.MotionMagic, position);
    // }

    // public void stopClimb(){
    //     climbMotor.set(ControlMode.PercentOutput, 0.0);
    // }
    
    // public Boolean isMotorAtPos(int pos){
    //     return (climbMotor.get() == pos);
    // }

    // public void manualClimb(double speed){
    //     climbMotor.set(ControlMode.PercentOutput, speed);
    // }
}
