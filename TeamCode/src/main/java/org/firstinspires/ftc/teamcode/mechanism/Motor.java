package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Motor extends OpMode {
    private DcMotor motor_left_back;
private DcMotor motor_right_back;
private DcMotor motor_left_forward;
private DcMotor motor_right_forward;

public void init() {
    motor_left_back = hardwareMap.get(DcMotor.class, "motor_left_back");
    motor_left_forward = hardwareMap.get(DcMotor.class, "motor_left_forward");
    motor_right_back = hardwareMap.get(DcMotor.class, "motor_right_back");
    motor_right_forward = hardwareMap.get(DcMotor.class, "motor_right_forward");

    motor_left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor_left_forward.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor_right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor_right_forward.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    motor_left_back.setDirection(DcMotor.Direction.REVERSE);
    motor_left_forward.setDirection(DcMotor.Direction.REVERSE);
    motor_right_back.setDirection(DcMotor.Direction.FORWARD);
    motor_right_forward.setDirection(DcMotor.Direction.FORWARD);

    motor_left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor_left_forward.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor_right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor_right_forward.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    telemetry.addData("status", "Ready to drive");
    telemetry.update();
} public void loop(){

        // Use the right trigger for forward movement
        double forwardPower = gamepad1.right_trigger;

        // Use the left stick for turning
        double turn = gamepad1.left_stick_x;

        // Combine the forward power and turn to get the individual motor powers
        double left_power = forwardPower + turn;
        double right_power = forwardPower - turn;

        // Apply the power to the motors
        motor_left_back.setPower(left_power);
        motor_left_forward.setPower(left_power);
        motor_right_back.setPower(right_power);
        motor_right_forward.setPower(right_power);

    // Turn 90 degrees when the 'X' button is pressed
        if (gamepad1.x) {

        // for better performance and consistency. This is a basic example.

        // Stop the drive motors momentarily
        motor_left_back.setPower(0);
        motor_left_forward.setPower(0);
        motor_right_back.setPower(0);
        motor_right_forward.setPower(0);

        // Turn the robot by making the left and right sides move in opposite directions
        motor_left_back.setPower(0.5);
        motor_left_forward.setPower(0.5);
        motor_right_back.setPower(0.5);
        motor_right_forward.setPower(0.5);
    }

        telemetry.addData("motor_left_back_power",motor_left_back.getCurrentPosition());
        telemetry.addData("motor_left_forward_power",motor_left_forward.getCurrentPosition());
        telemetry.addData("motor_right_back_power",motor_right_back.getCurrentPosition());
        telemetry.addData("motor_right_forward_power",motor_right_forward.getCurrentPosition());



}
}

