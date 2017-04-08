package controller.tree.actions;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class OpenWorkSpaceAction extends AbstractTreeAction{
	public OpenWorkSpaceAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("Images/Icons/open.png"));
		putValue(NAME, Editor.getInstance().getResourceBundle().getString("btnOtvori"));
		putValue(SHORT_DESCRIPTION, Editor.getInstance().getResourceBundle().getString("btnOtvori"));
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
