package org.sharp.frc.team3260.RobotSoccer;


/*For preseason soccer training!!*/

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.sharp.frc.team3260.RobotSoccer.commands.autonomous.DriveDistanceAccelerometerCommand;
import org.sharp.frc.team3260.RobotSoccer.commands.autonomous.VisionCommandGroup;
import org.sharp.frc.team3260.RobotSoccer.subsystems.DriveTrain;
import org.sharp.frc.team3260.RobotSoccer.subsystems.Vision;

public class Robot extends IterativeRobot
{
    private static Robot instance;

    public Robot()
    {
        instance = this;
    }

    public void robotInit(){
        new DriveTrain();
        new Vision();
        new OI();

    }

    public void autonomousInit()
    {
        Scheduler.getInstance().add(new VisionCommandGroup());
    }

    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {

    }

    public void teleopPeriodic()
    {

        Scheduler.getInstance().run();

    }

    public void disabledInit()
    {
        Scheduler.getInstance().removeAll();
    }

    public void disabledPeriodic()
    {
        if(!Vision.getInstance().isConnected())
        {
            Vision.getInstance().connectSocket();
        }
    }

    public static Robot getInstance()
    {
        return instance;
    }
}
