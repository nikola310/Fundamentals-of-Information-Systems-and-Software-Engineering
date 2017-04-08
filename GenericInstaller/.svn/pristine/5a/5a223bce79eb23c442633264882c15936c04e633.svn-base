package controller.parameters.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddSelectionListener implements ActionListener {

	private JScrollPane scroll;
	private JPanel parent;
	private ArrayList<JTextField> choices;
	private int choiceNum = 1;

	public AddSelectionListener(JPanel parent, JScrollPane scroll, ArrayList<JTextField> choices) {
		super();
		this.parent = parent;
		this.scroll = scroll;
		this.choices = choices;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTextField newSelection = new JTextField(30);
		choices.add(newSelection);
		parent.invalidate();
		parent.add(new JLabel("Choice " + choiceNum + ": "));
		choiceNum++;
		parent.add(newSelection, "wrap");
		parent.validate();
		scroll.validate();
	}

}
