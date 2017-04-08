package user;

import gui.Language;
import gui.WelcomeFrame;
import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.io.File;
import java.util.Locale;

import javax.swing.UIManager;

import model.tree.FinishModel;
import model.tree.WorkSpaceTreeModel;
import controller.serialization.FinishData;
import controller.serialization.LanguageChosen;
import controller.serialization.SaveWorkspace;

public class Main {

	public static String LANGUAGE = "English";

	private static WelcomeFrame frame;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable ex) {

		}

		File flag = new File("Files\\flag.dat");

		if (flag.exists()) {

			setFrame(new WelcomeFrame());

			File file = new File("Files\\language.dat");

			if (file.exists()) {
				LanguageChosen langChosen = new LanguageChosen();
				String language = langChosen.load();

				if (language.equals("Serbian")) {
					Locale.setDefault(new Locale("sr", "RS"));
					LANGUAGE = "Serbian";
				} else {
					Locale.setDefault(new Locale("en", "US"));
					LANGUAGE = "English";
				}

				Editor.getInstance().setVisible(true);

			} else {
				Language lang = new Language();
				lang.setVisible(true);
			}
		} else {
			SaveWorkspace loadW = new SaveWorkspace();
			loadW.load();
			FinishData fin = new FinishData();
			FinishModel finModel = fin.load();
			WorkSpaceTreeModel root = (WorkSpaceTreeModel) Editor.getInstance().getTree().getModel().getRoot();
			root.setFinish(finModel);
			PanelPreview panelPreview = new PanelPreview();
			panelPreview.setVisible(true);
		}

	}

	public static WelcomeFrame getFrame() {
		return frame;
	}

	public static void setFrame(WelcomeFrame frame) {
		Main.frame = frame;
	}

}
