package controller.installation;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClosePanelListener implements ActionListener {

	private JFrame parent;

	public ClosePanelListener(JFrame parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int retVal = JOptionPane.showConfirmDialog(
				parent,
				Editor.getInstance().getResourceBundle()
						.getString("CloseInstall"),
				Editor.getInstance().getResourceBundle()
						.getString("ConfirmExitInstall"),
				JOptionPane.YES_NO_OPTION);
		if (retVal == JOptionPane.YES_OPTION)
			System.exit(0); // parent.setVisible(false);
	}

}
