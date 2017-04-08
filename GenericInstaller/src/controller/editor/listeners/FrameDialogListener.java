package controller.editor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import model.tree.PanelModel;

public class FrameDialogListener implements ActionListener {

	/*
	 * Listener koji podesava odredjeni frejm, tj. menja naslov, velicinu i
	 * ukljucuje/iskljucuje opciju za promenu velicine
	 */
	private JTextField width;
	private JTextField height;
	private PanelModel model;
	private JDialog parent;
	private JCheckBox resizable;
	private JTextField name;

	public FrameDialogListener(JTextField width, JTextField height,
			PanelModel model, JDialog parent, JCheckBox resizable,
			JTextField name) {
		super();
		this.width = width;
		this.height = height;
		this.model = model;
		this.parent = parent;
		this.resizable = resizable;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.setHeight(Integer.parseInt(height.getText()));
		model.setWidth(Integer.parseInt(width.getText()));
		model.setResizable(resizable.isSelected());
		model.setTitle(name.getText());

		parent.setVisible(false);
	}

}
