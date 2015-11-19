package org.sharp.frc.team3260.RobotSoccer.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;
import org.sharp.frc.team3260.RobotSoccer.RobotMap;
import org.sharp.frc.team3260.RobotSoccer.commands.TankDriveCommand;

/**
 * Created by robolab on 11/18/2015.
 */
public class DriveTrain extends Subsystem {
    CANTalon fl = new CANTalon(RobotMap.flID);//still needs an id
    CANTalon fr = new CANTalon(RobotMap.frID);
    CANTalon bl = new CANTalon(RobotMap.blID);
    CANTalon br = new CANTalon(RobotMap.brID);

    private static DriveTrain instance;
    public DriveTrain(){

        instance = this;

    }
    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new TankDriveCommand());

    }

    public void tankDrive(double left, double right){
        fl.set(left);
        bl.set(left);
        fr.set(right);
        br.set(right);

    }

    public static DriveTrain getInstance()
    {

        if(instance == null)
        {
            return new DriveTrain();
        }
        else
        {
            return instance;
        }
    }
}
