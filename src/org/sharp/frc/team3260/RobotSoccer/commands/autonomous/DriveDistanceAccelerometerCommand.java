package org.sharp.frc.team3260.RobotSoccer.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;

/**
 * Created by Administrator on 12/9/2015.
 */
public class DriveDistanceAccelerometerCommand extends Command {

    private double distance = 0.0;
    private double timeout = 0.0;
    private double speed = .5;

    public DriveDistanceAccelerometerCommand(double distance)
    {
        requires(DriveTrain.getInstance());
        this.distance = distance;
    }
    public DriveDistanceAccelerometerCommand(double distance, double speed)
    {
        requires(DriveTrain.getInstance());
        this.distance = distance;
        this.speed = speed;
    }
    public DriveDistanceAccelerometerCommand(double distance, double speed, double timeout)
    {
        requires(DriveTrain.getInstance());
        this.distance = distance;
        this.timeout = timeout;
        this.speed = speed;
    }
    @Override
    protected void initialize() {
        DriveTrain.getInstance().driveToAccelerometerTarget(distance,speed);
        setTimeout(timeout);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return DriveTrain.getInstance().isAtAccelerometerTarget();
    }

    @Override
    protected void end() {
        DriveTrain.getInstance().stop();
    }

    @Override
    protected void interrupted() {

    }
}
