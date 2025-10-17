package org.firstinspires.ftc.teamcode.mechanism;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

@TeleOp
public class Motoralldirection extends  OpMode{

  

        private DcMotor frontLeft, frontRight, backLeft, backRight;
        private I2cDeviceSynch huskyLens;

        @Override
        public void init() {
            // Map motors from hardware configuration
            frontLeft  = hardwareMap.get(DcMotor.class, "frontmotor_left");
            frontRight = hardwareMap.get(DcMotor.class, "frontmotor_right");
            backLeft   = hardwareMap.get(DcMotor.class, "backmotor_left");
            backRight  = hardwareMap.get(DcMotor.class, "backmotor_right");

            // Set directions for mecanum wheels
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            backRight.setDirection(DcMotor.Direction.FORWARD);
            frontRight.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);

            telemetry.addData("Status", "Ready to drive");
            telemetry.update();
        }

        @Override
        public void loop() {
            // Joystick inputs
            double drive  = -gamepad1.left_stick_y;  // Forward/backward
            double strafe = gamepad1.left_stick_x;   // Left/right
            double turn   = gamepad1.right_stick_x;  // Rotation

            // Calculate motor powers for mecanum
            double frontLeftPower  = drive + strafe + turn;
            double frontRightPower = drive - strafe - turn;
            double backLeftPower   = drive - strafe + turn;
            double backRightPower  = drive + strafe - turn;

            // Normalize powers so no value exceeds 1.0
            double max = Math.max(1.0, Math.abs(frontLeftPower));
            max = Math.max(max, Math.abs(frontRightPower));
            max = Math.max(max, Math.abs(backLeftPower));
            max = Math.max(max, Math.abs(backRightPower));

            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;

            // Apply power to motors
            frontLeft.setPower(frontLeftPower);
            frontRight.setPower(frontRightPower);
            backLeft.setPower(backLeftPower);
            backRight.setPower(backRightPower);

            // Telemetry
            telemetry.addData("FL Power", frontLeftPower);
            telemetry.addData("FR Power", frontRightPower);
            telemetry.addData("BL Power", backLeftPower);
            telemetry.addData("BR Power", backRightPower);
            telemetry.update();


         //   if (gamepad1.left_stick_x > 0 && gamepad1.left_stick_y < 0.4 && )

            }
        }


