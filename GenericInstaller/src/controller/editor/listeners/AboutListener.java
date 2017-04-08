package controller.editor.listeners;

import gui.editor.dialogs.AboutDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AboutListener implements ActionListener {

	private JFrame parent;

	public AboutListener(JFrame parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AboutDialog about = new AboutDialog(parent);
		about.setVisible(true);
	}

}
