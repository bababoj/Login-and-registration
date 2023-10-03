package Frames;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUpFrame extends JFrame {


    private JLabel nameFrame;
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel colorStripe;
    private JPanel inputPanel;
    private List<JLabel> labels;
    private List<JTextField> textFields;
    @Getter
    private JButton register;
    @Getter
    private JButton cancel;


    private String[] data;

    //        List<JLabel> labels = new ArrayList<>();
//        List<JTextField> textFields
//        List<JTextField> textFields



    public SignUpFrame(){

        super("Sign Up");
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Albert.ttf")).deriveFont(Font.PLAIN, 50);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        colorStripe = new JPanel();
        colorStripe.setBackground(Color.PINK);
        colorStripe.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(colorStripe, BorderLayout.EAST);

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        // contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        //  contentPanel.setLayout(new GridLayout(7, 1));

        nameFrame = new JLabel("SIGN UP");
        nameFrame.setFont(customFont);
        // nameFrame.setBounds(100, 300, 100, 30);
        contentPanel.add(nameFrame, BorderLayout.NORTH);

        data = new String[]{"email:", "First name: ", "Last name:", "User name: ", "Phone number: ", "Password: ", "Confirm Password: "};
        inputPanel = new JPanel();
        //inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);

      //  inputPanel.add(Box.createVerticalStrut(45));
        //inputPanel.setLayout(new GridLayout(14, 1)); // Создаем панель с сеткой 7x2
        labels = new ArrayList<>();
        textFields = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            JLabel label = new JLabel(data[i]);
            label.setFont(customFont.deriveFont(25f));
            label.setForeground(Color.DARK_GRAY);
            JTextField textField = new JTextField(); // 20 - предполагаемая ширина поля в символах
            textField.setPreferredSize(new Dimension(140, 30));
            textField.setFont( textField.getFont().deriveFont(20f));
            labels.add(label);
            textFields.add(textField);
        }
        for (int i = 0; i < 6; i++) {
            inputPanel.add(labels.get(i));
            inputPanel.add(textFields.get(i));
        }
        inputPanel.add(Box.createVerticalStrut(45));
        contentPanel.add(inputPanel, BorderLayout.WEST);

        register = new JButton("Submit");
        register.setBackground(Color.PINK);
        register.setFont(customFont.deriveFont(25f));
        register.setFocusable(false);


        cancel = new JButton("Cancel");
        cancel.setBackground(Color.PINK);
        cancel.setFont(customFont.deriveFont(25f));
        cancel.setFocusable(false);

        contentPanel.add(register);
        contentPanel.add(cancel);


//
//        // Создаем список для хранения JLabel и JTextField
//        List<JLabel> labels = new ArrayList<>();
//        List<JTextField> textFields = new ArrayList<>();
//
//        // Создаем 7 пар JLabel и JTextField и добавляем их в список
//        for (int i = 1; i <= 7; i++) {
//            JLabel label = new JLabel("Поле " + i + ": ");
//            JTextField textField = new JTextField(20); // 20 - предполагаемая ширина поля в символах
//            labels.add(label);
//            textFields.add(textField);
//        }
//
//        // Добавляем JLabel и JTextField на панель
//        for (int i = 0; i < 7; i++) {
//            panel.add(labels.get(i));
//            panel.add(textFields.get(i));
//        }
//
//        frame.add(panel);




        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);







    }








}
