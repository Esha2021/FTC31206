package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBoard1 {
    private DigitalChannel touchSensor;


    public void init(HardwareMap hwMap){
        touchSensor=hwMap.get(DigitalChannel.class,"touch_sensor");
    }
}
