import Frames.LogInFrame;
import Frames.SignUpFrame;

public class LogicManager {


    private LogInFrame logInFrame;
    private SignUpFrame signUpFrame;

    public LogicManager(){


        logInFrame = new LogInFrame();
        signUpFrame = new SignUpFrame();
        signUpFrame.setVisible(false);

        logInFrame.getSignUp().addActionListener(e -> {

            logInFrame.setVisible(false);
            signUpFrame.setVisible(true);

        });
        logInFrame.getLogin().addActionListener(e -> {


        });

        signUpFrame.getCancel().addActionListener(e -> {

            logInFrame.setVisible(true);
            signUpFrame.setVisible(false);

        });
        signUpFrame.getRegister().addActionListener(e -> {
            registerUser();
        });







    }

    private void registerUser() {

    }


}
