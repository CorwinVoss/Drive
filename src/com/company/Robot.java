/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import com.company.commands.Auto.Auto;
import com.company.commands.Auto.AutoCommandGroup;
import com.company.commands.ResetEncoders;
import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.company.commands.ExampleCommand;
import com.company.subsystems.ExampleSubsystem;

import static com.company.RobotMap.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot 
{

    public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static OI oi;

    private Command autonomousCommand;
    private SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() 
    {
        new ResetEncoders();

        oi = new OI();
        chooser.addDefault("Default Auto", new AutoCommandGroup());
        chooser.addObject("Switch Auto", new Auto(100));
        SmartDashboard.putData("Auto mode", chooser);

        driveLeft2.set(ControlMode.Follower, DriveLeft1);
        driveRight2.set(ControlMode.Follower, DriveRight1);

        driveRight1.setInverted(true);
        driveRight2.setInverted(true);

        driveRight1.configMotionCruiseVelocity(10, 10);
        driveRight1.configMotionAcceleration(10, 10);
        driveRight1.config_kP(0,.5,0);
        driveRight1.config_kI(0,0,0);
        driveRight1.config_kD(0, 0, 0);
        driveRight1.config_kF(0,0,0);


        driveLeft1.configMotionCruiseVelocity(10,10);
        driveLeft1.configMotionAcceleration(10,10);
        driveLeft1.config_kP(0,.5,0);
        driveLeft1.config_kI(0,0,0);
        driveLeft1.config_kD(0, 0, 0);
        driveLeft1.config_kF(0,0,0);

        driveRight1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
        driveRight1.configSetParameter(ParamEnum.eFeedbackNotContinuous, 0, 0x00, 0x00, 0);

        driveLeft1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
        driveLeft1.configSetParameter(ParamEnum.eFeedbackNotContinuous, 1, 0x00, 0x00, 0);


    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() 
    {
        
    }

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() 
    {
        autonomousCommand = chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (autonomousCommand != null) 
        {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() 
    {
        SmartDashboard.putNumber( "Right", driveRight1.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("Left", driveLeft1.getSelectedSensorPosition(0));
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() 
    {
        new ResetEncoders();

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
        {
            autonomousCommand.cancel();
        }
        SmartDashboard.putData("Reset Encoders", new ResetEncoders());
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() 
    {
        SmartDashboard.putNumber( "Right", driveRight1.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("Left", driveLeft1.getSelectedSensorPosition(0));
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() 
    {
        
    }
}
