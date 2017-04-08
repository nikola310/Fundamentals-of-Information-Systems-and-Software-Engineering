package controller.serialization;

import gui.editor.Editor;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BrowseFile {
	JFileChooser browse;
	String path;

	public BrowseFile(String type) {
		browse = new JFileChooser();
		browse.setCurrentDirectory(new File(System.getProperty("user.dir")));

		if (type.equals("directories")) {
			browse.setDialogTitle("Save workspace");
			browse.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			browse.setApproveButtonText("Save");
			browse.setAcceptAllFileFilterUsed(false);
		} else if (type.equals("nkvd")) {
			browse.setApproveButtonText("Open");
			browse.setDialogTitle(Editor.getInstance().getResourceBundle()
					.getString("chooseReadme"));
			FileNameExtensionFilter nkvd = new FileNameExtensionFilter(
					"Workspace", "nkvd");
			browse.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			browse.addChoosableFileFilter(nkvd);
			browse.setAcceptAllFileFilterUsed(false);
		}
		browse.showOpenDialog(Editor.getInstance());
		path = browse.getSelectedFile().getPath();

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public JFileChooser getBrowse() {
		return browse;
	}

	public void setBrowse(JFileChooser browse) {
		this.browse = browse;
	}

}
