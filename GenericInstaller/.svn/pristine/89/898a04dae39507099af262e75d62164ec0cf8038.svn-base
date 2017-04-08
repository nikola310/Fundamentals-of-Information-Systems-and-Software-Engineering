package gui.parameters.dialogs;

import gui.editor.Editor;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.SelectParameterTypeListener;

@SuppressWarnings("serial")
public class ParameterDialog extends JDialog {

	private JTextField nameText;
	
	
	private String paramTypes[] = {Editor.getInstance().getResourceBundle().getString("tekst") , Editor.getInstance().getResourceBundle().getString("selekcija"), Editor.getInstance().getResourceBundle().getString("labela"), Editor.getInstance().getResourceBundle().getString("slika"),
			Editor.getInstance().getResourceBundle().getString("putanja") };

	public ParameterDialog(JFrame parent) {
		super(parent, Editor.getInstance().getResourceBundle().getString("addParameter"), true);
		setLayout(new MigLayout("wrap 3"));
		setSize(300, 150);
		setLocationRelativeTo(parent);
		setResizable(false);
		ImageIcon icon = new ImageIcon("Images/Icons/parameter.png");
		
		setIconImage(icon.getImage());

		// ime parametra
		JLabel nameLabel = new JLabel(Editor.getInstance().getResourceBundle().getString("setParameterName"));
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(100, 20));

		// izbor parametara
		JLabel paramLabel = new JLabel(Editor.getInstance().getResourceBundle().getString("setParameterType"));
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox paramsBox = new JComboBox(paramTypes);

		paramsBox.setSelectedIndex(0);
		paramsBox.setEditable(false);

		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton("Ok");
		SelectParameterTypeListener okL = new SelectParameterTypeListener(this,
				nameText, paramsBox, nameText);
		okL.setParent(parent);
		ok.addActionListener(okL);

		JButton cancel = new JButton(Editor.getInstance().getResourceBundle().getString("Ponisti"));
		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);

		buttons.add(ok);
		buttons.add(cancel);

		add(nameLabel);
		add(nameText, "wrap");
		add(paramLabel);
		add(paramsBox, "wrap");
		add(new JLabel(""));
		add(buttons);
	}

	public JTextField getNameText() {
		return nameText;
	}

	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}

}
