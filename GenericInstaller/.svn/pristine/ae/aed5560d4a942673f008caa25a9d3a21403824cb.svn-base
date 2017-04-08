package controller.tree;

import gui.editor.Editor;
import gui.editor.tabpanel.TabPanel;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import model.tree.PanelModel;
import model.tree.ParameterModel;

public class WorkSpaceTreeController implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {

		if (Editor.getInstance().getTree().getLastSelectedPathComponent() instanceof PanelModel) {
			PanelModel model = (PanelModel) Editor.getInstance().getTree()
					.getLastSelectedPathComponent();

			int count = TabPanel.getInstance().getTabCount();
			for (int i = 0; i < count; i++) {
				String title = TabPanel.getInstance().getTitleAt(i);
				if (title.equals(model.getName())) {
					TabPanel.getInstance().setSelectedIndex(i);
					break;
				}
			}

			model.setSelected();

		} else if (Editor.getInstance().getTree()
				.getLastSelectedPathComponent() instanceof ParameterModel) {

			ParameterModel model = (ParameterModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent();
			PanelModel pom = (PanelModel) model.getParent();

			int count = TabPanel.getInstance().getTabCount();
			for (int i = 0; i < count; i++) {
				String title = TabPanel.getInstance().getTitleAt(i);
				if (title.equals(pom.getName())) {
					TabPanel.getInstance().setSelectedIndex(i);
				}
			}
		}

	}

}
