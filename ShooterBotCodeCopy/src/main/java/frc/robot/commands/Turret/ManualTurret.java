/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class ManualTurret extends CommandBase {
  /**
   * Creates a new Manualturret.
   */
  private final Turret m_turret;
  private final double m_speed;
  public ManualTurret(Turret turret, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret;
    m_speed = speed;
    addRequirements(turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_turret.spinTurret(m_speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.spinTurret(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.stopTurret();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
