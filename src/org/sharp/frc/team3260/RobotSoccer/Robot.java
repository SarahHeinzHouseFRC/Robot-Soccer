package org.sharp.frc.team3260.RobotSoccer;


/*For preseason soccer training!!*/

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot
{
    private static Robot instance;

    public Robot()
    {
        instance = this;
    }

    public void robotInit(){}


    public void autonomousInit()
    {

    }

    public void autonomousPeriodic()
    {

    }

    public void teleopInit()
    {
    }

    public void teleopPeriodic()
    {

    }

    public void disabledInit()
    {

    }

    public void disabledPeriodic()
    {

    }

    public static Robot getInstance()
    {
        return instance;
    }
}
