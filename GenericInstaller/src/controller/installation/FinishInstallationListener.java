package controller.installation;

import gui.editor.Editor;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JCheckBox;

import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;
import net.jimmc.jshortcut.JShellLink;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FinishInstallationListener implements ActionListener {

	private String installationDir;
	private WorkSpaceTreeModel root;
	private JCheckBox readmeOpen;
	private JCheckBox desktopIcon;

	public FinishInstallationListener(String installationDir,
			JCheckBox readmeOpen, JCheckBox desktopIcon) {
		super();
		this.installationDir = installationDir;
		this.readmeOpen = readmeOpen;
		this.desktopIcon = desktopIcon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		root = (WorkSpaceTreeModel) Editor.getInstance().getTree().getModel()
				.getRoot();
		FinishModel fin = root.getFinish();
		String readmeFileName = fin.getReadme();
		String exeFileName = fin.getExe();
		if (desktopIcon.isSelected()) {
			Collection<File> listOfFiles = FileUtils.listFilesAndDirs(new File(
					installationDir), TrueFileFilter.TRUE, TrueFileFilter.TRUE);
			for (File file : listOfFiles) {
				if (file.isFile()) {
					if (file.getName().equals(exeFileName)) {
						CreateShortcut(file.getName(), file.getAbsolutePath());
						break;
					}
				}
			}
			// za otvaranje readme datoteke
			if (readmeOpen.isSelected()) {
				Collection<File> txtFiles = FileUtils.listFilesAndDirs(
						new File(installationDir), TrueFileFilter.TRUE,
						TrueFileFilter.TRUE);
				for (File file : txtFiles) {
					if (file.isFile()) {
						if (file.getName().equals(readmeFileName)) {
							try {
								Desktop.getDesktop().edit(file);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							break;
						}
					}

				}
			}
		}
		System.exit(0);
	}

	public void CreateShortcut(String fileName, String filePath) {
		try {
			JShellLink link = new JShellLink();
			link.setFolder(JShellLink.getDirectory("desktop"));
			link.setName(fileName);
			link.setPath(filePath);
			link.save();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
