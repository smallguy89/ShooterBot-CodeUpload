/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Turret.SpinBottomTurretWheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SpinSpindexerSpinTurretIntake extends ParallelCommandGroup {
  /**
   * Creates a new SpinSpindexerSpinTurretIntake.
   */
  private final Intake m_intake;
  private final Turret m_turret;
  public SpinSpindexerSpinTurretIntake(Turret turret, Intake intake) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    m_intake = intake;
    m_turret = turret;
    addCommands(new SpinIntakeSpinCenter(m_intake), new SpinBottomTurretWheel(m_turret));
    // super();
  }
}
