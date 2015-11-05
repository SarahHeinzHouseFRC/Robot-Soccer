package org.sharp.frc.team3260.RobotSoccer.joystick;

import edu.wpi.first.wpilibj.Joystick;

public class SHARPGamepad extends Joystick
{
    public static final int JOYSTICK_LEFT_X = 0, JOYSTICK_LEFT_Y = 1, JOYSTICK_RIGHT_X = 4, JOYSTICK_RIGHT_Y = 5;

    public static final int TRIGGER_LEFT_AXIS = 2, TRIGGER_RIGHT_AXS = 3;

    public static final int BUTTON_A = 1, BUTTON_B = 2, BUTTON_X = 3, BUTTON_Y = 4;

    public static final int BUTTON_LEFT_BUMPER = 5, BUTTON_RIGHT_BUMPER = 6;

    public static final int BUTTON_SELECT = 7, BUTTON_START = 8;

    public static final int BUTTON_LEFT_JOYSTICK = 9, BUTTON_RIGHT_JOYSTICK = 10;

    public SHARPGamepad(int port)
    {
        super(port);
    }
}
