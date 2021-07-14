/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.LimelightConstants;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class AimWithLimelight extends CommandBase {
  /**
   * Creates a new AimWithLimelight.
   */
  private final Turret m_turret;
  private final Limelight m_limelight;
  private double offset;
  private boolean isRight;
  public AimWithLimelight(Turret turret, Limelight limelight) {
    m_turret = turret;
    m_limelight = limelight;
    addRequirements(turret, limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    offset = m_limelight.hOffset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    offset = m_limelight.hOffset();
    isRight = (offset > 0);
    if (isRight){
      m_turret.spinTurret(0.1);
    }
    else{
      m_turret.spinTurret(-0.1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.spinTurret(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(m_limelight.hOffset()) < LimelightConstants.minimumDistance);
  }
}
