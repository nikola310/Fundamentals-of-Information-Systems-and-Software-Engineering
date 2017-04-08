package controller.installation;

import gui.ProgressFrame;
import gui.preview.PanelPreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.serialization.ExportText;

public class SysReqInstallListener implements ActionListener {

	private JFrame parent;
	private JTextField path;
	PanelPreview panel;

	public SysReqInstallListener(JFrame parent, JTextField path, PanelPreview panel) {
		super();
		this.parent = parent;
		this.path = path;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.setVisible(false);
		@SuppressWarnings("unused")
		ProgressFrame progress = new ProgressFrame(path.getText());
		@SuppressWarnings("unused")
		ExportText export = new ExportText(panel.getParameters(),panel.getPanels());
	}

}
