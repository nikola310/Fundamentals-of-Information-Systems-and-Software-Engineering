package controller.editor.listeners;

import gui.editor.Editor;
import gui.editor.dialogs.FrameDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FrameEditAction implements ActionListener {
	private JFrame parent;

	public FrameEditAction(JFrame parent) {
		this.setParent(parent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (Editor.getInstance().getTree().getLastSelectedPathComponent() == null) {
			//ako nema nijednog panela, onda ova operacija nije moguca
		} else {
			FrameDialog frame = new FrameDialog(parent);
			frame.setVisible(true);
		}
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

}
