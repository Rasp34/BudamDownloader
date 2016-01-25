package BudamDownloader;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;

public class GUIBudam {
	
//	Declarate object link;
	
	JPanel pFramePanel;
	JFormattedTextField tNumberPodcast;
	MaskFormatter numMaskFormatter;
	JLabel lRequirePodcast;
	JButton bDownload;
	JLabel lmarkLastPd;
	JLabel lNumberLast;
	JLabel lMarkStatus;
	JLabel lStatus;
	ButtonDownloadListener buttonDownloadListener;
	DownloaderCore core;
	
	String lastPodcast = "000";
	String status = "no";
	String currentPodcast;


	public GUIBudam() {
		
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//
//			e.printStackTrace();
//		}
		
		
//		Create general frame
		JFrame frame = new JFrame("BudamDownloader");
		frame.setSize(250, 150);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
//		Create inner panel
		pFramePanel = new JPanel();
		pFramePanel.setSize(new Dimension(250, 150));
		

//		Create number podcast text input
		
		try {
			numMaskFormatter = new MaskFormatter("###");
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		tNumberPodcast = new JFormattedTextField(numMaskFormatter);
//		tNumberPodcast.setValue(new Integer(0));
		tNumberPodcast.setColumns(3);
		
//		label LAST PODCAST
		lRequirePodcast = new JLabel("I want podcast: ");
		lRequirePodcast.setSize(new Dimension(120, 30));
		
//		button "Download"
		bDownload = new JButton("Download");
		bDownload.setSize(new Dimension(60, 30));
		
//		listener
		buttonDownloadListener = new ButtonDownloadListener();
		bDownload.addActionListener(buttonDownloadListener);
		
//		label mark last podcast
		lmarkLastPd = new JLabel("last podcast: ");
		lmarkLastPd.setSize(new Dimension(90, 30));
		
//		label number last podcast
		lNumberLast = new JLabel("000");
		lNumberLast.setSize(new Dimension(40, 30));
		
//		label mark status
		lMarkStatus = new JLabel("Status: ");
		lMarkStatus.setSize(new Dimension(80, 30));
		
//		label status 
		lStatus = new JLabel("- - -");
		lStatus.setSize(new Dimension(60, 80));
		
		
		
//		Create GridBag layout manager
		
		frame.setLayout(new FlowLayout());
		
		pFramePanel.setLayout(new GridBagLayout());
		GridBagConstraints consrtGB	= new GridBagConstraints();
		consrtGB.fill = GridBagConstraints.BOTH;
		consrtGB.anchor = GridBagConstraints.LINE_START;
		Insets insets = new Insets(4, 6, 3, 5);
		consrtGB.insets = insets;
		consrtGB.weightx = 1;
		
		consrtGB.gridx = 0;
		consrtGB.gridy = 0;
		pFramePanel.add(lRequirePodcast, consrtGB);
		
		consrtGB.gridx = 1;
		consrtGB.gridy = 0;
		consrtGB.fill = GridBagConstraints.NONE;
		pFramePanel.add(tNumberPodcast, consrtGB);
		
		consrtGB.gridx = 0;
		consrtGB.gridy = 1;
		consrtGB.fill = GridBagConstraints.BOTH;
		pFramePanel.add(bDownload, consrtGB);
		
		consrtGB.gridx = 0;
		consrtGB.gridy = 2;
		pFramePanel.add(lmarkLastPd, consrtGB);
		
		consrtGB.gridx = 1;
		consrtGB.gridy = 2;
		pFramePanel.add(lNumberLast, consrtGB);
		
		consrtGB.gridx = 0;
		consrtGB.gridy = 3;
		pFramePanel.add(lMarkStatus, consrtGB);
		
		consrtGB.gridx = 1;
		consrtGB.gridy = 3;
		pFramePanel.add(lStatus, consrtGB);
		
		frame.setContentPane(pFramePanel);
		
//		Set frame and panel are visible
		pFramePanel.setVisible(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


	}
	
	

}
