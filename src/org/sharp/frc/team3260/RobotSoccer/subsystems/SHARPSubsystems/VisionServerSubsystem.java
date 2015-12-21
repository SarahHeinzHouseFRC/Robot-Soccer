package org.sharp.frc.team3260.RobotSoccer.subsystems.SHARPSubsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 12/14/2015.
 */
public abstract class VisionServerSubsystem extends Subsystem {

    protected static VisionServerSubsystem instance;
    private boolean stopped = false;
    private Socket socket;

    public VisionServerSubsystem()
    {
        instance = this;

    }
    public void read() throws IOException {

        if(isConnected()) {
            try {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.write(1);
                out.flush();

                //System.out.println("sent");
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //System.out.println("Reading from socket");
                String ins = in.readLine();
                if (ins == null)
                    socket.close();
                else {
                    handleSerialData(ins);
                    //System.out.println("Read from socket");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                socket.close();
            }
        }
        else
        {
            this.stop();
        }
    }
    public abstract void handleSerialData(String in);

    @Override
    protected void initDefaultCommand() {
    }

    public void connectSocket()
    {
        try {
            socket = new Socket("10.32.60.20",4444);
            System.out.println("Socket Bound!");
            enable();
        } catch (IOException e) {

        }
    }

    public void stop()
    {
        stopped = true;
    }
    public void enable(){stopped = false;}
    public boolean isConnected(){

        if(socket != null && socket.isConnected() && !socket.isClosed() && socket.isBound())
        {
            try {
                //heartbeat server
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("0");
                out.flush();
                return true;

            } catch (Exception e) {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean isStopped()
    {
        return stopped;
    }
}

