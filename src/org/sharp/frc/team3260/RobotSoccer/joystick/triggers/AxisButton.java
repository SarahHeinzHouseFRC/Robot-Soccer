package org.sharp.frc.team3260.RobotSoccer.joystick.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class AxisButton extends Button
{
    Joystick joy;

    int axis;

    double threshold;

    public AxisButton(Joystick joy, int axis, double threshold)
    {
        this.joy = joy;

        this.axis = axis;

        this.threshold = threshold;
    }

    @Override
    public boolean get()
    {
        return threshold >= Math.abs(joy.getRawAxis(axis));
    }
}
