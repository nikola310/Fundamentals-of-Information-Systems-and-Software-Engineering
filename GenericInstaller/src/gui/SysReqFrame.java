package gui;

import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import controller.installation.ClosePanelListener;
import controller.installation.SysReqBackListener;
import controller.installation.SysReqBrowseListener;
import controller.installation.SysReqInstallListener;

@SuppressWarnings("serial")
public class SysReqFrame extends JFrame {
	JFileChooser browse;
	private boolean useSysReqFrame;
	private int indexSysReqFrame;

	public SysReqFrame(PanelPreview parent) {
		parent.setVisible(false);
		useSysReqFrame = false;
		indexSysReqFrame = 0;
		setLayout(new BorderLayout());
		PanelPreview.setNewIcon(this);


		System.out.println(parent.getPanels().toString());

		setTitle(Editor.getInstance().getResourceBundle()
				.getString("InstallLoc"));

		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel pathLabel = new JLabel(Editor.getInstance().getResourceBundle()
				.getString("InstallDest"));
		JTextField pathTxt = new JTextField(30);
		JButton pathBrowse = new JButton(Editor.getInstance()
				.getResourceBundle().getString("Pretrazi"));
		SysReqBrowseListener pathBrowseL = new SysReqBrowseListener(this,
				pathTxt);
		pathBrowse.addActionListener(pathBrowseL);
		JPanel center = new JPanel(new MigLayout());
		center.add(pathLabel);
		center.add(pathTxt);
		center.add(pathBrowse, "wrap");
		pathTxt.setText(System.getProperty("user.home"));
		center.add(new JLabel(Editor.getInstance().getResourceBundle()
				.getString("FreeSpace")));
		JPanel dirs = new JPanel(new MigLayout());
		for (Path root : FileSystems.getDefault().getRootDirectories()) {
			try {
				FileStore store = Files.getFileStore(root);
				JLabel tmp = new JLabel(root + ": "
						+ String.valueOf(store.getUsableSpace() / 1024 / 1024)
						+ " MB");
				dirs.add(tmp, "wrap");
			} catch (IOException e) {
				JLabel tmp = new JLabel(root + Editor.getInstance().getResourceBundle().getString("SpaceErr"));
				dirs.add(tmp, "wrap");
			}
		}
		center.add(dirs, "growx, growy");

		JButton install = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Next"));
		SysReqInstallListener nextL = new SysReqInstallListener(this, pathTxt,
				parent);
		install.addActionListener(nextL);
		JButton back = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Nazad"));
		SysReqBackListener backL = new SysReqBackListener(this, parent);
		back.addActionListener(backL);
		JButton close = new JButton(Editor.getInstance().getResourceBundle()
				.getString("btnZatvori"));
		ClosePanelListener closeL = new ClosePanelListener(this);
		close.addActionListener(closeL);
		JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btns.add(back);
		btns.add(install);
		btns.add(close);

		add(center, BorderLayout.CENTER);
		add(btns, BorderLayout.SOUTH);
	}

	public boolean getUseSysReqFrame() {
		return useSysReqFrame;
	}

	public void setUseSysReqFrame(boolean useSysReqFrame) {
		this.useSysReqFrame = useSysReqFrame;
	}

	public int getIndexSysReqFrame() {
		return indexSysReqFrame;
	}

	public void setIndexSysReqFrame(int indexSysReqFrame) {
		this.indexSysReqFrame = indexSysReqFrame;
	}

}
