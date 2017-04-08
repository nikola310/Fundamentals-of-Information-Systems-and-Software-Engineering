package controller.serialization;

import gui.editor.Editor;
import gui.editor.tabpanel.PanelModelView;
import gui.editor.tabpanel.TabPanel;
import gui.editor.tabpanel.ViewPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.tree.PanelModel;
import model.tree.WorkSpaceTreeModel;

public class SaveWorkspace {
	public void save(WorkSpaceTreeModel model) {

		try {
			FileOutputStream fileOut = new FileOutputStream(
					"Files\\workspace.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(model);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		WorkSpaceTreeModel model = null;
		try {
			FileInputStream fileIn = new FileInputStream("Files"
					+ File.separatorChar + "workspace.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			model = (WorkSpaceTreeModel) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();

		} catch (ClassNotFoundException c) {
			c.printStackTrace();

		}

		Editor.getInstance().getTree().closeAll();

		if (model != null) {
			int end = model.getChildCount();

			for (int i = 0; i < end; i++) {

				PanelModel panel = (PanelModel) model.getChildAt(i);

				Editor.getInstance().getTree().addPanel(panel, panel.getName());

				@SuppressWarnings("unused")
				PanelModelView view = new PanelModelView(panel);

				ViewPanel vPanel = new ViewPanel();
				TabPanel.getInstance().getPanels().add(vPanel);
			}
		}
	}

}
