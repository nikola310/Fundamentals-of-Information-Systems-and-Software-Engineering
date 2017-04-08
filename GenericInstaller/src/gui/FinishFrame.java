package gui;

import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;
import net.miginfocom.swing.MigLayout;
import controller.installation.FinishInstallationListener;

@SuppressWarnings("serial")
public class FinishFrame extends JFrame {

	public FinishFrame(String installDir) {
		super();
		setSize(new Dimension(450, 150));
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();
		FinishModel fin = root.getFinish();
		PanelPreview.setNewIcon(this);
		JCheckBox box1 = new JCheckBox(Editor.getInstance().getResourceBundle().getString("OpenReadme"));
		JCheckBox box2 = new JCheckBox(Editor.getInstance().getResourceBundle().getString("CreateShortcut"));
		JLabel text = new JLabel(fin.getDescription());
		text.setVisible(true);

		JPanel center = new JPanel(new MigLayout());
		center.add(text, "wrap");
		center.add(box1, "wrap");
		center.add(box2, "wrap");

		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(400, 30));
		south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton finish = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Finish"));
		FinishInstallationListener finL = new FinishInstallationListener(
				installDir, box1, box2);
		finish.addActionListener(finL);
		south.add(finish);

		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);

		setVisible(true);
	}

}