package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.subsystems.SHARPSubsystems.VisionServerSubsystem;
import org.sharp.frc.team3260.RobotSoccer.subsystems.Vision;

import java.io.IOException;

/**
 * Created by Administrator on 12/16/2015.
 */
class ReadVisionServerDataCommand extends Command
{

    ReadVisionServerDataCommand()
    {
        requires(Vision.getInstance());
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        try {
            Vision.getInstance().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}