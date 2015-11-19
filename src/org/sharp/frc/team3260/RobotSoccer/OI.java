package org.sharp.frc.team3260.RobotSoccer;

import org.sharp.frc.team3260.RobotSoccer.joystick.SHARPGamepad;
import sun.security.rsa.RSASignature;

public class OI
{
    private static OI oi;

    SHARPGamepad driverJoystick = new SHARPGamepad(0);

    public SHARPGamepad getDriverJoystick(){
        return driverJoystick;
    }

    public OI()
    {
       oi = this;
    }

    public static OI getInstance()
    {
        if (oi == null)
        {
            return new OI();
        }
        else
        {
            return oi;
        }
    }

}
