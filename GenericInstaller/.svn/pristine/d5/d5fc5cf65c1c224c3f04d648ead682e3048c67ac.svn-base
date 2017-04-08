package controller.serialization;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.WorkSpaceTreeModel;

public class Save implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		WorkSpaceTreeModel model = (WorkSpaceTreeModel)Editor.getInstance().getTree().getModel().getRoot();
		SerializationWorkSpace s = new SerializationWorkSpace();
		s.save(model);
	}
	
}
