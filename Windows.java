import Frames.LogInFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows {


    private LogInFrame logInFrame;




    private JFrame logUp;
    private JFrame logIn;
    private JPanel mainPanelLogIn;
    private JPanel colorStripe;

    private JPanel contentPanelLogIn;
    private JButton regButton;

    private JLabel usernamelabel;

    private JLabel passwordlabel;
    private JTextArea textArea;
    private JTextField textFielduser;
    private JTextField textFieldpass;

    private  String[] labelsText = {"First name:", "Second name:","Birthday: ","Username: ", "Password: ", "Confirm Password: "};


    public Windows(){



        logInFrame = new LogInFrame();

       // logUp = createFrame("Sign In");
//        logIn = createFrame("Log In");
//        mainPanelLogIn = new JPanel(new BorderLayout());
//
//        colorStripe = new JPanel();
//        colorStripe.setBackground(Color.PINK);
//        colorStripe.setPreferredSize(new Dimension(logIn.getWidth() / 3, logIn.getHeight()));
//
//        mainPanelLogIn.add(colorStripe, BorderLayout.WEST);
//
//        contentPanelLogIn = new JPanel();
//        contentPanelLogIn.setBackground(Color.WHITE);
//        usernamelabel = new JLabel();
//        usernamelabel.setText(labelsText[3]);
//        usernamelabel.setFont(new Font(usernamelabel.getFont().getName(), Font.PLAIN, 15));
//
//        textFielduser = new JTextField("");
//        textFielduser.setFont(new Font(textFielduser.getFont().getName(), Font.PLAIN, 25));
//
//        passwordlabel = new JLabel(labelsText[4]);
//        passwordlabel.setFont(new Font(passwordlabel.getFont().getName(), Font.PLAIN, 15));
//        textFieldpass = new JTextField("");
//        textFieldpass.setFont(new Font(textFieldpass.getFont().getName(), Font.PLAIN, 25));
//
//        contentPanelLogIn.add(usernamelabel);
//        contentPanelLogIn.add(textFielduser);
//        contentPanelLogIn.add(passwordlabel);
//        contentPanelLogIn.add(textFieldpass);
//
//
//
//
//
//
//
//
//
//
//
//
//        mainPanelLogIn.add(contentPanelLogIn, BorderLayout.CENTER);
//
//        logIn.add(mainPanelLogIn);
//
//
//
//
//
//
//
//
//
//
//
//
//        regButton = new JButton("Sign Up");
//        regButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                closeFrame(logIn);
//                logUp = createFrame("Log Up");
//                logUp.setVisible(true);
//            }
//        });
//
//
//
//      //  logIn.add(regButton);
//        logIn.setVisible(true);
    }



    private JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Чтобы окно было по центру экрана
        return frame;
    }
    private void closeFrame(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }


}
