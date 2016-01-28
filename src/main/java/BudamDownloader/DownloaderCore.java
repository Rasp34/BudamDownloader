package BudamDownloader;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import sun.util.logging.resources.logging;


public class DownloaderCore {

	public DownloaderCore(String podcastNumber) {

//		Generate link string
		String linkPodcast = "http://myflex.org/yf/podru/budam" + podcastNumber + ".mp3";
		String podcast = "src/budam" + podcastNumber + ".mp3";

		//		Declare url connection
		URL url = null;
		URLConnection urlConnection = null;
		
//		Create input buffer
		BufferedInputStream bufferedInputStream = null;
		int bufferSize = 4 * 1024;
		
//		Create output to file
		FileOutputStream fileOutputStream = null;
		
		try {
			url = new URL(linkPodcast);
			urlConnection = url.openConnection();
			
			bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream(), bufferSize);
			fileOutputStream = new FileOutputStream(podcast);
			
/*			---------------------------------------------------
 * 			Download action
 * 			Interaction input and output buffer
 * 			---------------------------------------------------
*/			
			
			int dataSize;
			byte[] inputDataArray = new byte[4*1024];
			int countStr = 0;
			
//			message to user
			System.out.println("Download file... please wait..." + "\n" );
			
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
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally{

			try {

//				Close input stream
//				inputStream.close();
				bufferedInputStream.close();
				fileOutputStream.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		

	}
	
}
