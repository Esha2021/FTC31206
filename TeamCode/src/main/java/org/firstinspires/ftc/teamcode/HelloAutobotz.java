package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp //This annotation used to tell this code is run by driver hub(teleop program)
public class HelloAutobotz extends OpMode {


    // this method runs once,if the driver press init in the driver hub
    @Override
    public void init() {

        // add "Hello: AutoBotZ on driver hub
        telemetry.addData("Hello","AutoBotZ Roll out");
        telemetry.addData("Welcome","FTC World");
    }

    //this method runs repeatedly untill press the stop in the driver hub
    @Override
    public void loop(){
//intentionally we are used otherwise it give abstract error
    }

}
