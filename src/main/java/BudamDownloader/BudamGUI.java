package BudamDownloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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


    /**
     *  Constructor
     */
    public BudamGUI() {

        downloadButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action Push");
//                Thread.currentThread().setName("TwoThread");
                Thread threadExecution = new Thread(new Runnable() {
                    public void run() {

                        try {
//                        Отключим интерфейс
                            buttonDisable(true);
//                        Запустим ядро загрузки
                            new DownloaderCore(podcastFormattedTextField.getText());
                            buttonDisable(false);

                        }catch (Exception e1) {
                                e1.printStackTrace();
                            }

                    }
                });
                threadExecution.setName("ThreadCount");
                threadExecution.start();
            }
        });
    }

    private void buttonDisable(boolean setEnable) throws InvocationTargetException, InterruptedException {

        if (setEnable) {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    downloadButton.setEnabled(false);
                }
            });
        }else {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    downloadButton.setEnabled(true);
                }
            });
        }

    }

    /**
     * ------------------------------------------------------------------------------
     *      MAIN METHOD
     * ------------------------------------------------------------------------------
     * @param args
     * @throws ClassNotFoundException
     * @throws UnsupportedLookAndFeelException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
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
