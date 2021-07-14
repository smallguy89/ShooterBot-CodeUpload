/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class SpinTurretWheels extends CommandBase {
  /**
   * Creates a new SpinTurretWheels.
   */
  private final Turret m_turret;
  private final Limelight m_limelight;
  private double speed = 0.0;
  public SpinTurretWheels(Turret turret, Limelight limelight) {
    m_turret = turret;
    m_limelight = limelight;
    addRequirements(turret, limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = m_limelight.determineSpinSpeed();
    m_turret.spinBottomWheel(0.25);
    m_turret.spinTopWheel(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.spinBottomWheel(0.25);
    m_turret.spinTopWheel(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.spinBottomWheel(0.0);
    m_turret.spinTopWheel(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
