/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class ShootWithLimelight extends CommandBase {
  /**
   * Creates a new ShootWithLimelight.
   */
  private final Limelight m_limelight;
  private final Turret m_turret;
  private double motorSpeed  = 0;
  public ShootWithLimelight(Turret turret, Limelight limelight) {
    m_limelight = limelight;
    m_turret = turret;
    addRequirements(turret, limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorSpeed = m_limelight.determineSpinSpeed();
    m_turret.spinBottomWheel(0.2);
    m_turret.spinTopWheel(motorSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.spinTopWheel(motorSpeed);
    m_turret.spinBottomWheel(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.spinTopWheel(0.0);
    m_turret.spinBottomWheel(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
