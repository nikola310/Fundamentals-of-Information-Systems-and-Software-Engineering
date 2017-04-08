package gui.editor;

import gui.editor.tabpanel.TabPanel;
import gui.preview.PanelPreview;
import gui.tree.Tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.tree.TreeModel;
import controller.listeners.window.WindowListenerExit;

@SuppressWarnings("serial")
public class Editor extends JFrame {
	private static Editor instance = null;
	private ResourceBundle resourceBundle;
	private PanelPreview preview;

	public PanelPreview getPreview() {
		return preview;
	}

	public void setPreview(PanelPreview preview) {
		this.preview = preview;
	}

	public Editor() {

		initialiseWorkSpaceTree();
		initialise();
		resourceBundle = ResourceBundle.getBundle(
				"model.MessageResources.MessageResources", Locale.getDefault());
	}

	private StatusBar statusBar;
	private ToolBar toolBar;
	private EditorMenuBar menuBar;

	private Tree tree;
	private TreeModel treeModel;

	public EditorMenuBar getEditorMenuBar() {
		return menuBar;
	}

	public void setEditorMenuBar(EditorMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public TreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(TreeModel treeModel) {
		this.treeModel = treeModel;
	}

	private void initialiseWorkSpaceTree() {
		treeModel = new TreeModel();
		tree = new Tree();
		tree.setModel(treeModel);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialise() {
		setSize(1100, 700);
		setTitle("GenericInstaller");
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("Images/Icon.jpg");
		setIconImage(icon.getImage());

		toolBar = new ToolBar(this);
		menuBar = new EditorMenuBar(this);
		this.setJMenuBar(menuBar);
		add(toolBar, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setMaximumSize(new Dimension(400, 400));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				scrollPane, TabPanel.getInstance());
		splitPane.setDividerLocation(230);
		add(splitPane, BorderLayout.CENTER);

		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);

		addWindowListener(new WindowListenerExit());

	}

	public static Editor getInstance() {
		if (instance == null) {
			instance = new Editor();
		}
		return instance;
	}

	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle(
				"model.MessageResources.MessageResources", Locale.getDefault());

		setTitle(resourceBundle.getString("naslovAplikacije"));
		menuBar.initComponents();
		toolBar.initComponents();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}


	public StatusBar getStatusBar() {
		return statusBar;
	}

	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(ToolBar toolBar) {
		this.toolBar = toolBar;
	}

}
