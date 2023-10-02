package Frames;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class LogInFrame extends JFrame {

    private JLabel nameFrame;
    private JLabel userlabel;
    private JLabel passlabel;
    private JTextField textFieldUser;
    private JTextField textFieldPass;
    @Getter
    private JButton registration;
    @Getter
    private JButton login;

    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel colorStripe;

    public LogInFrame(){

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


        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);


        setVisible(true);






    }

}
//textField.setPreferredSize(new Dimension(200, 30));
