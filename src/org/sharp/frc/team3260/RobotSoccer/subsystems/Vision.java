package org.sharp.frc.team3260.RobotSoccer.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.sharp.frc.team3260.RobotSoccer.Constants;
import org.sharp.frc.team3260.RobotSoccer.subsystems.SHARPSubsystems.VisionServerSubsystem;

/**
 * Created by Administrator on 12/14/2015.
 */
public class Vision extends VisionServerSubsystem{
    boolean objectFound = false;
    boolean objectCentered = false;
    static Vision instance;
    private int displacement = -8888;
    private int area = -8888;


    public Vision()
    {
        instance = this;
    }
    @Override
    public void handleSerialData(String in) {

        System.out.println(in);
        String currentValue = "";
        int comma = 0;
        for(int i =0; i < in.toCharArray().length; i++)
        {
            char currentChar = in.toCharArray()[i];

             if(currentChar == ',' || i+1 == in.toCharArray().length){
                if(currentValue != "") {
                    switch (comma) {
                        case 0:
                            displacement = Integer.parseInt(currentValue);
                            System.out.println(displacement);
                            break;
                        case 1:
                            area = Integer.parseInt(currentValue+currentChar);
                            System.out.println(area);
                            break;
                        default:
                    }
                    comma++;
                    currentValue = "";
                }
            }
            else
            {
                currentValue += currentChar;
            }
        }
    }

    public boolean isObjectFound()
    {
        boolean found = getObjectDisplacement() > -8888 && area > -8888;
        return found;
    }

    public boolean isObjectCentered()
    {
        boolean centered = Math.abs(getObjectDisplacement()) - Constants.visionObjectCenteredThreshold <= 0;
        return centered;
    }

    public int getObjectDisplacement()
    {
        return displacement;
    }
    public static Vision getInstance()
    {
        if (instance == null)
        {
            return new Vision();
        }
        return instance;
    }
}
