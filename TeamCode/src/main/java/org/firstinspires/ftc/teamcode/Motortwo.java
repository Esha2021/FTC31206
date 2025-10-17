package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Motortwo extends OpMode {

    private DcMotor frontmotor_left,frontmotor_right,backmotor_left,backmotor_right;


    public void init() {
       frontmotor_left= hardwareMap.get(DcMotor.class,"frontmotor_left");
        frontmotor_right= hardwareMap.get(DcMotor.class,"frontmotor_right");
        backmotor_left= hardwareMap.get(DcMotor.class,"backmotor_left");
        backmotor_right= hardwareMap.get(DcMotor.class,"backmotor_right");
        //set the encoder count=0
        frontmotor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontmotor_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backmotor_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backmotor_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontmotor_left.setDirection(DcMotor.Direction.FORWARD);
        frontmotor_right.setDirection(DcMotor.Direction.REVERSE);
        backmotor_left.setDirection(DcMotor.Direction.REVERSE);
        backmotor_right.setDirection(DcMotor.Direction.FORWARD);
        // smooth control-adjust the motor power.
        frontmotor_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontmotor_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backmotor_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backmotor_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("status","Ready to drive");
        telemetry.update();

    }
 public void loop(){
     double drive  = -gamepad1.left_stick_y;  // Forward/backward or gas _pedal
     double turn   = gamepad1.right_stick_x;  //steering_wheel

    /* move forward only//joystick  value ranges from -1 to 1.-(-1) means push forward(-*-1=+1).drive positive. push
    //    double power=-gamepad1.left_stick_y;
    //   power=Math.max(-1.0, Math.min(1.0, power));
    // motor_left.setPower(power);
    // motor_right.setPower(power); */

     double left_power=drive+turn;
     double right_power=drive-turn;

     frontmotor_left.setPower(left_power);
     frontmotor_right.setPower(right_power);
     backmotor_left.setPower(left_power);
     backmotor_right.setPower(right_power);

     telemetry.addData("Left Motor  Power",frontmotor_left.getCurrentPosition());
     telemetry.addData("right_ Motor  Power",frontmotor_right.getCurrentPosition());
     telemetry.update();
 }


}
