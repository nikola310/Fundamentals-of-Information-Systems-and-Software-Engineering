package gui.editor.dialogs;

import java.awt.FlowLayout;

import gui.editor.Editor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;
import net.miginfocom.swing.MigLayout;
import controller.editor.listeners.FinishFrameListener;
import controller.parameters.listeners.action.DialogBrowseListener;
import controller.parameters.listeners.action.DialogCancelListener;

@SuppressWarnings("serial")
public class FinishDialog extends JDialog {

	public FinishDialog(JFrame parent) {
		setLayout(new MigLayout());
		setSize(400, 200);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(parent);
		ImageIcon icon = new ImageIcon("Images/Icons/finish.png");
		setIconImage(icon.getImage());
		JLabel description = new JLabel(Editor.getInstance()
				.getResourceBundle().getString("descFinish"));
		JTextArea txtFin = new JTextArea(10, 10);
		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();
		FinishModel fin = root.getFinish();
		txtFin.setText(fin.getDescription());
		txtFin.setLineWrap(true);
		JLabel readmeLabel = new JLabel(Editor.getInstance()
				.getResourceBundle().getString("addReadme"));
		JTextField readmePath = new JTextField(30);
		JButton readmeBrowse = new JButton(Editor.getInstance()
				.getResourceBundle().getString("Pretrazi"));
		DialogBrowseListener readmeL = new DialogBrowseListener(this,
				readmePath, "txt");
		readmeBrowse.addActionListener(readmeL);

		JLabel iconLabel = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("addIcon"));
		JTextField iconPath = new JTextField(30);
		JButton iconBrowse = new JButton(Editor.getInstance()
				.getResourceBundle().getString("Pretrazi"));
		DialogBrowseListener iconL = new DialogBrowseListener(this, iconPath,
				"images");
		iconBrowse.addActionListener(iconL);

		JButton ok = new JButton(Editor.getInstance().getResourceBundle()
				.getString("OK"));
		FinishFrameListener okL = new FinishFrameListener(this, txtFin,
				readmePath, iconPath);
		ok.addActionListener(okL);
		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));
		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		JPanel tmp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tmp.add(ok);
		tmp.add(cancel);

		add(description);
		add(txtFin, "growx, growy");
		add(new JLabel(""), "wrap");
		add(readmeLabel);
		add(readmePath);
		add(readmeBrowse, "wrap");
		add(iconLabel);
		add(iconPath);
		add(iconBrowse, "wrap");
		add(new JLabel(""));
		add(tmp);

	}

}
