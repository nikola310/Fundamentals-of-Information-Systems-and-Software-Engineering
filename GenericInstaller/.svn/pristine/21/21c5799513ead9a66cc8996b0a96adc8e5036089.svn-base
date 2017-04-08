package controller.parameters.listeners.action;

import gui.parameters.dialogs.LabelDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.parameters.LabelModel;
import model.tree.ParameterModel;
import controller.tree.actions.NewParameterAction;

public class LabelDialogListener implements ActionListener {

	private JTextArea text; // tekst labele
	private LabelDialog dialog;
	private JTextField name;

	public LabelDialogListener(JTextArea text, LabelDialog dialog,
			JTextField name) {
		super();
		this.text = text;
		this.dialog = dialog;
		this.name = name;
	}

	public void actionPerformed(ActionEvent e) {
		LabelModel model = new LabelModel(text.getText());
		@SuppressWarnings("unused")
		NewParameterAction paramAct = new NewParameterAction(name.getText(),
				ParameterModel.LABEL, model);
		dialog.setVisible(false);

	}

}
