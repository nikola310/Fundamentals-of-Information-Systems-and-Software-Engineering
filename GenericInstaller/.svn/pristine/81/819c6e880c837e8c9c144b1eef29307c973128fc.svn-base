package gui.editor.dialogs;

import gui.editor.Editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.tree.PanelModel;
import net.miginfocom.swing.MigLayout;
import controller.editor.listeners.FrameDialogListener;
import controller.parameters.listeners.action.DialogCancelListener;

@SuppressWarnings("serial")
public class FrameDialog extends JDialog {

	/*
	 * Dijalog za podesavanje odredjenog frejma
	 */
	private JTextField nameText;
	private JLabel nameLabel;
	private JLabel nameDimension;
	private JLabel height;
	private JTextField sizeH;
	private JLabel width;
	private JTextField sizeW;
	private JCheckBox resizable;

	public FrameDialog(JFrame parent) {
		super(parent);
		if (Editor.getInstance().getTree().getLastSelectedPathComponent() == null) {
			JOptionPane.showMessageDialog(parent, Editor.getInstance()
					.getResourceBundle().getString("NoPanelMsg"));
		} else {

			setLayout(new BorderLayout());
			setModal(true);
			setResizable(false);
			setSize(250, 210);
			setLocationRelativeTo(parent);
			setTitle(Editor.getInstance().getResourceBundle()
					.getString("EditFrame"));

			ImageIcon icon = new ImageIcon("Images/Icons/edit_panel.png");
			setIconImage(icon.getImage());

			JPanel center = new JPanel();

			center.setLayout(new MigLayout());

			JPanel name = new JPanel();

			nameLabel = new JLabel(Editor.getInstance().getResourceBundle()
					.getString("setPanelTitle"));
			nameText = new JTextField(((PanelModel) Editor.getInstance()
					.getTree().getLastSelectedPathComponent()).getTitle());
			nameText.setPreferredSize(new Dimension(100, 20));

			name.add(nameLabel);
			name.add(nameText);

			JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			JButton ok = new JButton(Editor.getInstance().getResourceBundle()
					.getString("OK"));

			JButton cancel = new JButton(Editor.getInstance()
					.getResourceBundle().getString("Ponisti"));
			DialogCancelListener cancelL = new DialogCancelListener(this);
			cancel.addActionListener(cancelL);

			nameDimension = new JLabel(Editor.getInstance().getResourceBundle()
					.getString("setFrameDimension"));

			height = new JLabel(Editor.getInstance().getResourceBundle()
					.getString("setFrameHeight"));
			sizeH = new JTextField(String.valueOf(((PanelModel) Editor
					.getInstance().getTree().getLastSelectedPathComponent())
					.getHeight()));
			sizeH.setPreferredSize(new Dimension(50, 20));

			width = new JLabel(Editor.getInstance().getResourceBundle()
					.getString("setFrameWidth"));
			sizeW = new JTextField(String.valueOf(((PanelModel) Editor
					.getInstance().getTree().getLastSelectedPathComponent())
					.getWidth()));
			sizeW.setPreferredSize(new Dimension(50, 20));

			JPanel dimension = new JPanel();
			dimension.setLayout(new MigLayout());
			dimension.add(height);
			dimension.add(sizeH, "wrap");
			dimension.add(width);
			dimension.add(sizeW);

			resizable = new JCheckBox(Editor.getInstance().getResourceBundle()
					.getString("resizeableFrame"));
			resizable.setSelected(((PanelModel) Editor.getInstance().getTree()
					.getLastSelectedPathComponent()).isResizable());
			center.add(name, "wrap");
			center.add(nameDimension, "wrap");
			center.add(dimension, "wrap");
			center.add(resizable, "wrap");

			FrameDialogListener okL = new FrameDialogListener(sizeW, sizeH,
					(PanelModel) Editor.getInstance().getTree()
							.getLastSelectedPathComponent(), this, resizable,
					nameText);
			ok.addActionListener(okL);
			buttons.add(ok);
			buttons.add(cancel);

			add(center, BorderLayout.CENTER);
			add(buttons, BorderLayout.SOUTH);
		}

	}

}
