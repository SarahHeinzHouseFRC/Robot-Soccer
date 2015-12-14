package org.sharp.frc.team3260.RobotSoccer.utils;

public class Util {

    public static void normalizeOutputs(double[] inputs)
    {
        double maxMagnitude = Math.abs(inputs[0]);

        for(int i = 1; i < inputs.length; i++)
        {
            double temp = Math.abs(inputs[i]);
            if(maxMagnitude < temp)
            {
                maxMagnitude = temp;
            }
        }

        if(maxMagnitude > 1.0)
        {
            for(int i = 0; i < inputs.length; i++)
            {
                inputs[i] = inputs[i] / maxMagnitude;
            }
        }
    }
}
