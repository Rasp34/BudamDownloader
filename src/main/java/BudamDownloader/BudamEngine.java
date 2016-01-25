package BudamDownloader;

public class BudamEngine {
	
	public static void main(String[] args) {
		
		GUIBudam generalGUI = new GUIBudam();
		DownloaderCore downloaderCore = new DownloaderCore(generalGUI);
		generalGUI.buttonDownloadListener.setDCore(downloaderCore);


	}
	

}
