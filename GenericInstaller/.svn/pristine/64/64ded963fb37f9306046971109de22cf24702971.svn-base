package gui.editor;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import controller.editor.listeners.AddToPackageListener;
import controller.editor.listeners.DeleteElement;
import controller.editor.listeners.DownElement;
import controller.editor.listeners.FinishDialogAction;
import controller.editor.listeners.FrameEditAction;
import controller.editor.listeners.MouseListenerToolBar;
import controller.editor.listeners.UpElement;
import controller.parameters.listeners.action.PanelDialogListener;
import controller.parameters.listeners.action.ParameterDialogListener;
import controller.serialization.Open;
import controller.serialization.Save;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	private JButton addPanel;
	private JButton save;
	private JButton open;
	private JButton parameters;
	private JButton delete;
	private JButton up;
	private JButton down;
	private JButton frame;
	private JButton finalFrame;
	private JButton addToPackage;
	private ResourceBundle resourceBundle;

	public ToolBar(final JFrame parent) {
		super(JToolBar.HORIZONTAL);
		setFloatable(false);
		resourceBundle = ResourceBundle.getBundle(
				"model.MessageResources.MessageResources", Locale.getDefault());

		addPanel = new JButton();
		addPanel.setIcon(new ImageIcon("Images/Icons/add_panel.png"));

		MouseListenerToolBar addPanelL = new MouseListenerToolBar(addPanel);
		addPanel.addMouseListener(addPanelL);
		PanelDialogListener addPanelA = new PanelDialogListener(parent);
		addPanel.addActionListener(addPanelA);

		save = new JButton();
		save.setIcon(new ImageIcon("Images/Icons/save.png"));

		MouseListenerToolBar saveL = new MouseListenerToolBar(save);
		save.addMouseListener(saveL);
		Save saveS = new Save();
		save.addActionListener(saveS);

		open = new JButton();
		open.setIcon(new ImageIcon("Images/Icons/open.png"));

		MouseListenerToolBar openL = new MouseListenerToolBar(open);
		open.addMouseListener(openL);
		
		Open openO = new Open();
		open.addActionListener(openO);

		parameters = new JButton();
		parameters.setIcon(new ImageIcon("Images/Icons/parameter.png"));

		MouseListenerToolBar parametersL = new MouseListenerToolBar(parameters);
		parameters.addMouseListener(parametersL);
		ParameterDialogListener addParam = new ParameterDialogListener(parent);
		parameters.addActionListener(addParam);

		delete = new JButton();
		delete.setIcon(new ImageIcon("Images/Icons/delete.png"));

		MouseListenerToolBar deleteL = new MouseListenerToolBar(delete);
		delete.addMouseListener(deleteL);
		DeleteElement deleteLE = new DeleteElement();
		delete.addActionListener(deleteLE);


		up = new JButton();
		up.setIcon(new ImageIcon("Images/Icons/up.png"));

		MouseListenerToolBar upL = new MouseListenerToolBar(up);
		up.addMouseListener(upL);

		UpElement upE = new UpElement();
		up.addActionListener(upE);

		down = new JButton();
		down.setIcon(new ImageIcon("Images/Icons/dawn.png"));

		MouseListenerToolBar dawnL = new MouseListenerToolBar(down);
		down.addMouseListener(dawnL);

		DownElement dawnE = new DownElement();
		down.addActionListener(dawnE);

		frame = new JButton();
		frame.setIcon(new ImageIcon("Images/Icons/edit_panel.png"));

		MouseListenerToolBar frameL = new MouseListenerToolBar(frame);
		frame.addMouseListener(frameL);
		FrameEditAction frameEL = new FrameEditAction(parent);
		frame.addActionListener(frameEL);

		finalFrame = new JButton();
		finalFrame.setIcon(new ImageIcon("Images/Icons/finish.png"));
		MouseListenerToolBar finalL = new MouseListenerToolBar(finalFrame);
		FinishDialogAction finalDL = new FinishDialogAction(parent);
		finalFrame.addMouseListener(finalL);
		finalFrame.addActionListener(finalDL);

		addToPackage = new JButton();
		addToPackage.setIcon(new ImageIcon("Images/Icons/package.png"));
		MouseListenerToolBar packageL = new MouseListenerToolBar(addToPackage);
		AddToPackageListener packageDL = new AddToPackageListener(parent);
		addToPackage.addMouseListener(packageL);
		addToPackage.addActionListener(packageDL);

		addPanel.setToolTipText(resourceBundle.getString("btnNoviPanel"));
		save.setToolTipText(resourceBundle.getString("btnSnimi"));
		open.setToolTipText(resourceBundle.getString("btnOtvori"));
		parameters.setToolTipText(resourceBundle.getString("btnNoviParametar"));
		delete.setToolTipText(resourceBundle.getString("btnObrisi"));
		up.setToolTipText(resourceBundle.getString("btnPomeriGore"));
		down.setToolTipText(resourceBundle.getString("btnPomeriDole"));
		frame.setToolTipText(resourceBundle.getString("EditFrame"));
		finalFrame.setToolTipText(resourceBundle.getString("FinalFrame"));
		addToPackage.setToolTipText(resourceBundle.getString("Package"));
		addSeparator();
		add(addPanel);
		addSeparator();
		add(parameters);
		addSeparator();
		add(frame);
		addSeparator();
		add(finalFrame);
		addSeparator();
		add(save);
		addSeparator();
		add(open);
		addSeparator();
		add(delete);
		addSeparator();
		add(up);
		addSeparator();
		add(down);
		addSeparator();
		add(addToPackage);
	}

	public void initComponents() {
		addPanel.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnNoviPanel"));
		save.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnSnimi"));
		open.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnOtvori"));
		parameters.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnNoviParametar"));
		delete.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnObrisi"));
		up.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnPomeriGore"));
		down.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("btnPomeriDole"));
		frame.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("EditFrame"));
		finalFrame.setToolTipText(Editor.getInstance().getResourceBundle()
				.getString("FinalFrame"));
		addToPackage.setToolTipText(Editor.getInstance().getResourceBundle().getString("Package"));
	}

	public JButton getAddPanel() {
		return addPanel;
	}

	public void setAddPanel(JButton addPanel) {
		this.addPanel = addPanel;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getOpen() {
		return open;
	}

	public void setOpen(JButton open) {
		this.open = open;
	}

	public JButton getParameters() {
		return parameters;
	}

	public void setParameters(JButton parameters) {
		this.parameters = parameters;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}


	public JButton getUp() {
		return up;
	}

	public void setUp(JButton up) {
		this.up = up;
	}

	public JButton getDawn() {
		return down;
	}

	public void setDawn(JButton dawn) {
		this.down = dawn;
	}

}
