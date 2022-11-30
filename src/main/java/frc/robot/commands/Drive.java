package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
    Drivetrain drivetrain;
    Joystick leftJoystick;
    Joystick rightJoystick;

    public Drive(Drivetrain dt, Joystick l, Joystick r) {
        drivetrain = dt;
        leftJoystick = l;
        rightJoystick = r;
        super.addRequirements(dt);
    }

    public void initialize(){
        drivetrain.stop();
    }

    public void execute() {
        drivetrain.drive(leftJoystick.getY(), rightJoystick.getY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean stop) {
        drivetrain.stop();
    }
}