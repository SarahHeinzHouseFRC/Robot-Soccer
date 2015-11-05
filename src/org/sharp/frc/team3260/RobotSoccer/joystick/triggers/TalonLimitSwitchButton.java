package org.sharp.frc.team3260.RobotSoccer.joystick.triggers;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.buttons.Button;

public class TalonLimitSwitchButton extends Button
{
    private CANTalon talon;

    private boolean isForward;

    public TalonLimitSwitchButton(CANTalon talon, boolean isForward)
    {
        this.talon = talon;

        this.isForward = isForward;
    }

    @Override
    public boolean get()
    {
        return isForward ? talon.isFwdLimitSwitchClosed() : talon.isRevLimitSwitchClosed();
    }
}
