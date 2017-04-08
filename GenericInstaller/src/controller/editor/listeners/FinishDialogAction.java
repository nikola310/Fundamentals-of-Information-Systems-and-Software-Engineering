package controller.editor.listeners;

import gui.editor.dialogs.FinishDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FinishDialogAction implements ActionListener{

	private JFrame parent;
	
	public FinishDialogAction(JFrame parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FinishDialog dialog = new FinishDialog(parent);
		dialog.setVisible(true);
	}

}
