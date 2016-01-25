package BudamDownloader;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import sun.util.logging.resources.logging;


public class DownloaderCore {
	
	GUIBudam guiBudam = null;
	JButton button = null;
	JFormattedTextField textField = null;
	UISwicher uiSwicher = null;

	public DownloaderCore(GUIBudam guiBudam) {
		
		this.guiBudam = guiBudam;
		this.button = guiBudam.bDownload;
		this.textField = guiBudam.tNumberPodcast;
		
//		Create parallel process for enable/disable button and text
		uiSwicher = new UISwicher(guiBudam.bDownload, true, guiBudam.tNumberPodcast, true);

		
	} 
	
	public void beginDownload() {
		
//		Generate link string
		int getPodcast = Integer.parseInt(guiBudam.tNumberPodcast.getText()); // get number podcast form text field
		String linkPodcast = "http://myflex.org/yf/podru/budam" + getPodcast + ".mp3";
		String podcast = "src/budam" + getPodcast + ".mp3";
		
//		Disable text field and button
		guiBudam.bDownload.setEnabled(false);
		guiBudam.tNumberPodcast.setEnabled(false);
		
//		Declare url connection
		URL url = null;
		URLConnection urlConnection = null;
		
//		Create input buffer
		BufferedInputStream bufferedInputStream = null;
		int bufferSize = 4 * 1024;
		
//		Create output to file
		FileOutputStream fileOutputStream = null;
		
		guiBudam.lStatus.setText("Download... please wait");
		
		try {
			url = new URL(linkPodcast);
			urlConnection = url.openConnection();
			
			bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream(), bufferSize);
			fileOutputStream = new FileOutputStream(podcast);
			
//			Disable text field and button
//			������ �� ��� ������� �������, ����� ���� �� ������
//			button.setEnabled(false);
//			textField.setEnabled(false);
			
//			������������� ���������� ����� thread
			uiSwicher.setEnable(false, false);
			uiSwicher.start();
			
/*			---------------------------------------------------
 * 			Download action
 * 			Interaction input and output buffer
 * 			---------------------------------------------------
*/			
			
			int dataSize;
			byte[] inputDataArray = new byte[4*1024];
			int countStr = 0;
			
//			message to user
			System.out.println("Download file... please wait..." + "\nBytes:\n" );
			
//			mark time
			long timeSet = System.currentTimeMillis();
			long timeMin;
			
//			transition data to output stream
			while ((dataSize =  bufferedInputStream.read(inputDataArray))!= -1) {
				
				if (countStr == 16) {
					
					System.out.print("\n");
					countStr = 0;
					
				} else {
					
					System.out.print(dataSize + " ");
					countStr ++;
				}
				
				fileOutputStream.write(inputDataArray);
				
			}
			
//			Count time
			timeSet = (System.currentTimeMillis() - timeSet) / 1000;
			timeMin = timeSet / 60;
//			message to user
			System.out.println("\nSuccessfull!!! File download for time: " + timeMin + " min | " + timeSet + "sec");
			guiBudam.lStatus.setText("Complete " + guiBudam.tNumberPodcast.getText());
			
//			Set last podcast download
			guiBudam.lNumberLast.setText(guiBudam.tNumberPodcast.getText());
			
//			Enable text field and button
//			guiBudam.bDownload.setEnabled(true);
//			guiBudam.tNumberPodcast.setEnabled(true);
			uiSwicher.setEnable(true, true);
			uiSwicher.start();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally{

			try {

//				Close input stream
//				inputStream.close();
				bufferedInputStream.close();
				fileOutputStream.flush();
				fileOutputStream.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		

	}
	
}
