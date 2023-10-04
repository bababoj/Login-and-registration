package Frames;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;


public class LogInFrame extends JFrame {

    private JLabel nameFrame;
    private JLabel userlabel;
    private JLabel passlabel;
    @Getter
    private JTextField textFieldUser;
    @Getter
    private JPasswordField passField;
    @Getter
    private JButton signUp;
    @Getter
    private JButton login;

    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel colorStripe;

    private JPanel inputPanel;
    public User user;


    public LogInFrame(){

        super("Sign In"); //Title
        // Create the font
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Albert.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        // Frame settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        //Settings of panels
        colorStripe = new JPanel();
        colorStripe.setBackground(Color.PINK);
        colorStripe.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(colorStripe, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        nameFrame = new JLabel("LOGIN");
        nameFrame.setFont(customFont);
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

        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(300, 30));
        passField.setFont( textFieldUser.getFont().deriveFont(20f));
        passField.addActionListener(e -> {
            // Get the entered password and convert it into a string with asterisks
            char[] passwordChars = passField.getPassword();
            String password = new String(passwordChars);
            String maskedPassword = new String(new char[passwordChars.length]).replace('\0', '*');

            // Display asterisks instead of the password
            System.out.println(maskedPassword);

        });

        inputPanel.add(passField);
        inputPanel.add(Box.createVerticalStrut(60));

        contentPanel.add(inputPanel);
        // button for log in
        login = new JButton("Login");
        login.setFocusable(false);
        login.setBackground(Color.PINK);
        login.setFont(customFont.deriveFont(20f));
        login.addActionListener(e -> {

            //check if the user is in the database
            String username = textFieldUser.getText();
            String password = String.valueOf(passField.getPassword());
            user = getAuthenticatedUser(username, password);

            if (user != null) {
                System.out.println("Succeful login: " + username);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(LogInFrame.this,
                        "Username or Password Invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
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

    private User getAuthenticatedUser(String username, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully
            //Cheking with SQL command
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve and store data from the ResultSet into the User object
                user = new User();
                user.email = resultSet.getString("email");
                user.fname = resultSet.getString("fname");
                user.lname = resultSet.getString("lname");
                user.username = resultSet.getString("username");
                user.phone = resultSet.getString("phone");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
}
