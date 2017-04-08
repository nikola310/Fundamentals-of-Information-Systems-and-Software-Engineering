package gui.tree;

import gui.tree.view.WorkSpaceTreeCellRendered;
import gui.tree.view.WorkSpaceTreeEditor;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;

import model.tree.PanelModel;
import model.tree.TreeModel;
import controller.tree.WorkSpaceTreeController;

@SuppressWarnings("serial")
public class Tree extends JTree{
	public Tree() {
		addTreeSelectionListener(new WorkSpaceTreeController());
		setCellEditor(new WorkSpaceTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new WorkSpaceTreeCellRendered());
		setEditable(true);
	}
	
	public void addPanel(PanelModel panel, String name) {
		((TreeModel)getModel()).addPanel(panel, name);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public TreeNode getPanelModel(String title) {
			
		return ((TreeModel)getModel()).getPanelModel(title);
	}
	
	public void removeElement() {
		((TreeModel)getModel()).removeElement();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void upElement() {
		((TreeModel)getModel()).upElement();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void downElement() {
		((TreeModel)getModel()).downElement();
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void closeAll() {
		((TreeModel)getModel()).closeAll();
		SwingUtilities.updateComponentTreeUI(this);
	}
}
