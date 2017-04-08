package controller.installation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class InstallListener implements ActionListener {

	/*
	 * Listener koji vrsi kopiranje paketa za instalaciju na odredjenu lokaciju
	 * pritiskom na finish dugme iz progress frejma
	 */
	private String installationPath;

	public InstallListener(String installationPath) {
		super();
		this.installationPath = installationPath;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		File src = new File(System.getProperty("user.dir") + File.separatorChar
				+ "Files" + File.separatorChar + "data");
		try {
			FileUtils.copyDirectory(src, new File(installationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File icon = new File(System.getProperty("user.dir")
				+ File.separatorChar + "Files" + File.separatorChar
				+ "user_images");
		try {
			FileUtils.copyDirectory(icon, new File(installationPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Nema ikonice!");
		}

	}

}
