package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Drive;
import frc.robot.commands.MoveArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  Joystick lefJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArmBtn = new JoystickButton(lefJoystick, 2);
  JoystickButton lowerArmBtn = new JoystickButton(rightJoystick, 2);

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();

  public RobotContainer() {
    drivetrain.setDefaultCommand(new Drive(drivetrain, lefJoystick, rightJoystick));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    raiseArmBtn.whenHeld(new MoveArm(arm, 0.5));
    lowerArmBtn.whenHeld(new MoveArm(arm, -0.5));
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain, 0.5, 0.5, 2);
  }
}
