package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;
import org.sharp.frc.team3260.RobotSoccer.subsystems.Vision;

/**
 * Created by Administrator on 12/14/2015.
 */
public class FindVisionObjectCommand extends Command {

    public FindVisionObjectCommand()
    {
        requires(DriveTrain.getInstance());
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        //rotate drive train at some angle or wheel speed
        DriveTrain.getInstance().setDriveMotors(.3, -.3);
    }

    @Override
    protected boolean isFinished() {
        return Vision.getInstance().isObjectFound();
    }

    @Override
    protected void end() {
        DriveTrain.getInstance().stop();
    }

    @Override
    protected void interrupted() {

    }
}
