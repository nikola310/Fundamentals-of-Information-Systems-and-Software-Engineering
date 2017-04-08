package gui.editor.dialogs;

import gui.editor.Editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.parameters.listeners.action.DialogCancelListener;
import controller.tree.actions.NewPanelAction;

@SuppressWarnings("serial")
public class PanelDialog extends JDialog{
	private JLabel nameLabel;
	private JTextField nameText;
	
	public PanelDialog( JFrame parent ) {
		super(parent, Editor.getInstance().getResourceBundle().getString("addPanel"),true);
		
		setLayout( new BorderLayout());
		
		setSize(400,100);
		setLocationRelativeTo(parent);
		
		ImageIcon icon = new ImageIcon("Images/Icons/add_panel.png");
		setIconImage(icon.getImage());
		
		JPanel name = new JPanel();
		
		nameLabel = new JLabel(Editor.getInstance().getResourceBundle().getString("setPanelName"));
		nameText = new JTextField("");
		nameText.setPreferredSize(new Dimension(100,20));
		
		name.add(nameLabel);
		name.add(nameText);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton ok = new JButton(Editor.getInstance().getResourceBundle().getString("OK"));
		
		NewPanelAction newPanel = new NewPanelAction(nameText,this);
		ok.addActionListener(newPanel);
		nameText.addActionListener(newPanel);
		
		JButton cancel = new JButton(Editor.getInstance().getResourceBundle().getString("Ponisti"));
		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		
		buttons.add(ok);
		buttons.add(cancel);
					
		add(name, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}
}
