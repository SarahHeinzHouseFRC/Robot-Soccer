package org.sharp.frc.team3260.RobotSoccer.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import kauailabs.navx_mxp.AHRS;
import org.sharp.frc.team3260.RobotSoccer.Constants;
import org.sharp.frc.team3260.RobotSoccer.Robot;
import org.sharp.frc.team3260.RobotSoccer.RobotMap;
import org.sharp.frc.team3260.RobotSoccer.commands.ArcadeDriveCommand;
import org.sharp.frc.team3260.RobotSoccer.commands.TankDriveCommand;
import org.sharp.frc.team3260.RobotSoccer.utils.Util;

/**
 * Created by robolab on 11/18/2015.
 */
public class DriveTrain extends Subsystem {
    private CANTalon fl = new CANTalon(RobotMap.flID);
    private CANTalon fr = new CANTalon(RobotMap.frID);
    private CANTalon bl = new CANTalon(RobotMap.blID);
    private CANTalon br = new CANTalon(RobotMap.brID);
    private PIDController driveRotationController;
    private double rotationTarget = 0.0;

    private double currentVelocity,distanceTraveled, accelerometerTarget,lastTime;

    Timer driveTimer;

    private AHRS imu;

    private boolean rotatingToTarget = false;
    protected double rotationControllerOutput = 0.0;

    private static DriveTrain instance;

    public DriveTrain() {

        instance = this;

        bl.changeControlMode(CANTalon.ControlMode.Follower);
        br.changeControlMode(CANTalon.ControlMode.Follower);

        bl.set(fl.getDeviceID());
        br.set(fr.getDeviceID());

        driveTimer = new Timer();

        try {
            byte updateRateHz = 50;

            SerialPort port = new SerialPort(57600,SerialPort.Port.kMXP);
            imu = new AHRS(port, updateRateHz);
            imu.resetDisplacement();
        } catch (Exception ex) {
            imu = null;
        }
        if(imu != null) {

            /*driveRotationController = new PIDController(Constants.rotationControllerP, Constants.rotationControllerI, Constants.rotationControllerD, Constants.rotationControllerF, getIMUPIDSource(), output -> rotationControllerOutput = output);

            driveRotationController.setPercentTolerance(1);

            driveRotationController.setContinuous();

            driveRotationController.setInputRange(-180, 180);*/
        }

    }

    public void stop()
    {
        setDriveMotors(0, 0);
    }

    public void setDriveMotors(double left, double right)
    {
        fl.set(-left);
        fr.set(right);
    }
    @Override
    protected void initDefaultCommand() {

        setDefaultCommand(new ArcadeDriveCommand());

    }

    public void arcadeDrive(double fwd, double rot)
    {
    double leftSide = fwd + rot;
    double rightSide = fwd - rot;

    Util.normalizeOutputs(new double[]{leftSide, rightSide});

    tankDrive(leftSide, rightSide);
    }
    public void zeroGyro()
    {
        rotatingToTarget = false;
    }

    private double getRotationPID() {

        if (rotatingToTarget){
            if (!driveRotationController.isEnable()) {
                driveRotationController.enable();
            }

            if (driveRotationController.onTarget()) {
                rotatingToTarget = false;

                return 0.0;
            }

            return rotationControllerOutput;
        }
        return 0.0;
    }

    /*public PIDSource getIMUPIDSource()
    {
        //return imu;
    }*/

    public void setRotationTarget(double rotationTarget)
    {
        driveRotationController.reset();

        rotatingToTarget = true;

        if(driveRotationController.getSetpoint() != rotationTarget)
        {
            this.rotationTarget = rotationTarget;

            driveRotationController.setSetpoint(rotationTarget);
        }

        if(!driveRotationController.isEnable())
        {
            driveRotationController.enable();
        }
    }

    public void tankDrive(double left, double right){
        setDriveMotors(left,right);
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

    public void driveToAccelerometerTarget(double distance, double speed)
    {
        resetAccelerometerValues();
        accelerometerTarget = distance;
        setDriveMotors(-speed,-speed);
        driveTimer.start();
        lastTime = driveTimer.get();
    }

    private void resetAccelerometerValues(){
        driveTimer.reset();
        distanceTraveled = 0.0;
    }

    public double getTraveledDistance()
    {
        double timePast = driveTimer.get() - lastTime;
        lastTime = driveTimer.get();
        distanceTraveled += imu.getVelocityX()*timePast;
        System.out.println(imu.getVelocityX());
        return distanceTraveled;
    }

    public boolean isAtAccelerometerTarget()
    {
        return Math.abs(getTraveledDistance()) >= accelerometerTarget;
    }


}