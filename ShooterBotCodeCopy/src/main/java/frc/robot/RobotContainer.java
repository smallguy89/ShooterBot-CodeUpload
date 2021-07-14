/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ButtonConstants;
import frc.robot.Constants.MultiplierConstants;
import frc.robot.commands.SimpleAuto;
import frc.robot.commands.SpinIntakeSpinCenter;
import frc.robot.commands.SpinSpindexerSpinTurretIntake;
// import frc.robot.commands.Climb.ClimbToBarHeight;
// import frc.robot.commands.Climb.ClimbToBaseHeight;
// import frc.robot.commands.Climb.ManualClimb;
//import frc.robot.commands.ShiftIntake;
//import frc.robot.commands.TestAuto;
import frc.robot.commands.Drivetrain.CurvatureDrive;
import frc.robot.commands.Intake.ActivateScoopArm;
import frc.robot.commands.Limelight.AimWithLimelight;
import frc.robot.commands.Limelight.ShootWithLimelight;
import frc.robot.commands.Turret.ManualTurret;
import frc.robot.commands.Turret.SpinUntilBallInTurret;
// import frc.robot.subsystems.Climb;
import frc.robot.commands.Intake.SpinIntake;
import frc.robot.commands.Turret.SpinTopWheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  private final Turret turret;
  private final Intake intake;
  private final Drivetrain drivetrain;
  // private final Climb climb;
  //private final IntakeSolenoid intakeSolenoid;
  private final Limelight limelight;

  private final Joystick throttleStick;
  private final Joystick curveStick;
  private final Joystick buttonStick;
  private final JoystickButton isQuickTurnButton;
  // INTAKE
  private final JoystickButton intakeButton;
  private final JoystickButton toggleScoopArmButton;
  
  // TOWER
  private final JoystickButton aimWithLimelightButton;

  private final JoystickButton spinUntilBallButton;
  private final JoystickButton spinSpindexerAndTowerIntakeButton;
  private final JoystickButton manualTurretButton;
  private final JoystickButton toggleTopTurretWheelButton;
  private final JoystickButton manualClimbButton;
  private final JoystickButton climbUpButton;
  private final JoystickButton baseClimbButton;
  // private final JoystickButton climbSlightlyRaisedButton;

  private final Command autoCommand;

          /*
Click a button to drop/raise intake   (toggle)			(5)
Click a button to spin intake motor, spindexer, tower intake until photoelectric sensor  (Toggle)							                                            (2)
While held (button) aim turret, spin up top turret wheel to limelight RPM. (extend hood as well)								                                        (3)
While held spin spindexer then spin tower intake		(1)
Use as feeding the balls for shooting both
Mini joystick → manual turret spin (toggle)			    (joystick, button 7)
Click a button to toggle spinning top tower wheel		(4)
Click a button to bring climb up 3-6 inches			    (9)
Click another button to toggle manual control	        (8)
Click another button to climb up			            (6)
        */
  //private final Command testAuto;
  public RobotContainer() {
    intake = new Intake();
    drivetrain = new Drivetrain();
    //testAuto = new TestAuto(drivetrain, intake, turret);
    //intakeSolenoid = new IntakeSolenoid();
    limelight = new Limelight();
    turret = new Turret();
    // climb = new Climb();

    autoCommand = new SimpleAuto(limelight, turret);

    // JOYSTICKS
    throttleStick = new Joystick(ButtonConstants.throttleJoystickID);
    curveStick = new Joystick(ButtonConstants.curveJoystickID);
    buttonStick = new Joystick(ButtonConstants.buttonStickID);
        /*
Click a button to drop/raise intake   (toggle)			(5)
Click a button to spin intake motor, spindexer, tower intake until photoelectric sensor  (Toggle)							                                            (2)
While held (button) aim turret, spin up top turret wheel to limelight RPM. (extend hood as well)								                                        (3)
While held spin spindexer then spin tower intake		(1)
Use as feeding the balls for shooting both
Mini joystick → manual turret spin (toggle)			    (joystick, button 7)
Click a button to toggle spinning top tower wheel		(4)
Click a button to bring climb up 3-6 inches			    (9)
Click another button to toggle manual control	        (8)
Click another button to climb up			            (6)
        */
    // QUICK TURN
    isQuickTurnButton = new JoystickButton(curveStick, ButtonConstants.isQuickTurnButtonID);

    // INTAKE
    intakeButton = new JoystickButton(throttleStick, ButtonConstants.intakeButtonID);
    toggleScoopArmButton = new JoystickButton(buttonStick, ButtonConstants.scoopArmButtonID);

    spinUntilBallButton = new JoystickButton(buttonStick, ButtonConstants.spinUntilBallButtonID);

    spinSpindexerAndTowerIntakeButton = new JoystickButton(buttonStick, ButtonConstants.spinSpindexerAndTowerButtonID);

    manualTurretButton = new JoystickButton(buttonStick, ButtonConstants.manualTurretButtonID);

    toggleTopTurretWheelButton = new JoystickButton(buttonStick, ButtonConstants.toggleTopTurretSpinButtonID);

    baseClimbButton = new JoystickButton(buttonStick, ButtonConstants.baseClimbButtonID);

    manualClimbButton = new JoystickButton(buttonStick, ButtonConstants.manualClimbButtonID);

    climbUpButton = new JoystickButton(buttonStick, ButtonConstants.climbUpButtonID);

    // climbSlightlyRaisedButton = new JoystickButton(buttosnStick, ButtonConstants.climbSlightlyRaisedButtonID);

    // TOWER
    aimWithLimelightButton = new JoystickButton(buttonStick, ButtonConstants.aimButtonID);

    // driving
    drivetrain.setDefaultCommand(new CurvatureDrive(drivetrain, ()->throttleStick.getY(), ()->curveStick.getX(), ()->isQuickTurnButton.get()));

    // drivetrain.setDefaultCommand(new Test(drivetrain));
    configureButtonBindings();       // last thing
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(buttonStick, 0-9).whileHeld(new SpinTopWheel(turret));
    //new JoystickButton(buttonStick, 0-9).whileHeld(new SpinIntake(intake));
    //new JoystickButton(buttonStick, 0-9).toggleWhenPressed(new ShiftIntake(intakeSolenoid));
    intakeButton.whileHeld(new SpinIntakeSpinCenter(intake));
    
    toggleScoopArmButton.toggleWhenPressed(new ActivateScoopArm(intake));

    aimWithLimelightButton.whileHeld(new AimWithLimelight(turret, limelight));

    spinUntilBallButton.toggleWhenPressed(new SpinUntilBallInTurret(turret));

    manualTurretButton.toggleWhenPressed(new ManualTurret(turret, (buttonStick.getX() * MultiplierConstants.turretSpinMultiplier)));

    // manualClimbButton.toggleWhenPressed(new ManualClimb(climb, (buttonStick.getX() * MultiplierConstants.climbMultiplier)));

    toggleTopTurretWheelButton.whileHeld(new ShootWithLimelight(turret, limelight));

    // climbUpButton.whenPressed(new ClimbToBarHeight(climb));

    // baseClimbButton.whenPressed(new ClimbToBaseHeight(climb));

    spinSpindexerAndTowerIntakeButton.whileHeld(new SpinSpindexerSpinTurretIntake(turret, intake));
    }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
