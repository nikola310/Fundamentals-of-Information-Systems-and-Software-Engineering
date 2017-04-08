package gui.editor.tabpanel;

import gui.editor.Editor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.tree.PanelModel;
import model.tree.ParameterModel;
import model.tree.WorkSpaceTreeModel;

@SuppressWarnings("serial")
public class TabPanel extends JTabbedPane {
	private String name;
	private static TabPanel instance = null;
	private Component c = null;
	private ViewPanel panelView;
	private TreeNode node;
	private ArrayList<ViewPanel> panels;

	private TabPanel() {
		super();
		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.setBackground(Color.white);
		this.setVisible(true);

		panels = new ArrayList<ViewPanel>();

		addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub

				Component comp = getSelectedComponent();
				int i = indexOfComponent(comp);

				if (i != -1) {
					String pom = getTitleAt(i);
					TreeNode node = Editor.getInstance().getTree()
							.getPanelModel(pom);

					setNode(node);

					if (node != null) {
						TreePath path = new TreePath(node);
						Editor.getInstance().getTree().setSelectionPath(path);
					}
				}
			}
		});
	}

	public static TabPanel getInstance() {
		if (instance == null) {
			instance = new TabPanel();
		}
		return instance;
	}

	public void addTabbedPanel(String name) {

		int index = this.getTabCount();

		PanelModel model = (PanelModel) Editor.getInstance().getTree()
				.getLastSelectedPathComponent();
		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();
		int indexModel = root.getIndex(model);

		ViewPanel panel = new ViewPanel();
		panel.addPanel(model);
		panels.set(indexModel, panel);

		this.panelView = panel;
		JButton close = new TabButton(this);

		JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		tabPanel.setBackground(new Color(0, 255, 0, 0));

		URL imageURL = getClass().getResource("images/panel.png");
		ImageIcon icon = new ImageIcon(imageURL);
		JLabel label = new JLabel(name + " ");
		label.setIcon(icon);

		tabPanel.add(label);
		tabPanel.add(close);

		ScrollPane scroll = new ScrollPane();
		scroll.setBackground(Color.white);
		scroll.add(panel);

		this.addTab(name, scroll);
		this.setTabComponentAt(index, tabPanel);
		c = this.getComponentAt(index);
		((TabButton) close).setC(c);
		setToolTipTextAt(index, "Panel: " + name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setC(final Component c) {
		this.c = c;
	}

	public Component getC(String name) {
		if (this.name == name) {
			return this.c;
		} else
			return null;
	}

	public static void setInstance(TabPanel instance) {
		TabPanel.instance = instance;
	}

	private class TabButton extends JButton implements MouseListener {
		private JTabbedPane pane;
		private Component c;

		public void setC(final Component c) {
			this.c = c;
		}

		public TabButton(JTabbedPane pane) {
			this.pane = pane;

			setToolTipText(Editor.getInstance().getResourceBundle()
					.getString("plsParam"));
			URL imageURL = getClass().getResource("images/close.png");
			setIcon(new ImageIcon(imageURL));
			setPreferredSize(new Dimension(10, 10));
			setContentAreaFilled(false);
			setFocusable(false);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int i = pane.indexOfComponent(c);
			if (i != -1)
				pane.remove(i);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	public void addPanel(ParameterModel parameter) {

		PanelModel parent = (PanelModel) parameter.getParent();
		String parentName = parent.getName();
		int index = 0;
		int count = getTabCount();
		if (count != -1) {
			for (int i = 0; i < count; i++) {
				String title = getTitleAt(i);
				if (parentName == title) {

					WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor
							.getInstance().getTree().getModel().getRoot();
					int indexModel = root.getIndex(parent);
					this.panelView = panels.get(indexModel);
					index = indexModel;
					break;
				}
			}
			this.panelView.addParameter(parameter);
			panels.set(index, panelView);
			this.panelView.revalidate();
			this.panelView.repaint();
		}

	}

	public TreeNode getNode() {
		return node;
	}

	public void setNode(TreeNode node) {
		this.node = node;
	}

	public void removeTab(String title) {
		int index = indexOfTab(title);
		if (index != -1)
			remove(index);
	}

	public ViewPanel getPanelView() {
		return panelView;
	}

	public void setPanelView(ViewPanel panelView) {
		this.panelView = panelView;
	}

	public ArrayList<ViewPanel> getPanels() {
		return panels;
	}

	public void setPanels(ArrayList<ViewPanel> panels) {
		this.panels = panels;
	}

}
