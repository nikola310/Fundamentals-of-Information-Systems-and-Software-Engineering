package gui.parameters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ParametersText extends JPanel {
	private JTextArea area;
	private JTextField field;

	public ParametersText(String string, boolean bool) {
		super();
		setPreferredSize(new Dimension(300, 30));
		setBackground(new Color(0, 255, 0, 0));
		JLabel labela = new JLabel();
		labela.setText(string);
		labela.setSize(100, 30);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(labela);

		if (bool) {
			field = new JTextField("");
			field.setPreferredSize(new Dimension(200, 30));
			field.setMaximumSize(field.getPreferredSize());

			add(field);
		}

		else {
			JPanel panel = new JPanel();
			setPreferredSize(new Dimension(300, 100));
			panel.setPreferredSize(new Dimension(200, 100));

			area = new JTextArea("");
			area.setLineWrap(true);
			area.setVisible(true);

			JScrollPane scroll = new JScrollPane(area);
			scroll.setPreferredSize(panel.getPreferredSize());

			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			panel.add(scroll, BorderLayout.CENTER);
			add(panel);
		}

	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}
}
