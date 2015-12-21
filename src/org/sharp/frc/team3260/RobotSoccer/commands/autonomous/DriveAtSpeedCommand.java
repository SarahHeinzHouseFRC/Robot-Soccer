package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;

/**
 * Created by Administrator on 12/18/2015.
 */
public class DriveAtSpeedCommand extends Command {
    double speed, time = 0;
    //2ft /s
    public DriveAtSpeedCommand(double speed, double time)
    {
        requires(DriveTrain.getInstance());
        this.speed = speed;
        this.time = time;

        setTimeout(time);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        DriveTrain.getInstance().setDriveMotors(speed,speed+.05);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        DriveTrain.getInstance().stop();
    }

    @Override
    protected void interrupted() {

    }
}
