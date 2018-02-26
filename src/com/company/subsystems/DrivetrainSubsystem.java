package com.company.subsystems;


import com.company.commands.ArcadeDriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static com.company.RobotMap.driveLeft1;
import static com.company.RobotMap.driveRight1;
import static com.company.RobotMap.driveRight2;

public class DrivetrainSubsystem extends Subsystem {

        private DifferentialDrive MainDrive = new DifferentialDrive(driveLeft1, driveRight1);

    public void initDefaultCommand() {
        // TODO: Set the default command, if any, for a subsystem here. Example:
        setDefaultCommand(new ArcadeDriveCommand());
    }

    public void TeleopDrive(Joystick Driver){
        MainDrive.arcadeDrive(Driver.getX() * .8, Driver.getY() * .8);
    }
}

