package controller.parameters.listeners.action;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogBrowseListener implements ActionListener {

	JFileChooser browse;
	JDialog parent;
	JTextField path;

	public DialogBrowseListener(JDialog parent, JTextField path, String type) {
		super();
		this.path = path;
		this.parent = parent;
		browse = new JFileChooser();
		browse.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (type.equals("images")) {
			browse.setDialogTitle(Editor.getInstance().getResourceBundle()
					.getString("chooseImage"));
			browse.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileFilter imageFilter = new FileNameExtensionFilter(Editor
					.getInstance().getResourceBundle().getString("imageFiles"),
					ImageIO.getReaderFileSuffixes());
			browse.addChoosableFileFilter(imageFilter);
			browse.setAcceptAllFileFilterUsed(false);
		} else if (type.equals("directories")) {
			browse.setDialogTitle(Editor.getInstance().getResourceBundle()
					.getString("chooseDirectory"));
			browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			browse.setAcceptAllFileFilterUsed(false);
		} else if (type.equals("txt")) {
			browse.setDialogTitle(Editor.getInstance().getResourceBundle()
					.getString("chooseReadme"));
			FileNameExtensionFilter txt = new FileNameExtensionFilter(Editor
					.getInstance().getResourceBundle().getString("txtFiles"),
					"txt");
			browse.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			browse.addChoosableFileFilter(txt);
			browse.setAcceptAllFileFilterUsed(false);
		} else if (type.equals("exe")) {
			browse.setDialogTitle(Editor.getInstance().getResourceBundle()
					.getString("exeTitle"));
			browse.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			browse.setAcceptAllFileFilterUsed(true);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			browse.showOpenDialog(parent);
			path.setText(browse.getSelectedFile().getPath());
		} catch (Exception i) {
			System.err.println("FileChooser prekinut!");
		}
	}

}
