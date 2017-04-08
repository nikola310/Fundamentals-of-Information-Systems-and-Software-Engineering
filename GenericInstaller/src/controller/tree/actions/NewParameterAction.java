package controller.tree.actions;

import gui.editor.Editor;
import gui.editor.tabpanel.PanelModelView;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.tree.PanelModel;
import model.tree.ParameterModel;

public class NewParameterAction {

	public NewParameterAction(String name, String type, Object obj) {

		Object panel = Editor.getInstance().getTree()
				.getLastSelectedPathComponent();
		if (panel instanceof PanelModel) {

			PanelModel panelModel = (PanelModel) panel;

			boolean find = false;
			if (panelModel.getChildCount() != -1) {
				for (int i = 0; i < panelModel.getChildCount(); i++) {
					ParameterModel parameterModel = (ParameterModel) panelModel
							.getChildAt(i);
					if (parameterModel.getName().equals(name)) {
						find = true;
						break;
					}
				}
			}
			if (!find) {
				@SuppressWarnings("unused")
				PanelModelView view = new PanelModelView((PanelModel) panel);

				ParameterModel parameter = new ParameterModel(name, type, obj,
						(PanelModel) panel);
				((PanelModel) panel).addParameter(parameter);
				SwingUtilities.updateComponentTreeUI(Editor.getInstance()
						.getTree());
			} else {
				JOptionPane.showMessageDialog(Editor.getInstance(),
						"Name already existing!");
			}
			
		} else {
			JOptionPane.showMessageDialog(Editor.getInstance(),
					"Please select panel!");
		}
	}

}