package BudamDownloader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDownloadListener implements ActionListener {
	
	private DownloaderCore core = null;
	
	public void setDCore (DownloaderCore core) {
		
		this.core = core;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		core.beginDownload();
		
	}

}
