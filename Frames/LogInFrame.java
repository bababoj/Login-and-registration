package Frames;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LogInFrame extends JFrame {

    private JLabel nameFrame;
    private JLabel userlabel;
    private JLabel passlabel;
    private JTextField textFieldUser;
    //  private JTextField textFieldPass;
    private JPasswordField passField;
    @Getter
    private JButton signUp;
    @Getter
    private JButton login;

    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel colorStripe;

    private JPanel inputPanel;

    public LogInFrame(){

        super("Sign In");
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Albert.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        colorStripe = new JPanel();
        colorStripe.setBackground(Color.PINK);
        colorStripe.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(colorStripe, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        // contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
      //  contentPanel.setLayout(new GridLayout(7, 1));
        nameFrame = new JLabel("LOGIN");
        nameFrame.setFont(customFont);
       // nameFrame.setBounds(100, 300, 100, 30);
        contentPanel.add(nameFrame, BorderLayout.NORTH);


        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.add(Box.createVerticalStrut(45));


        userlabel = new JLabel("Username: ");
        assert customFont != null;
        userlabel.setFont(customFont.deriveFont(25f));
        userlabel.setForeground(Color.DARK_GRAY);
        inputPanel.add(userlabel);

        textFieldUser = new JTextField();
        textFieldUser.setPreferredSize(new Dimension(300, 30));
        textFieldUser.setFont( textFieldUser.getFont().deriveFont(20f));
        inputPanel.add(textFieldUser);
        inputPanel.add(Box.createVerticalStrut(60));

        passlabel = new JLabel("Password: ");
        passlabel.setFont(customFont.deriveFont(25f));
        passlabel.setForeground(Color.DARK_GRAY);
        inputPanel.add(passlabel);

        //textFieldPass = new JTextField();
        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(300, 30));
        passField.setFont( textFieldUser.getFont().deriveFont(20f));
        passField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем введенный пароль и преобразуем его в строку со звездочками
                char[] passwordChars = passField.getPassword();
                String password = new String(passwordChars);
                String maskedPassword = new String(new char[passwordChars.length]).replace('\0', '*');

                // Выводим звездочки вместо пароля
                System.out.println(maskedPassword);

                // Здесь можно добавить код для обработки пароля
            }
        });

        inputPanel.add(passField);
        inputPanel.add(Box.createVerticalStrut(60));

        contentPanel.add(inputPanel);

        login = new JButton("Login");
        login.setFocusable(false);
        login.setBackground(Color.PINK);
        login.setFont(customFont.deriveFont(20f));
        contentPanel.add(login,  BorderLayout.SOUTH);

        signUp = new JButton("Sign Up");

        signUp.setFocusable(false);
        signUp.setBackground(Color.PINK);
        signUp.setFont(customFont.deriveFont(20f));
        contentPanel.add(signUp,  BorderLayout.SOUTH);



















        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);


        setVisible(true);






    }

}
//textField.setPreferredSize(new Dimension(200, 30));
