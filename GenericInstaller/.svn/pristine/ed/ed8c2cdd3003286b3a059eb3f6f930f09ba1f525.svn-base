package controller.parameters.listeners.action;

import gui.parameters.dialogs.PathDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.parameters.PathModel;
import model.tree.ParameterModel;
import controller.tree.actions.NewParameterAction;

public class PathDialogListener implements ActionListener {

	private PathDialog parent;
	private JTextArea text;
	private JTextField path;
	private JTextField name;
	
	public PathDialogListener(JTextField name, PathDialog parent, JTextArea text, JTextField path) {
		super();
		this.parent = parent;
		this.text = text;
		this.path = path;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PathModel model = new PathModel(text.getText(), path.getText());
		@SuppressWarnings("unused")
		NewParameterAction paramAct = new NewParameterAction(name.getText(), ParameterModel.PATH, model);
		parent.setVisible(false);
	}

}
