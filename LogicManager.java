import Frames.LogInFrame;
import Frames.SignUpFrame;

import javax.swing.*;
import java.awt.*;

public class LogicManager extends Component {


    private final LogInFrame logInFrame;
    private final SignUpFrame signUpFrame;

    public User user;
//    private String fname;
//    private String lname;
//    private String username;
//    private String password;
//    private String confPass;


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
        signUpFrame.getRegister().addActionListener(e -> registerUser());







    }

    private void registerUser() {
        //лучше напиши массив с циклом

        String email = signUpFrame.getTextFields().get(0).getText();
        String fname = signUpFrame.getTextFields().get(1).getText();
        String lname = signUpFrame.getTextFields().get(2).getText();
        String username = signUpFrame.getTextFields().get(3).getText();
        String phoneNum = signUpFrame.getTextFields().get(4).getText();
        String password = signUpFrame.getTextFields().get(5).getText();
        String confPass = signUpFrame.getTextFields().get(6).getText();
        if (email.isEmpty() || fname.isEmpty() || lname.isEmpty() || username.isEmpty() ||
                phoneNum.isEmpty() || password.isEmpty() || confPass.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!password.equals(confPass)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(email,fname, lname, username, phoneNum, password);
        if (user != null) {
          //  dispose();
            logInFrame.setVisible(true);
            signUpFrame.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }







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

    private User addUserToDatabase(String email, String fname, String lname, String username, String phoneNum, String password) {



        return null;
    }


}
