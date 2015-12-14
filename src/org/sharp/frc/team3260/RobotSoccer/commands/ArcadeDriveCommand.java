package org.sharp.frc.team3260.RobotSoccer.commands;

import edu.wpi.first.wpilibj.command.Command;
import javafx.scene.shape.Arc;
import org.sharp.frc.team3260.RobotSoccer.Constants;
import org.sharp.frc.team3260.RobotSoccer.OI;
import org.sharp.frc.team3260.RobotSoccer.joystick.SHARPGamepad;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;

/**
 * Created by Administrator on 12/12/2015.
 */
public class ArcadeDriveCommand extends Command {

    public ArcadeDriveCommand()
    {
        requires(DriveTrain.getInstance());
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        double fwd = (OI.getInstance()).getDriverJoystick().getRawAxis(SHARPGamepad.JOYSTICK_LEFT_Y);
        double rot = (OI.getInstance()).getDriverJoystick().getRawAxis(SHARPGamepad.JOYSTICK_RIGHT_X);

        fwd = Math.abs(fwd) > Constants.JOYSTICK_THRESHOLD ? fwd : 0.0;
        rot = Math.abs(rot) > Constants.JOYSTICK_THRESHOLD ? rot :0.0;

        DriveTrain.getInstance().arcadeDrive(-fwd, -rot);
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
