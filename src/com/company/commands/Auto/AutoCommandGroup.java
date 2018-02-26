package com.company.commands.Auto;

import com.company.commands.ResetEncoders;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoCommandGroup extends CommandGroup {

    public AutoCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the arm.
        addSequential(new ResetEncoders());
        addSequential(new Auto(385));
        addSequential(new ResetEncoders());
        addSequential(new AutoTurn(250));
        addSequential(new ResetEncoders());
        addSequential(new AutoTurn(-250));
        addSequential(new ResetEncoders());
        addSequential(new AutoArc(250));
        addSequential(new ResetEncoders());
        addSequential(new AutoArc(-250));
        addSequential(new ResetEncoders());

    }
}
