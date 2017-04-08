package controller.parameters.listeners.action;

import gui.editor.Editor;
import gui.parameters.dialogs.TextDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.parameters.TextModel;
import model.tree.ParameterModel;
import controller.tree.actions.NewParameterAction;

public class TextDialogListener implements ActionListener {

	private TextDialog parent;
	private JTextArea text;
	private ButtonGroup bGroup;
	private JTextField name;

	public TextDialogListener(TextDialog parent, JTextArea text,
			ButtonGroup bGroup, JTextField name) {
		super();
		this.parent = parent;
		this.text = text;
		this.bGroup = bGroup;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean btnType = false; // true = jedna linija, false = vise linija
		for (Enumeration<AbstractButton> buttons = bGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				if (button.getText() == Editor.getInstance()
						.getResourceBundle().getString("viseLinijaTeksta")) {
					btnType = false;
				} else {
					btnType = true;
				}
			}
		}
		TextModel model = new TextModel(text.getText(), btnType);
		@SuppressWarnings("unused")
		NewParameterAction paramAct = new NewParameterAction(name.getText(),
				ParameterModel.TEXT, model);
		parent.setVisible(false);
	}

}
