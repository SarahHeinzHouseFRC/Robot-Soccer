package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by Administrator on 12/16/2015.
 */
public class VisionCommandGroup extends CommandGroup {

    public VisionCommandGroup()
    {
        addSequential(new DriveAtSpeedCommand(.5,4));
        addParallel(new ReadVisionServerDataCommand());
        addSequential(new FindVisionObjectCommand());
        addSequential(new AlignWithVisionObjectCommand());
        addSequential(new DriveAtSpeedCommand(.5,4));//hopefully drive straight
    }

}
