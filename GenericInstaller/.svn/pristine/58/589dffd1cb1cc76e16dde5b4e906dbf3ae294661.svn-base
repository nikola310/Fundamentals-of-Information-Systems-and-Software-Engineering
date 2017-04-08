package controller.tree.actions;

import gui.editor.Editor;
import gui.editor.tabpanel.PanelModelView;
import gui.editor.tabpanel.TabPanel;
import gui.editor.tabpanel.ViewPanel;

import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.tree.PanelModel;
import model.tree.WorkSpaceTreeModel;

@SuppressWarnings("serial")
public class NewPanelAction extends AbstractTreeAction {
	private JTextField name;
	private JDialog dialog;

	public NewPanelAction(JTextField name, JDialog dialog) {
		this.name = name;
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent arg0) {

		int length = name.getText().length();

		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();

		boolean find = false;
		if (root.getChildCount() != -1) {
			for (int i = 0; i < root.getChildCount(); i++) {
				PanelModel panelModel = (PanelModel) root.getChildAt(i);
				if (panelModel.getName().equals(name.getText())) {
					find = true;
					break;
				}
			}
		}

		if (length != 0 && find == false) {
			PanelModel panel = new PanelModel(name.getText());
			dialog.setVisible(false);
			Editor.getInstance().getTree().addPanel(panel, name.getText());

			@SuppressWarnings("unused")
			PanelModelView view = new PanelModelView(panel);

			ViewPanel vPanel = new ViewPanel();
			TabPanel.getInstance().getPanels().add(vPanel);

		} else if (find) {

			JOptionPane.showMessageDialog(dialog, "Name already existing!");

		} else {

			JOptionPane.showMessageDialog(dialog, Editor.getInstance()
					.getResourceBundle().getString("plsText"));
		}
	}
}
