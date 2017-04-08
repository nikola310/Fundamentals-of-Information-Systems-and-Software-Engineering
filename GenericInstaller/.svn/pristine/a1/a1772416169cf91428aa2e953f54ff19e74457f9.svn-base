package gui.tree.view;

import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.tree.PanelModel;
import model.tree.ParameterModel;

@SuppressWarnings("serial")
public class WorkSpaceTreeCellRendered extends DefaultTreeCellRenderer{
	public WorkSpaceTreeCellRendered() {
		
	}
	public Component getTreeCellRendererComponent(
		JTree tree,
		Object value,
		boolean sel,
		boolean expended, 
		boolean leaf,
		int row,
		boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expended, leaf, row, hasFocus);
		
		if (value instanceof PanelModel) {
			URL imageURL = getClass().getResource("images/panel.png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		} else if (value instanceof ParameterModel) {
			
			ParameterModel parameter = (ParameterModel)value;
			String type = parameter.getType();
			
			URL imageURL = getClass().getResource("images/" + type + ".png");
			Icon icon = null;
			if (imageURL != null)
				icon = new ImageIcon(imageURL);
			setIcon(icon);
		}
		return this;
		
	}
}
