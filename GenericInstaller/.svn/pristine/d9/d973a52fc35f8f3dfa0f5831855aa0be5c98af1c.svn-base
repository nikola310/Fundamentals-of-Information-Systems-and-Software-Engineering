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
import controller.parameters.listeners.action.DialogBrowseListener;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.PathDialogListener;

@SuppressWarnings("serial")
public class PathDialog extends JDialog {

	private JButton ok;

	public PathDialog(JFrame parent, JTextField name) {
		super(parent, Editor.getInstance().getResourceBundle()
				.getString("addPathParameter"), true);
		setLayout(new MigLayout());
		setSize(400, 200);
		setLocationRelativeTo(parent);

		ImageIcon icon = new ImageIcon("Images/Icons/Parameters/path.png");
		setIconImage(icon.getImage());

		JLabel txtLabel = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("dodatniTekst"));
		JLabel defLoc = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("setDefaultLocation"));
		JTextArea txtArea = new JTextArea(10, 50);
		txtArea.setLineWrap(true);
		JTextField locField = new JTextField(25);
		JButton browse = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Pretrazi"));
		DialogBrowseListener brListener = new DialogBrowseListener(this,
				locField, "directories");
		browse.addActionListener(brListener);

		JScrollPane txtScroll = new JScrollPane(txtArea);

		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ok = new JButton("Ok");

		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));

		PathDialogListener okL = new PathDialogListener(name, this, txtArea,
				locField);
		ok.addActionListener(okL);

		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		btns.add(ok);
		btns.add(cancel);

		add(txtLabel);
		add(txtScroll, "wrap");
		add(defLoc);
		add(locField);
		add(browse, "wrap");

		add(new JLabel(""));
		add(btns);
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}
}
