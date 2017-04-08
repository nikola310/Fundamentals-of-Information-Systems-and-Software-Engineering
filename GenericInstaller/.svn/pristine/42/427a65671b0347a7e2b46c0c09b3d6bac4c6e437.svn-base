package controller.parameters.listeners.action;

import gui.editor.Editor;
import gui.parameters.dialogs.SelectionDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.parameters.SelectionModel;
import model.tree.ParameterModel;
import controller.tree.actions.NewParameterAction;

public class SelectionDialogListener implements ActionListener {

	private SelectionDialog parent;
	private ArrayList<JTextField> btns; // vrednosti koje ce imati dugmad
	private ButtonGroup type;
	private JTextField name;
	private JTextArea selName;

	public SelectionDialogListener(SelectionDialog parent,
			ArrayList<JTextField> btns, ButtonGroup type, JTextField name,
			JTextArea selName) {
		super();
		this.parent = parent;
		this.btns = btns;
		this.type = type;
		this.name = name;
		this.selName = selName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		boolean btnType = true; // tip dugmadi, true==checkbox,
								// false==radiobutton
		for (Enumeration<AbstractButton> buttons = type.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				if (button.getText() == "Checkbox") {
					btnType = true;
				} else {
					btnType = false;
				}
			}
		}

		if (btns.size() > 0) {
			SelectionModel model = new SelectionModel(btnType, btns,
					selName.getText());
			@SuppressWarnings("unused")
			NewParameterAction paramAct = new NewParameterAction(
					name.getText(), ParameterModel.SELECTION, model);
			parent.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(parent, Editor.getInstance()
					.getResourceBundle().getString("plsAddSelParam"));
		}

	}
}
