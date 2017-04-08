package gui.parameters.dialogs;

import gui.editor.Editor;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.LabelDialogListener;

@SuppressWarnings("serial")
public class LabelDialog extends JDialog {

	private JButton ok;

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public LabelDialog(JFrame parent, JTextField name) {
		super(parent, Editor.getInstance().getResourceBundle()
				.getString("addLabelParameter"), true);
		setLayout(new MigLayout());
		setSize(400, 200);
		setLocationRelativeTo(parent);
		setResizable(false);

		ImageIcon icon = new ImageIcon("Images/Icons/Parameters/label.png");
		setIconImage(icon.getImage());

		JLabel txtLabel = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("tekstLabele"));
		JTextArea txtArea = new JTextArea(10, 50);
		txtArea.setLineWrap(true);
		JScrollPane txtScroll = new JScrollPane(txtArea);

		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		LabelDialogListener lbl = new LabelDialogListener(txtArea, this, name);
		ok = new JButton("Ok");

		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));

		DialogCancelListener cancelL = new DialogCancelListener(this);
		ok.addActionListener(lbl);
		cancel.addActionListener(cancelL);
		btns.add(ok);
		btns.add(cancel);

		add(txtLabel);
		add(txtScroll, "wrap");

		add(new JLabel(""));
		add(btns);
	}
}
