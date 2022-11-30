package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {
    Arm arm;
    double speed;

    public MoveArm(Arm a, double s) {
        arm = a;
        speed = s;
        super.addRequirements(a);
    }

    public void initialize(){
        arm.stop();
    }
    
    public void execute() {
        arm.moveArm(speed);
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean stop) {
        arm.stop();
    }
}