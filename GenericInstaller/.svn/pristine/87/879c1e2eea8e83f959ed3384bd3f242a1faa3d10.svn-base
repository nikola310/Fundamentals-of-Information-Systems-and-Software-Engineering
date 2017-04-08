package controller.editor.listeners;

import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import controller.serialization.FinishData;
import controller.serialization.SaveWorkspace;
import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;

public class CreateInstallationListener implements ActionListener {

	/*
	 * Listener koji pravi instalacioni paket instalacioni paket se odabere i
	 * kopira na izabranu lokaciju, te se brise flag.dat, kako bi se instaler
	 * pokrenuo u drugom rezimu
	 * takodjer se odabere ime izvrsne datoteke
	 * serijalizuje se ceo workspace i finishmodel
	 */
	private JTextField srcPath;
	private JDialog parent;
	private JTextField destPath;
	private JTextField exe;

	public CreateInstallationListener(JTextField srcPath, JDialog parent,
			JTextField destPath, JTextField exe) {
		super();
		this.srcPath = srcPath;
		this.parent = parent;
		this.destPath = destPath;
		this.exe = exe;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance()
				.getTree().getModel().getRoot();
		FinishModel finishModel = root.getFinish();
		finishModel.setExe(Paths.get(exe.getText()).getFileName().toString());

		FinishData finishData = new FinishData();
		finishData.save(finishModel);

		SaveWorkspace saveW = new SaveWorkspace();
		saveW.save((WorkSpaceTreeModel) Editor.getInstance().getTree()
				.getModel().getRoot());

		File genDir = new File(System.getProperty("user.dir"));
		File genDestDir = new File(destPath.getText() + File.separatorChar
				+ "installation");
		try {
			FileUtils.copyDirectory(genDir, genDestDir);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		File srcDir = new File(srcPath.getText());
		File destDir = new File(destPath.getText() + File.separatorChar
				+ "installation" + File.separatorChar + "Files"
				+ File.separatorChar + "data");
		try {
			FileUtils.copyDirectory(srcDir, destDir);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		File flag = new File("flag.dat");
		Collection<File> files = FileUtils.listFilesAndDirs(genDestDir,
				TrueFileFilter.TRUE, TrueFileFilter.TRUE);
		for (File f : files) {
			if (f.isFile()) {
				if (f.getName().equals(flag.getName())) {
					f.delete();
					break;
				}

			}

		}

		JOptionPane.showMessageDialog(parent, Editor.getInstance()
				.getResourceBundle().getString("InstallationCreated"));
		parent.setVisible(false);

	}

}
