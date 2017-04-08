package model.tree;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class TreeModel extends DefaultTreeModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeModel() {
		super(new WorkSpaceTreeModel());
		// TODO Auto-generated constructor stub
	}
	
	public void addPanel(PanelModel panel, String name) {
		((WorkSpaceTreeModel)getRoot()).addPanel(panel, name);
	}

	public TreeNode getPanelModel(String title) {
		return ((WorkSpaceTreeModel)getRoot()).getPanelModel(title);
	}
	
	public void removeElement() {
		((WorkSpaceTreeModel)getRoot()).removeElement();
	}
	
	public void upElement() {
		((WorkSpaceTreeModel)getRoot()).upElement();
	}
	
	public void downElement() {
		((WorkSpaceTreeModel)getRoot()).dawnElement();
	}
	
	public void closeAll() {
		((WorkSpaceTreeModel)getRoot()).closeAll();
	}
	
}
