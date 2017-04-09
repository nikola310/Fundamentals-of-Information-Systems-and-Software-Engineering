package model.tree;

import gui.editor.Editor;
import gui.editor.tabpanel.TabPanel;
import gui.editor.tabpanel.ViewPanel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.tree.TreeNode;

public class PanelModel extends Observable implements TreeNode, Serializable {


	/*
	 * Model panela koji sadrzi listu parametara, naziv, naslov, inicijalnu
	 * velicinu panela inicijalno se ne moze menjati velicina
	 * Test za GitHub
	 */
	private static final long serialVersionUID = 1L;
	public static String SELECTION = "Selection";
	public static String PARAMETARADD = "Parametar add";
	public static int INITWIDTH = 800;
	public static int INITHEIGHT = 400;
	private ArrayList<ParameterModel> parameters = new ArrayList<ParameterModel>();
	private ImageIcon icon = new ImageIcon("Images/Icon.jpg");
	private String state = SELECTION;
	private String name;
	private String title;
	private int width = PanelModel.INITWIDTH;
	private int height = PanelModel.INITHEIGHT;
	private boolean resizable = false;

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isResizable() {
		return resizable;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public PanelModel(String name) {
		this.name = name;
		this.title = name;
	}

	public String toString() {
		return name;
	}

	public ParameterModel getParameter(int index) {
		return parameters.get(index);
	}

	public int getParameterIndex(ParameterModel parameter) {
		return parameters.indexOf(parameter);
	}

	public int getParameterCount() {
		return parameters.size();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) parameters;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return getParameter(arg0);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return getParameterCount();
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return getParameterIndex((ParameterModel) arg0);
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

	public void addParameter(ParameterModel parametar) {
		this.parameters.add(parametar);
		this.state = PanelModel.PARAMETARADD;
		setChanged();
		notifyObservers(parametar);
	}

	public void setSelected() {
		this.state = PanelModel.SELECTION;
		setChanged();
		notifyObservers();
	}

	public ArrayList<ParameterModel> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<ParameterModel> parameters) {
		this.parameters = parameters;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void removeElement() {
		if (Editor.getInstance().getTree().getLastSelectedPathComponent() instanceof ParameterModel) {

			ParameterModel pom = null;
			ParameterModel model = (ParameterModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent();
			ViewPanel.STATE = true;

			if (model != null && !parameters.isEmpty()) {
				for (Iterator<ParameterModel> i = parameters.iterator(); i
						.hasNext();) {
					pom = i.next();
					if (pom == model) {
						TabPanel.getInstance().removeTab(pom.getName());
						i.remove();

						WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor
								.getInstance().getTree().getModel().getRoot();

						int position = root.getIndex(this);

						ViewPanel pomView = new ViewPanel();
						pomView.addPanel(this);
						TabPanel.getInstance().getPanels().get(position)
								.removeAll();
						TabPanel.getInstance().getPanels().get(position)
								.addPanel(this);
						TabPanel.getInstance().getPanels().get(position)
								.revalidate();
						TabPanel.getInstance().getPanels().get(position)
								.repaint();

						ViewPanel lastView = TabPanel.getInstance().getPanels()
								.get(position);

						TabPanel.getInstance().setPanelView(lastView);
						TabPanel.getInstance().getPanelView().revalidate();
						TabPanel.getInstance().getPanelView().repaint();
						break;
					}
				}
			}
		}
	}

	public void upElement() {
		ParameterModel pom = null;
		ParameterModel copy = null;
		ParameterModel model = (ParameterModel) Editor.getInstance().getTree()
				.getLastSelectedPathComponent();

		ViewPanel.STATE = true;
		if (model != null && !parameters.isEmpty()) {
			for (Iterator<ParameterModel> i = parameters.iterator(); i
					.hasNext();) {
				pom = i.next();
				if (pom == model) {
					if (pom != parameters.get(0)) {
						int index = parameters.indexOf(pom);
						copy = parameters.get(index - 1);

						parameters.set(index, copy);
						parameters.set(index - 1, pom);
						break;
					}

				}

			}
			WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
					.getTree().getModel().getRoot();

			int position = root.getIndex(this);

			ViewPanel pomView = new ViewPanel();
			pomView.addPanel(this);
			TabPanel.getInstance().getPanels().get(position).removeAll();
			TabPanel.getInstance().getPanels().get(position).addPanel(this);
			TabPanel.getInstance().getPanels().get(position).revalidate();
			TabPanel.getInstance().getPanels().get(position).repaint();

			ViewPanel lastView = TabPanel.getInstance().getPanels()
					.get(position);

			TabPanel.getInstance().setPanelView(lastView);
			TabPanel.getInstance().getPanelView().revalidate();
			TabPanel.getInstance().getPanelView().repaint();
		}
	}

	public void downElement() {
		ParameterModel pom = null;
		ParameterModel copy = null;
		ParameterModel model = (ParameterModel) Editor.getInstance().getTree()
				.getLastSelectedPathComponent();
		ViewPanel.STATE = true;
		if (model != null && !parameters.isEmpty()) {
			for (Iterator<ParameterModel> i = parameters.iterator(); i
					.hasNext();) {
				pom = i.next();
				if (pom == model) {
					if (pom != parameters.get(parameters.size() - 1)) {
						int index = parameters.indexOf(pom);
						copy = parameters.get(index + 1);

						parameters.set(index, copy);
						parameters.set(index + 1, pom);

						break;
					}

				}

			}

			WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
					.getTree().getModel().getRoot();

			int position = root.getIndex(this);

			ViewPanel pomView = new ViewPanel();
			pomView.addPanel(this);
			TabPanel.getInstance().getPanels().get(position).removeAll();
			TabPanel.getInstance().getPanels().get(position).addPanel(this);
			TabPanel.getInstance().getPanels().get(position).revalidate();
			TabPanel.getInstance().getPanels().get(position).repaint();

			ViewPanel lastView = TabPanel.getInstance().getPanels()
					.get(position);

			TabPanel.getInstance().setPanelView(lastView);
			TabPanel.getInstance().getPanelView().revalidate();
			TabPanel.getInstance().getPanelView().repaint();

		}

	}

}
