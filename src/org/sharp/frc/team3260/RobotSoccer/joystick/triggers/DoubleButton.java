package org.sharp.frc.team3260.RobotSoccer.joystick.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * A custom button that is triggered when two buttons on a Joystick are
 * simultaneously pressed.
 */
public class DoubleButton extends Button
{
    private Joystick joy;
    private int button1, button2;

    public DoubleButton(Joystick joy, int button1, int button2)
    {
        this.joy = joy;
        this.button1 = button1;
        this.button2 = button2;
    }

    public boolean get()
    {
        return joy.getRawButton(button1) && joy.getRawButton(button2);
    }
}