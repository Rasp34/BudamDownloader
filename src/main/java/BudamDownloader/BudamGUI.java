package BudamDownloader;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

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

                Thread threadExecution = new Thread(new Runnable() {
                    public void run() {

                        try {

//                              Прочитаем строку с поля ввода
                            String numPd = podcastFormattedTextField.getText();


//                              Распарсим строку для проверки (Не понравилось как работает MaskFormatter, не для этого случая)
                            boolean validString;

//                              Проверим длину строки
                            if (numPd.isEmpty()) {
                                validString = false;
                            }else {
//                                Проверим наличие символов
                                validString = true;
                                for (int i = 0; i < numPd.length(); i++) {

                                    if (!(Character.isDigit(numPd.charAt(i)))) {
                                        validString = false;
                                        break;
                                    }
                                }

                            }

                            if (validString) {
//                                  Отключим интерфейс и сообщим пользователю о загрузке
                                interfaceDisable(true);

//                                  Запустим ядро загрузки
                                new DownloaderCore(numPd);

//                                  После загрузки включим интерфейс
                                interfaceDisable(false);

                            }else {
//                                  Если не цифра, то сообщим пользователю об ошибке
                                asserEr();
                            }


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

    private void asserEr() {
        statLable.setText("Invalid number!");
    }

    private void interfaceDisable(boolean setEnable) throws InvocationTargetException, InterruptedException {

        if (setEnable) {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    downloadButton.setEnabled(false);
                    statLable.setText("Downloading.. Wait..");
                    podcastFormattedTextField.setEnabled(false);
                }
            });
        }else {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    downloadButton.setEnabled(true);
                    statLable.setText("Complete " + podcastLable.getText() + "!");
                    podcastFormattedTextField.setEnabled(true);
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
        public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ParseException {

            JFrame mainFrame = new JFrame("Budam Downloader");

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            BudamGUI budamGUI = new BudamGUI();
            mainFrame.setSize(new Dimension(270, 130));
            mainFrame.setResizable(false);

            mainFrame.setContentPane(budamGUI.panel);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);


    }

}
