package controller.tree.actions;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AbstractTreeAction extends AbstractAction{

	public Icon loadIcon(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = null;
		
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resouce not found: " + fileName);
		}
		
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
