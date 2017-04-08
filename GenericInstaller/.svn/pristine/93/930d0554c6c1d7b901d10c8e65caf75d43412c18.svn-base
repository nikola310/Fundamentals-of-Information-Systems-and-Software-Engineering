package controller.installation;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SysReqBrowseListener implements ActionListener{

	private JFrame parent;
	private JTextField path;
	private JFileChooser browse;
	
	public SysReqBrowseListener(JFrame parent, JTextField path) {
		super();
		this.parent = parent;
		this.path = path;
		browse = new JFileChooser();
		browse.setCurrentDirectory(new File(System.getProperty("user.home")));
		browse.setDialogTitle(Editor.getInstance().getResourceBundle()
				.getString("chooseDirectory"));
		browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		browse.setAcceptAllFileFilterUsed(false);
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
