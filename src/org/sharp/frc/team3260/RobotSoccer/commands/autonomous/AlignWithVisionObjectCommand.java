package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;
import org.sharp.frc.team3260.RobotSoccer.subsystems.Vision;

/**
 * Created by Administrator on 12/14/2015.
 */
public class AlignWithVisionObjectCommand extends Command {
    public AlignWithVisionObjectCommand()
    {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        DriveTrain.getInstance().setDriveMotors(.2,-.2);
    }

    @Override
    protected boolean isFinished() {
        return Vision.getInstance().isObjectCentered();
    }

    @Override
    protected void end() {
        DriveTrain.getInstance().stop();
    }

    @Override
    protected void interrupted() {

    }
}
