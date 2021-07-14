// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.Climb;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.Climb;

// public class ManualClimb extends CommandBase {
//   /**
//    * Creates a new ManualClimb.
//    */
//   private final Climb m_climb;
//   private final Double m_speed;
//   public ManualClimb(Climb climb, double speed) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     m_climb = climb;
//     m_speed = speed;
//     addRequirements(climb);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     m_climb.manualClimb(m_speed);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     m_climb.manualClimb(m_speed);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     m_climb.manualClimb(0.0);
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
