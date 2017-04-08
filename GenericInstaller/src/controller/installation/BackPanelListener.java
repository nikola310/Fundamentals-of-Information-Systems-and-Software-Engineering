package controller.installation;

import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.PanelModel;
import model.tree.WorkSpaceTreeModel;

public class BackPanelListener implements ActionListener {

	private PanelPreview parent;
	private PanelModel model;
	private WorkSpaceTreeModel root;

	public PanelModel getModel() {
		return model;
	}

	public void setModel(PanelModel model) {
		this.model = model;
	}

	public BackPanelListener(PanelPreview parent) {
		this.parent = parent;
		root = (WorkSpaceTreeModel) Editor.getInstance().getTree().getModel()
				.getRoot();
		root.getIndex(model);
	}

	public void actionPerformed(ActionEvent e) {
		parent.deleteCenter();
		parent.drawPanel((PanelModel) root.getChildAt(root.getIndex(model) - 1));
		if (root.getIndex(model) == 0) {
			parent.deleteSouth();
			parent.drawFirstSouth();
		}
	}

}
