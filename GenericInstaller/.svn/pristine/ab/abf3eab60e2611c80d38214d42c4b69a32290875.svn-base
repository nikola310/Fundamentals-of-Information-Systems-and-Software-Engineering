package controller.serialization;

import gui.editor.Editor;
import gui.editor.tabpanel.PanelModelView;
import gui.editor.tabpanel.TabPanel;
import gui.editor.tabpanel.ViewPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.tree.PanelModel;
import model.tree.WorkSpaceTreeModel;

public class Open implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SerializationWorkSpace s = new SerializationWorkSpace();
		WorkSpaceTreeModel model = s.load();
		if (!SerializationWorkSpace.FLAG) {
			Editor.getInstance().getTree().closeAll();

			if (model != null) {
				int end = model.getChildCount();

				for (int i = 0; i < end; i++) {

					PanelModel panel = (PanelModel) model.getChildAt(i);

					Editor.getInstance().getTree()
							.addPanel(panel, panel.getName());

					@SuppressWarnings("unused")
					PanelModelView view = new PanelModelView(panel);

					ViewPanel vPanel = new ViewPanel();
					TabPanel.getInstance().getPanels().add(vPanel);
				}
			}
		}
	}

}
