package gui.editor.dialogs;

import gui.editor.Editor;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import controller.editor.listeners.CreateInstallationListener;
import controller.parameters.listeners.action.DialogBrowseListener;
import controller.parameters.listeners.action.DialogCancelListener;

@SuppressWarnings("serial")
public class AddToPackageDialog extends JDialog {

	public AddToPackageDialog(JFrame parent) {
		super(parent, Editor.getInstance().getResourceBundle().getString("InstallationPackage"), true);
		setLayout(new MigLayout());
		setLocationRelativeTo(parent);
		setSize(410, 160);
		ImageIcon icon = new ImageIcon("Images/Icons/package.png");
		setIconImage(icon.getImage());
		JLabel label = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("add2Package"));
		JTextField txt = new JTextField(30);
		JButton browse = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Pretrazi"));
		DialogBrowseListener browseL = new DialogBrowseListener(this, txt, "directories");
		browse.addActionListener(browseL);
		
		JLabel exeLabel = new JLabel(Editor.getInstance().getResourceBundle().getString("exeLabel"));
		JTextField exeTxt = new JTextField(30);
		JButton browseExe = new JButton(Editor.getInstance().getResourceBundle().getString("Pretrazi"));
		DialogBrowseListener browseExeL = new DialogBrowseListener(this, exeTxt, "exe");
		browseExe.addActionListener(browseExeL);
		
		JLabel whereToSave = new JLabel(Editor.getInstance().getResourceBundle().getString("ChooseWhereSave"));
		JTextField whereTxt = new JTextField(30);
		JButton browseWhere = new JButton(Editor.getInstance().getResourceBundle().getString("Pretrazi"));
		DialogBrowseListener browseWhereL = new DialogBrowseListener(this, whereTxt, "directories");
		browseWhere.addActionListener(browseWhereL);
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton ok = new JButton(Editor.getInstance().getResourceBundle()
				.getString("OK"));
		CreateInstallationListener okL = new CreateInstallationListener(txt, this, whereTxt, exeTxt);
		ok.addActionListener(okL);
		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));
		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		
		south.add(ok);
		south.add(cancel);
		
		add(label);
		add(txt);
		add(browse, "wrap");
		add(whereToSave);
		add(whereTxt);
		add(browseWhere, "wrap");
		add(exeLabel);
		add(exeTxt);
		add(browseExe, "wrap");
		add(new JLabel(""));
		add(south);
	}

}
