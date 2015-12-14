package org.sharp.frc.team3260.RobotSoccer.subsystems;

import org.sharp.frc.team3260.RobotSoccer.subsystems.SHARPSubsystems.VisionSerialSubsystem;

/**
 * Created by Administrator on 12/14/2015.
 */
public class Vision extends VisionSerialSubsystem{
    boolean objectFound = false;
    boolean objectCentered = false;

    @Override
    public void handleSerialData(String in) {

        for(char c: in.toCharArray())
        {
            switch(c)
            {

            }
        }
    }

    public boolean isObjectFound()
    {
        return objectFound;
    }

    public boolean isObjectCentered()
    {

        return objectCentered;
    }
}
