package gui.parameters;

import gui.editor.Editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ParametersPath extends JPanel implements ActionListener {
	private String destination;
	private JTextField tfield;
	private ArrayList<String> parameters;
	private String label;

	public ParametersPath(String label, String destination) {
		super();
		this.label = label;
		this.destination = destination;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(new Color(0, 255, 0, 0));
		setPreferredSize(new Dimension(500, 20));
		JButton browse = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Pretrazi"));
		browse.addActionListener(this);
		JLabel labela = new JLabel(label);
		tfield = new JTextField(destination);
		tfield.setPreferredSize(new Dimension(300, 20));

		add(labela);
		add(tfield);
		add(browse);

	}

	JFileChooser chooser = new JFileChooser();

	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser(destination);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			chooser.getSelectedFile();
			File fajl = chooser.getSelectedFile();
			destination = fajl.getAbsolutePath();
			parameters.add(label + " " + destination);
		}
	}

	public JTextField getTfield() {
		return tfield;
	}

	public void setTfield(JTextField tfield) {
		this.tfield = tfield;
	}

	public ArrayList<String> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}

}