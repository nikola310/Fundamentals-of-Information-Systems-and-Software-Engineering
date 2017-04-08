package controller.installation;

import gui.FinishFrame;
import gui.ProgressFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextProgressListener implements ActionListener{

	private ProgressFrame parent;
	private String installDir;
	
	public NextProgressListener(ProgressFrame parent, String installDir) {
		super();
		this.parent = parent;
		this.installDir = installDir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		@SuppressWarnings("unused")
		FinishFrame fin = new FinishFrame(installDir);
		parent.setVisible(false);
	}

}
