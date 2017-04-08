package controller.editor.listeners;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseAll implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Editor.getInstance().getTree().closeAll();
	}

}
