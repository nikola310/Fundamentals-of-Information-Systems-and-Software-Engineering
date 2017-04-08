package controller.listeners.window;

import gui.editor.Editor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import user.Main;
import controller.serialization.LanguageChosen;

public class WindowListenerExit implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		LanguageChosen langChosen = new LanguageChosen();
		langChosen.save(Main.LANGUAGE);
		JFrame frame = (JFrame) arg0.getComponent();
		int choice = JOptionPane.showConfirmDialog(frame, Editor.getInstance().getResourceBundle().getString("sure"), Editor.getInstance().getResourceBundle().getString("exitInstaller"), JOptionPane.YES_NO_OPTION);
		if(choice!=JOptionPane.YES_OPTION){
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}else{	
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
