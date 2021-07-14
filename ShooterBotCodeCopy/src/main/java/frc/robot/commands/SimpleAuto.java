/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Limelight.ShootWithLimelight;
import frc.robot.commands.Limelight.AimWithLimelight;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SimpleAuto extends SequentialCommandGroup {
  /**
   * Creates a new SimpleAuto.
   */

   
  public SimpleAuto(Limelight limelight, Turret turret) {
    addCommands(new AimWithLimelight(turret, limelight), new ShootWithLimelight(turret, limelight));
  }
}
