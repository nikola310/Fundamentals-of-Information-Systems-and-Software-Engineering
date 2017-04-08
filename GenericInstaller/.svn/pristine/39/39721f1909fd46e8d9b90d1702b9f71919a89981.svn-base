package controller.parameters.listeners.action;

import gui.editor.Editor;
import gui.parameters.dialogs.ImageDialog;
import gui.parameters.dialogs.LabelDialog;
import gui.parameters.dialogs.PathDialog;
import gui.parameters.dialogs.SelectionDialog;
import gui.parameters.dialogs.TextDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SelectParameterTypeListener implements ActionListener {
	private JDialog dialog;
	private JTextField txt;
	private JFrame parent;
	@SuppressWarnings("rawtypes")
	private JComboBox cb;
	// dijalozi za pozivanje parametara
	private TextDialog txtDialog;
	private ImageDialog imgDialog;
	private SelectionDialog selDialog;
	private PathDialog pthDialog;
	private LabelDialog lblDialog;
	private JTextField name;

	/*public JFrame getParent() {
		return parent;
	}

	public JTextField getName() {
		return name;
	}*/

	public void setName(JTextField name) {
		this.name = name;
	}
	
	
	public SelectParameterTypeListener(JDialog dialog, JTextField txt,
			@SuppressWarnings("rawtypes") JComboBox cb, JTextField name) {
		this.dialog = dialog;
		this.txt = txt;
		this.cb = cb;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String pom = txt.getText();
		if (pom.length() != 0) {
			// u zavisnosti od izbora parametra iz combo boxa otvara se
			// odgovarajuci dijalog
			dialog.setVisible(false);
			String selected = (String) cb.getSelectedItem();
			if (selected == Editor.getInstance().getResourceBundle()
					.getString("tekst")) {
				txtDialog = new TextDialog(parent, name);
				txtDialog.setVisible(true);
			} else if (selected == Editor.getInstance().getResourceBundle()
					.getString("slika")) {
				imgDialog = new ImageDialog(parent, name);
				imgDialog.setVisible(true);
			} else if (selected == Editor.getInstance().getResourceBundle()
					.getString("labela")) {
				lblDialog = new LabelDialog(parent, name);
				lblDialog.setVisible(true);
			} else if (selected == Editor.getInstance().getResourceBundle()
					.getString("putanja")) {
				pthDialog = new PathDialog(parent, name);
				pthDialog.setVisible(true);
			} else if (selected == Editor.getInstance().getResourceBundle()
					.getString("selekcija")) {
				selDialog = new SelectionDialog(parent, name);
				selDialog.setVisible(true);
			}
		} else {
			// ako je jtextfield prazan, iskace dijalog
			JOptionPane.showMessageDialog(dialog, Editor.getInstance()
					.getResourceBundle().getString("plsParam"));
		}
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}


	public JDialog getDialog() {
		return dialog;
	}


	public void setDialog(JDialog dialog) {
		this.dialog = dialog;
	}

}
