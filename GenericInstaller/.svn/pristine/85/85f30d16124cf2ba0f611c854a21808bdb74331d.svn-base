package controller.installation;

import gui.SysReqFrame;
import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.PanelModel;
import model.tree.WorkSpaceTreeModel;

public class NextPanelListener implements ActionListener {

	private PanelPreview parent;
	private PanelModel model;
	private WorkSpaceTreeModel root;

	public PanelModel getModel() {
		return model;
	}

	public void setModel(PanelModel model) {
		this.model = model;
	}

	public NextPanelListener(PanelPreview parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		root = (WorkSpaceTreeModel) Editor.getInstance().getTree().getModel()
				.getRoot();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (root.getChildCount() != root.getIndex(model) + 1) {
			parent.deleteCenter();
			parent.drawPanel((PanelModel) root.getChildAt(root.getIndex(model) + 1));
			parent.deleteSouth();
			parent.drawSouth();
		} else {
			SysReqFrame sysReq = new SysReqFrame(parent);
			sysReq.setVisible(true);

		}

	}

}
