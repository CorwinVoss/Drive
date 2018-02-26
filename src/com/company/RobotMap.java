/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import com.company.subsystems.DrivetrainSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import java.lang.Math;

import static java.lang.Math.PI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    public static int
    DriveLeft1 = 0,
    DriveLeft2 = 2,
    DriveRight1 = 1,
    DriveRight2 = 3;

    public static WPI_TalonSRX driveLeft1 = new WPI_TalonSRX(DriveLeft1);
    public static WPI_TalonSRX driveLeft2 = new WPI_TalonSRX(DriveLeft2);
    public static WPI_TalonSRX driveRight1 = new WPI_TalonSRX(DriveRight1);
    public static WPI_TalonSRX driveRight2 = new WPI_TalonSRX(DriveRight2);

    public static DrivetrainSubsystem MainDrive = new DrivetrainSubsystem();

    public static int tickPerRev = 398;
    public static double tickPerInch = 1 / (6 * PI / tickPerRev);
}
