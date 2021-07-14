/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class LimelightConstants{

        public static final double targetHeight = 7.0;
        public static final double cameraHeight = 0.0;
        public static final double cameraAngle = 13.0;  // possibly 12
        public static final int minimumDistance = 2;
        public static final double metersToEncoderMultipier = 0.01;

    }
    public static class ButtonConstants{


        // JOYSTICKS/QUICK TURN
        public static int throttleJoystickID = 2;
        public static int curveJoystickID = 1;
        public static int buttonStickID = 0;
        // quick turn button on joystick
        public static int isQuickTurnButtonID = 4;

        public static int spinUntilBallButtonID = 2;
        public static int spinSpindexerAndTowerButtonID = 1;
        public static int intakeButtonID = 1;                   // curve stick
        public static int scoopArmButtonID = 5;

        public static int aimButtonID = 3;
        public static int manualTurretButtonID = 7;
        public static int toggleTopTurretSpinButtonID = 4;
        public static int baseClimbButtonID = 9;
        public static int manualClimbButtonID = 8;
        public static int climbUpButtonID = 6;
        public static int climbSlightlyRaisedButtonID = 10;

    }
    public static class MotorConstants{
        // CONTROL PANEL
        // public static int controlPanelExtendedSolenoidID = 0-9;
        // public static int controlPanelRetractedSolenoidID = 0-9;
        

        // INTAKE/TOWER
        public static int intakeMotorID = 2;
        public static int spindexerMotorID = 7;
        public static int intakeTopTowerWheelMotorID = 1;
        public static int intakeBottomTowerWheelMotorID = 13;
        public static int turretTurnMotorID = 14;

        public static int scoopArmSolenoidExtended = 6;
        public static int scoopArmSolenoidRetracted = 1;

        public static int turretHoodSolenoidExtended = 0;
        public static int turretHoodSolenoidRetracted = 7;
        public static int photoElectricSensorID = 0;


        // CLIMB
        // public static int climbMotorID = 0-9;
    } 
    public static class EncoderConstants{
        public static int climbMotorTopPosition = 0;
        public static int climbMotorBottomPosition = 0;
        public static int climbMotorSlightlyUpPos = 0;

    }
    public static class MultiplierConstants{
        public static double turretSpinMultiplier = 0.2;
        public static double climbMultiplier = 0.2;
    }
}
