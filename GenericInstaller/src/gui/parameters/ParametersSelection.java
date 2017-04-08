package gui.parameters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ParametersSelection extends JPanel implements ActionListener {
	// bool daje izbor izmedju checkbox i radio button
	private ButtonGroup bGroup;
	private String label;
	private ArrayList<JCheckBox> boxes;
	private ArrayList<String> parameters;

	public ParametersSelection(ArrayList<JTextField> names, boolean check,
			String label) {
		super();
		boxes = new ArrayList<>();
		this.label = label;
		setBackground(new Color(0, 255, 0, 0));
		setLayout(new MigLayout());
		setPreferredSize(new Dimension(300, 100));
		add(new JLabel(label), "wrap");
		if (check == true) {
			for (JTextField sel : names) {
				JCheckBox box = new JCheckBox(sel.getText());
				box.setBackground(Color.white);
				box.addActionListener(this);
				boxes.add(box);
				add(new JLabel(""));
				add(box, "wrap");
			}
		} else {
			bGroup = new ButtonGroup();
			for (JTextField sel : names) {
				JRadioButton button = new JRadioButton(sel.getText());
				button.setActionCommand(sel.getText());
				button.addActionListener(this);
				button.setBackground(Color.white);
				bGroup.add(button);
				add(new JLabel(""));
				add(button, "wrap");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (bGroup != null) {
			for (Enumeration<AbstractButton> buttons = bGroup.getElements(); buttons
					.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				if (button.isSelected()) {
					System.out.println("radio test");
					parameters.add(label + " " + button.getText());
				}
			}
		}
		
		for (JCheckBox box : boxes) {
			if (box.isSelected()) {
				System.out.println("cek test");
				parameters.add(label + " " + box.getText());
			}
		}
	}

	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}

}
