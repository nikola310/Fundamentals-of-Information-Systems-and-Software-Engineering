package gui.editor.dialogs;

import gui.editor.Editor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog{
	
	public AboutDialog(JFrame parent){
		
		setModal(true);
		setSize(200, 150);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(Editor.getInstance().getResourceBundle().getString("btnOProgramu"));
		setResizable(false);
		setLayout(new MigLayout());
		ImageIcon icon = new ImageIcon("Images/IconLarge.png");
		setIconImage(icon.getImage());
		setLocationRelativeTo(parent);
		JLabel logo = new JLabel(icon);
		
		JLabel autori = new JLabel(Editor.getInstance().getResourceBundle().getString("Autori"));
		JLabel zivko = new JLabel(Editor.getInstance().getResourceBundle().getString("Zivko"));
		JLabel nikola = new JLabel(Editor.getInstance().getResourceBundle().getString("Nikola"));
		JLabel vladan = new JLabel(Editor.getInstance().getResourceBundle().getString("Vladan"));
		JLabel slavisa = new JLabel(Editor.getInstance().getResourceBundle().getString("Slavisa"));
		
		JPanel names = new JPanel(new MigLayout());
		names.add(autori, "wrap");
		names.add(zivko, "wrap");
		names.add(nikola, "wrap");
		names.add(vladan, "wrap");
		names.add(slavisa, "wrap");
		
		add(logo);
		add(names);
		
	}

}
