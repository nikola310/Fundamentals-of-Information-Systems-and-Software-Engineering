package gui.editor.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import gui.editor.Editor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class HelpDialog extends JDialog {

	public HelpDialog(JFrame parent) {
		setModal(false);
		setSize(1000, 420);
		setBackground(Color.white);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(Editor.getInstance().getResourceBundle().getString("btnPomoc"));
		setLayout(new MigLayout());
		setResizable(false);
		setLocationRelativeTo(parent);
		ImageIcon icon = new ImageIcon("Images/IconLarge.png");
		setIconImage(icon.getImage());
		JLabel image = new JLabel(new ImageIcon("Images/Help.png"));

		JPanel panel = new JPanel(new MigLayout());
		JLabel label1 = new JLabel(Editor.getInstance().getResourceBundle().getString("help01"));
		JLabel label2 = new JLabel(Editor.getInstance().getResourceBundle().getString("help02"));
		JLabel label3 = new JLabel(
				Editor.getInstance().getResourceBundle().getString("help03"));
		JLabel label3Pom = new JLabel(Editor.getInstance().getResourceBundle().getString("help03pom"));
		JLabel label4 = new JLabel(Editor.getInstance().getResourceBundle().getString("help04"));
		JLabel label4Pom = new JLabel(Editor.getInstance().getResourceBundle().getString("help04pom"));
		JLabel label5 = new JLabel(Editor.getInstance().getResourceBundle().getString("help05"));
		JLabel label6 = new JLabel(Editor.getInstance().getResourceBundle().getString("help06"));
		JLabel label7 = new JLabel(Editor.getInstance().getResourceBundle().getString("help07"));
		JLabel label8 = new JLabel(Editor.getInstance().getResourceBundle().getString("help08"));
		JLabel label9 = new JLabel(Editor.getInstance().getResourceBundle().getString("help09"));
		JLabel label10 = new JLabel(Editor.getInstance().getResourceBundle().getString("help10"));
		JLabel label11 = new JLabel(Editor.getInstance().getResourceBundle().getString("help11"));
		JLabel label12 = new JLabel(Editor.getInstance().getResourceBundle().getString("help12"));
		JLabel label13 = new JLabel(Editor.getInstance().getResourceBundle().getString("help13"));
		JLabel label14 = new JLabel(Editor.getInstance().getResourceBundle().getString("help14"));
		
		panel.add(label1, "wrap");
		panel.add(label2, "wrap");
		panel.add(label3, "wrap");
		panel.add(label3Pom, "wrap");
		panel.add(label4, "wrap");
		panel.add(label4Pom, "wrap");
		panel.add(label5, "wrap");
		panel.add(label6, "wrap");
		panel.add(label7, "wrap");
		panel.add(label8, "wrap");
		panel.add(label9, "wrap");
		panel.add(label10, "wrap");
		panel.add(label11, "wrap");
		panel.add(label12, "wrap");
		panel.add(label13, "wrap");
		panel.add(label14, "wrap");
		
		add(image, BorderLayout.WEST);
		add(panel, BorderLayout.EAST);
	}

}
