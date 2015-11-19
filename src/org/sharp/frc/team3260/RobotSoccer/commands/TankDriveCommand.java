package org.sharp.frc.team3260.RobotSoccer.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.sharp.frc.team3260.RobotSoccer.OI;
import org.sharp.frc.team3260.RobotSoccer.joystick.SHARPGamepad;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;

/**
 * Created by robolab on 11/18/2015.
 */
public class TankDriveCommand extends Command {

    public TankDriveCommand(){

        requires(DriveTrain.getInstance());
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        double left = (OI.getInstance()).getDriverJoystick().getRawAxis(SHARPGamepad.JOYSTICK_LEFT_Y);
        double right = (OI.getInstance()).getDriverJoystick().getRawAxis(SHARPGamepad.JOYSTICK_RIGHT_Y);
        DriveTrain.getInstance().tankDrive(left, right);
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
        end();
    }
}
