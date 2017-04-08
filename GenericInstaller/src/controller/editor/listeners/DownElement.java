package controller.editor.listeners;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownElement implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Editor.getInstance().getTree().downElement();
	}

}
