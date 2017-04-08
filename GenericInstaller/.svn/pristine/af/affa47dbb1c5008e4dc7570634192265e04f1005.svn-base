package controller.parameters.listeners.action;

import gui.parameters.dialogs.ParameterDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ParameterDialogListener implements ActionListener{
	private JFrame parent;
	
	public ParameterDialogListener(JFrame parent){
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ParameterDialog param = new ParameterDialog(parent);
		param.setVisible(true);		
		
	}

}
