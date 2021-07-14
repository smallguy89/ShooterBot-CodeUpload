// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.Climb;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.Constants.EncoderConstants;
// import frc.robot.subsystems.Climb;

// public class ClimbToBaseHeight extends CommandBase {
//   /**
//    * Creates a new ClimbToBaseHeight.
//    */
//   private final Climb m_climb;
//   public ClimbToBaseHeight(Climb climb) {
//     m_climb = climb;
//     addRequirements(climb);
//     // Use addRequirements() here to declare subsystem dependencies.
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     m_climb.setMotorPos(EncoderConstants.climbMotorSlightlyUpPos);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     m_climb.setMotorPos(EncoderConstants.climbMotorSlightlyUpPos);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     m_climb.stopClimb();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return (m_climb.isMotorAtPos(EncoderConstants.climbMotorSlightlyUpPos));
//   }
// }
