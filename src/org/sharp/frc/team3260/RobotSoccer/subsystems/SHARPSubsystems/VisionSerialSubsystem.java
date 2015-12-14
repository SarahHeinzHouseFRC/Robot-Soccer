package org.sharp.frc.team3260.RobotSoccer.subsystems.SHARPSubsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Administrator on 12/14/2015.
 */
public abstract class VisionSerialSubsystem extends Subsystem {

    private SerialPort serial;
    private SerialPort.Port port = SerialPort.Port.kMXP;
    protected static VisionSerialSubsystem instance;
    private boolean stopped;

    public VisionSerialSubsystem()
    {
        serial = new SerialPort(50,this.port);
        instance = this;

        serial.flush(); //flush serial to remove accidental chars
    }
    public VisionSerialSubsystem(SerialPort.Port port)
    {
        this.port = port;
        serial = new SerialPort(50,this.port);
        instance = this;
    }
    public void read()
    {
        String in = serial.readString();
        handleSerialData(in);

        serial.flush(); //flush serial to remove accidental chars
    }
    public abstract void handleSerialData(String in);

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ReadVisionSerialDataCommand(this));
    }

    public void stop()
    {
        stopped = true;
    }
    public boolean isStopped()
    {
        return stopped;
    }
}

class ReadVisionSerialDataCommand extends Command
{
    VisionSerialSubsystem system;
    ReadVisionSerialDataCommand(VisionSerialSubsystem system)
    {
        this.system = system;
        requires(system);
    }
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        system.read();
    }

    @Override
    protected boolean isFinished() {
        return system.isStopped();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}

