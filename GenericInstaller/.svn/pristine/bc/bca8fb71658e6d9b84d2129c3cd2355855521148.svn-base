package gui.parameters.dialogs;

import gui.editor.Editor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import controller.parameters.listeners.action.AddSelectionListener;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.SelectionDialogListener;

@SuppressWarnings("serial")
public class SelectionDialog extends JDialog {

	private ArrayList<JTextField> choicesList = new ArrayList<JTextField>();
	private JButton ok;

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public SelectionDialog(JFrame parent, JTextField name) {
		super(parent, Editor.getInstance().getResourceBundle()
				.getString("addSelectionParameter"), true);
		setLayout(new BorderLayout());
		setSize(500, 500);
		setLocationRelativeTo(parent);

		ImageIcon icon = new ImageIcon("Images/Icons/Parameters/selection.png");
		setIconImage(icon.getImage());

		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nameChoices = new JLabel(Editor.getInstance()
				.getResourceBundle().getString("dodatniTekstLabela"));
		JTextArea nameText = new JTextArea(10, 70);
		nameText.setLineWrap(true);
		JScrollPane nameScroll = new JScrollPane(nameText);

		north.add(nameChoices);
		north.add(nameScroll);

		JPanel center = new JPanel(new BorderLayout());

		JPanel choices = new JPanel(new MigLayout());
		JScrollPane choicesScroll = new JScrollPane(choices);

		JButton addChoice = new JButton(Editor.getInstance()
				.getResourceBundle().getString("dodajIzbor"));

		AddSelectionListener selLis = new AddSelectionListener(choices,
				choicesScroll, choicesList);
		addChoice.addActionListener(selLis);
		JPanel cntNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cntNorth.add(addChoice);

		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JRadioButton check = new JRadioButton("Checkbox");
		check.setSelected(true);
		JRadioButton radio = new JRadioButton("Radio button");
		ButtonGroup type = new ButtonGroup();
		type.add(check);
		type.add(radio);

		ok = new JButton("Ok");

		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));


		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		SelectionDialogListener okListen = new SelectionDialogListener(this,
				choicesList, type, name, nameText);
		ok.addActionListener(okListen);

		JPanel radioButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		radioButtons.add(check);
		radioButtons.add(radio);

		center.add(cntNorth, BorderLayout.NORTH);
		center.add(choicesScroll, BorderLayout.CENTER);
		center.add(radioButtons, BorderLayout.SOUTH);
		btns.add(ok);
		btns.add(cancel);

		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(btns, BorderLayout.SOUTH);
	}
}
