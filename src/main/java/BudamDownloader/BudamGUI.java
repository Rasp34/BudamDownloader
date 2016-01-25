package BudamDownloader;

import javax.swing.*;
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
        downloadButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
