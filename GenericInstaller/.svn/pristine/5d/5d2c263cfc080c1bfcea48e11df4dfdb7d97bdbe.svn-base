package controller.editor.listeners;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;

import org.apache.commons.io.FileUtils;

public class FinishFrameListener implements ActionListener {

	/*
	 * Listener koji podesava poslednji frejm, ovo obuhvata unos svoje pozdravne
	 * poruke, putanja do slike koju ce se koristiti kao ikona i naziv readme
	 * datoteke (uzima samo ime)
	 */
	private JDialog parent;
	private JTextArea description;
	private JTextField readmePath;
	private JTextField iconPath;

	public FinishFrameListener(JDialog parent, JTextArea description,
			JTextField readmePath, JTextField iconPath) {
		super();
		this.parent = parent;
		this.description = description;
		this.readmePath = readmePath;
		this.iconPath = iconPath;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();
		FinishModel fin = root.getFinish();
		fin.setDescription(description.getText());
		File img = new File(iconPath.getText());
		File imgDest = new File(System.getProperty("user.dir")
				+ File.separatorChar + "Files" + File.separatorChar + "finish");
		try {
			FileUtils.copyFileToDirectory(img, imgDest);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		File readme = new File(readmePath.getText());
		File readmeDest = new File(System.getProperty("user.dir")
				+ File.separatorChar + "Files" + File.separatorChar + "finish");
		try {
			FileUtils.copyFileToDirectory(readme, readmeDest);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String iconName = img.getName();
		String readmeName = readme.getName();
		fin.setIcon(iconName);
		fin.setReadme(readmeName);
		parent.setVisible(false);
	}
}
