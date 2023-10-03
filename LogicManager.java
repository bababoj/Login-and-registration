import Frames.LogInFrame;
import Frames.SignUpFrame;

import javax.swing.*;

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
//
//        String name = tfName.getText();
//        String email = tfEmail.getText();
//        String phone = tfPhone.getText();
//        String address = tfAddress.getText();
//        String password = String.valueOf(pfPassword.getPassword());
//        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());
//
//        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
//            JOptionPane.showMessageDialog(this,
//                    "Please enter all fields",
//                    "Try again",
//                    JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            JOptionPane.showMessageDialog(this,
//                    "Confirm Password does not match",
//                    "Try again",
//                    JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        user = addUserToDatabase(name, email, phone, address, password);
//        if (user != null) {
//            dispose();
//        }
//        else {
//            JOptionPane.showMessageDialog(this,
//                    "Failed to register new user",
//                    "Try again",
//                    JOptionPane.ERROR_MESSAGE);
//        }

    }


}
