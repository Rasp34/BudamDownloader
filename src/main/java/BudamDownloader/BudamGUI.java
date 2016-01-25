package BudamDownloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class BudamGUI {
    private JFormattedTextField podcastFormattedTextField;
    private JButton downloadButton;
    private JPanel panel;
    private JLabel podcastLable;
    private JLabel statusLable;
    private JLabel statLable;


    public BudamGUI() {

    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        JFrame mainFrame = new JFrame("Budam Downloader");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        BudamGUI budamGUI = new BudamGUI();
        mainFrame.setSize(new Dimension(270, 130));
        mainFrame.setResizable(false);
        mainFrame.setContentPane(budamGUI.panel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.pack();
        mainFrame.setVisible(true);


    }

}
