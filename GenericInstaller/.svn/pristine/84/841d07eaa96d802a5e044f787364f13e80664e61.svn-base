package model.tree;

import gui.editor.Editor;
import gui.editor.tabpanel.TabPanel;
import gui.editor.tabpanel.ViewPanel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

public class WorkSpaceTreeModel implements TreeNode, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PanelModel> panels = new ArrayList<PanelModel>();
	private FinishModel finish = new FinishModel();
	
	public WorkSpaceTreeModel() {
		super();
		//finish = new FinishModel();
	}

	public FinishModel getFinish() {
		return finish;
	}

	public void setFinish(FinishModel finish) {
		this.finish = finish;
	}

	public String toString() {
		return "Workspace";
	}

	public void addPanel(PanelModel panel, String name) {
		panels.add(panel);
		panel.setName(name);
	}

	public PanelModel getPanel(int index) {
		return panels.get(index);
	}

	public int getPanelIndex(PanelModel panel) {
		return panels.indexOf(panel);
	}

	public int getPanelCount() {
		return panels.size();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration<PanelModel>) panels;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return getPanel(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getPanelCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return getPanelIndex((PanelModel) node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public TreeNode getPanelModel(String title) {
		for (Iterator<PanelModel> i = panels.iterator(); i.hasNext();) {
			PanelModel ret = i.next();
			String s = ret.getName();

			if (s == title) {
				int index = this.getPanelIndex(ret);
				TreeNode node = this.getChildAt(index);
				ret.setSelected();
				return node;
			}
		}

		return null;
	}

	public void removeElement() {

		if (Editor.getInstance().getTree().getLastSelectedPathComponent() instanceof PanelModel) {
			PanelModel pom = null;
			PanelModel model = (PanelModel) Editor.getInstance().getTree()
					.getLastSelectedPathComponent();
			int br = -1;
			if (model != null && !panels.isEmpty()) {
				for (Iterator<PanelModel> i = panels.iterator(); i.hasNext();) {
					br++;
					pom = i.next();
					if (pom == model) {
						TabPanel.getInstance().removeTab(pom.getName());
						i.remove();
						TabPanel.getInstance().getPanels().remove(br);
					}
				}
			}

		} else if (Editor.getInstance().getTree()
				.getLastSelectedPathComponent() instanceof ParameterModel) {
			ParameterModel pom = (ParameterModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent();
			PanelModel parent = (PanelModel) pom.getParent();
			parent.removeElement();
		}
	}

	public void upElement() {

		if (Editor.getInstance().getTree().getLastSelectedPathComponent() instanceof PanelModel) {
			PanelModel copy = null;
			PanelModel model = (PanelModel) Editor.getInstance().getTree()
					.getLastSelectedPathComponent();

			if (model != null && !panels.isEmpty()) {
				PanelModel pom = null;
				for (Iterator<PanelModel> i = panels.iterator(); i.hasNext();) {
					pom = i.next();
					if (pom == model) {
						if (pom != panels.get(0)) {
							int index = panels.indexOf(pom);
							copy = panels.get(index - 1);

							ViewPanel panel1 = TabPanel.getInstance()
									.getPanels().get(index);
							ViewPanel panel2 = TabPanel.getInstance()
									.getPanels().get(index - 1);

							TabPanel.getInstance().getPanels().set(index, panel2);
							TabPanel.getInstance().getPanels().set(index-1, panel1);
							
							panels.set(index, copy);
							panels.set(index - 1, pom);
						}

					}

				}
			}
		} else if (Editor.getInstance().getTree()
				.getLastSelectedPathComponent() instanceof ParameterModel) {
			ParameterModel pom = (ParameterModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent();
			TreeNode node = pom.getParent();
			PanelModel parent = (PanelModel) node;
			parent.upElement();
		}
	}

	public void dawnElement() {

		if (Editor.getInstance().getTree().getLastSelectedPathComponent() instanceof PanelModel) {
			PanelModel copy = null;
			PanelModel model = (PanelModel) Editor.getInstance().getTree()
					.getLastSelectedPathComponent();

			if (model != null && !panels.isEmpty()) {
				PanelModel pom = null;
				for (Iterator<PanelModel> i = panels.iterator(); i.hasNext();) {
					pom = i.next();
					if (pom == model) {
						if (pom != panels.get(panels.size() - 1)) {
							int index = panels.indexOf(pom);
							copy = panels.get(index + 1);

							ViewPanel panel1 = TabPanel.getInstance()
									.getPanels().get(index);
							ViewPanel panel2 = TabPanel.getInstance()
									.getPanels().get(index + 1);

							TabPanel.getInstance().getPanels().set(index, panel2);
							TabPanel.getInstance().getPanels().set(index+1, panel1);
							
							panels.set(index, copy);
							panels.set(index + 1, pom);
							break;
						}

					}

				}
			}
		} else if (Editor.getInstance().getTree()
				.getLastSelectedPathComponent() instanceof ParameterModel) {
			ParameterModel pom = (ParameterModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent();
			TreeNode node = pom.getParent();
			PanelModel parent = (PanelModel) node;
			parent.downElement();
		}

	}

	public void closeAll() {
		panels.clear();
		for (int i = 0; i < panels.size(); i++) {
			TabPanel.getInstance().getPanels().remove(i);
		}
		TabPanel.getInstance().removeAll();

	}
}
