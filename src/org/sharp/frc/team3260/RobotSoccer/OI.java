package org.sharp.frc.team3260.RobotSoccer;

public class OI
{
    private static OI oi;

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
