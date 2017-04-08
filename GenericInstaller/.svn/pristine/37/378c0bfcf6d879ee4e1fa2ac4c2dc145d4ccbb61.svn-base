package gui.parameters.dialogs;

import gui.editor.Editor;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import controller.parameters.listeners.action.DialogCancelListener;
import controller.parameters.listeners.action.TextDialogListener;

@SuppressWarnings("serial")
public class TextDialog extends JDialog {

	private JTextArea txtArea;
	private ButtonGroup buttons;
	private JButton ok;

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public TextDialog(JFrame parent, JTextField name) {
		super(parent, Editor.getInstance().getResourceBundle()
				.getString("addTextParameter"), true);
		// this.parent = parent;
		setLayout(new MigLayout());

		setSize(400, 200);
		setLocationRelativeTo(parent);
		setResizable(false);
		ImageIcon icon = new ImageIcon("Images/Icons/Parameters/text.png");
		setIconImage(icon.getImage());

		JLabel txtLabel = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("tekstZaUpis"));
		txtArea = new JTextArea(10, 50);
		txtArea.setLineWrap(true);
		JScrollPane txtScroll = new JScrollPane(txtArea);

		JRadioButton areaBtn = new JRadioButton(Editor.getInstance()
				.getResourceBundle().getString("viseLinijaTeksta"));
		JRadioButton lblBtn = new JRadioButton(Editor.getInstance()
				.getResourceBundle().getString("jednaLinijaTeksta"));
		buttons = new ButtonGroup();
		areaBtn.setSelected(true);
		buttons.add(areaBtn);
		buttons.add(lblBtn);

		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ok = new JButton("Ok");

		TextDialogListener okListen = new TextDialogListener(this, txtArea,
				buttons, name);
		ok.addActionListener(okListen);
		JButton cancel = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Ponisti"));
		DialogCancelListener cancelL = new DialogCancelListener(this);
		cancel.addActionListener(cancelL);
		btns.add(ok);
		btns.add(cancel);
		add(txtLabel);
		add(txtScroll, "wrap");
		add(new JLabel(""));

		add(areaBtn, "split 2");
		add(lblBtn, "wrap");
		add(new JLabel(""));
		add(btns);
	}

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

	public ButtonGroup getButtons() {
		return buttons;
	}

	public void setButtons(ButtonGroup buttons) {
		this.buttons = buttons;
	}
}
