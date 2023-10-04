package Frames;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SignUpFrame extends JFrame {
    private JLabel nameFrame;
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel colorStripe;
    private JPanel inputPanel;
    @Getter
    private List<JLabel> labels;
    @Getter
    private List<JTextField> textFields;
    @Getter
    private JButton register;
    @Getter
    private JButton cancel;
    public User user;

    public SignUpFrame(){

        super("Sign Up"); //Title
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Albert.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        //frame settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 640);
        setResizable(false);
        setLocationRelativeTo(null);
        //create a design panels
        mainPanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        colorStripe = new JPanel();
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);

        //Pink Stripe settings
        colorStripe.setBackground(Color.PINK);
        colorStripe.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));
        mainPanel.add(colorStripe, BorderLayout.EAST);

        // Title on frame
        nameFrame = new JLabel("SIGN UP");
        nameFrame.setFont(customFont);
        contentPanel.add(nameFrame, BorderLayout.NORTH);

        //create arrays to simplify the code
        String[] data = new String[]{"Email:", "First name: ", "Last name:", "User name: ", "Phone number: ", "Password: ", "Confirm Password: "};
        labels = new ArrayList<>();
        textFields = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            // labels settings
            JLabel label = new JLabel(data[i]);
            assert customFont != null;
            label.setFont(customFont.deriveFont(25f));
            label.setForeground(Color.DARK_GRAY);
            labels.add(label);
            // textFields settings
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(140, 30));
            textField.setFont(textField.getFont().deriveFont(20f));
            textFields.add(textField);
        }
        //add arrays on panel
        for (int i = 0; i < 7; i++) {
            inputPanel.add(labels.get(i));
            inputPanel.add(textFields.get(i));
        }
        inputPanel.add(Box.createVerticalStrut(25));
        contentPanel.add(inputPanel, BorderLayout.WEST);
        // Registration button for registration, which will send all information to the server
        register = new JButton("Submit");
        register.setBackground(Color.PINK);
        register.setFont(customFont.deriveFont(25f));
        register.setFocusable(false);
        register.addActionListener(e -> {
            registerUser(); //calls the function to register the user
        });
        //creating a button to cancel registration
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.PINK);
        cancel.setFont(customFont.deriveFont(25f));
        cancel.setFocusable(false);
        cancel.addActionListener(e -> dispose());

        contentPanel.add(register);
        contentPanel.add(cancel);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);

        setVisible(true);

    }
    private void registerUser() {
        // Define the names of the input fields.
        String[] fieldNames = { "Email", "First Name", "Last Name", "Username", "Phone Number", "Password", "Confirm Password" };
        String[] fieldValues = new String[7];
        // Loop through the text fields to retrieve their values and perform validation
        for (int i = 0; i < fieldNames.length; i++) {
            fieldValues[i] = getTextFields().get(i).getText();
            // Check if the field is empty and display an error message if it is
            if (fieldValues[i].isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter " + fieldNames[i] + " field",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        String password = fieldValues[5];
        String confPass = fieldValues[6];
        // Check if the password and confirm password match
        if (!password.equals(confPass)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // If all validations pass, proceed to register the user
            user = addUserToDatabase(fieldValues[0], fieldValues[1], fieldValues[2], fieldValues[3], fieldValues[4], password);
            if (user != null) {
                System.out.println("Successful registration: " + fieldValues[3]);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to register new user",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private User addUserToDatabase(String email, String fname, String lname, String username, String phoneNum, String password) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (email, fname, lname, username, phone, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, phoneNum);
            preparedStatement.setString(6, password);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.email = email;
                user.fname = fname;
                user.fname = lname;
                user.fname = username;
                user.phone = phoneNum;
                user.password = password;
            }
            //close connect
            stmt.close();
            conn.close();
            //in case of exception
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

}
