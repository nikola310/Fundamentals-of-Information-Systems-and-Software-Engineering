package controller.installation;

import gui.preview.PanelPreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SysReqBackListener implements ActionListener {

	private JFrame parent;
	private PanelPreview parentPreview;

	public SysReqBackListener(JFrame parent, PanelPreview parentPreview) {
		super();
		this.parent = parent;
		this.parentPreview = parentPreview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//gasi SysReqFrame i pali prethodne panele za instalaciju
		parent.setVisible(false);
		parentPreview.setVisible(true);
	}

}
