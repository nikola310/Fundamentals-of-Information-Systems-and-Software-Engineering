package gui.parameters.dialogs;

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
import controller.parameters.listeners.action.DialogBrowseListener;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.ImageDialogListener;

@SuppressWarnings("serial")
public class ImageDialog extends JDialog {

	private JButton ok;

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public ImageDialog(JFrame parent, JTextField name) {
		super(parent, Editor.getInstance().getResourceBundle()
				.getString("addImageParameter"), true);
		setLayout(new MigLayout());
		setSize(400, 200);
		setLocationRelativeTo(parent);

		ImageIcon icon = new ImageIcon("Images/Icons/Parameters/image.png");
		setIconImage(icon.getImage());

		JLabel img = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("imagesToAdd"));
		JTextField filePath = new JTextField(30);
		JButton browse = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Pretrazi"));
		DialogBrowseListener brListener = new DialogBrowseListener(this,
				filePath, "images");
		browse.addActionListener(brListener);

		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ok = new JButton("Ok");

		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));

		
		ImageDialogListener okL = new ImageDialogListener(this, filePath, name);
		ok.addActionListener(okL);

		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		btns.add(ok);
		btns.add(cancel);

		add(img);
		add(filePath);
		add(browse, "wrap");
		add(new JLabel(""));
		add(btns, "split 2");
	}
}
