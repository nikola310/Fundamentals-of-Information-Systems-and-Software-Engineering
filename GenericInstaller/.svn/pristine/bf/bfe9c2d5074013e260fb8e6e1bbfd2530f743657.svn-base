package gui.editor;

import gui.editor.locale.listeners.ActionListenerEnglish;
import gui.editor.locale.listeners.ActionListenerSerbian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import user.Main;
import controller.editor.listeners.AboutListener;
import controller.editor.listeners.CloseAll;
import controller.editor.listeners.DeleteElement;
import controller.editor.listeners.FrameEditAction;
import controller.editor.listeners.HelpListener;
import controller.parameters.listeners.action.PanelDialogListener;
import controller.parameters.listeners.action.ParameterDialogListener;
import controller.serialization.LanguageChosen;
import controller.serialization.Open;
import controller.serialization.Save;

@SuppressWarnings("serial")
public class EditorMenuBar extends JMenuBar {
	private ResourceBundle resourceBundle;
	private JMenu file;
	private JMenu edit;
	private JMenu run;
	private JMenu window;
	private JMenu help;
	private JMenu neW;
	private JMenuItem exit;
	private JMenuItem panel;
	private JMenuItem parameter;
	private JMenuItem open;
	private JMenuItem close;
	private JMenuItem save;
	private JMenuItem delete;
	private JMenuItem preview;
	private JMenuItem compile;
	private JMenu language;
	private JMenuItem english;
	private JMenuItem serbian;
	private JMenuItem helpContents;
	private JMenuItem about;
	private JMenuItem editFrame;

	public EditorMenuBar(final JFrame parent) {
		resourceBundle = ResourceBundle.getBundle(
				"model.MessageResources.MessageResources", Locale.getDefault());

		// Dodavanje osnovnih elemenata u meni
		file = new JMenu(resourceBundle.getString("btnFajl"));
		file.setMnemonic(KeyEvent.VK_F);

		edit = new JMenu(resourceBundle.getString("btnIzmeni"));
		edit.setMnemonic(KeyEvent.VK_E);

		run = new JMenu(resourceBundle.getString("btnPokreni"));
		run.setMnemonic(KeyEvent.VK_R);

		window = new JMenu(resourceBundle.getString("btnProzor"));
		window.setMnemonic(KeyEvent.VK_W);

		help = new JMenu(resourceBundle.getString("btnPomoc"));
		help.setMnemonic(KeyEvent.VK_H);
		

		// dodavanje elemenata u File
		neW = new JMenu(resourceBundle.getString("btnNovi"));
		neW.setMnemonic(KeyEvent.VK_N);

		panel = new JMenuItem(resourceBundle.getString("btnPanel"));
		PanelDialogListener dialog = new PanelDialogListener(parent);
		panel.setMnemonic(KeyEvent.VK_N);
		panel.setIcon(new ImageIcon("Images/Icons/add_panel.png"));
		panel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		panel.addActionListener(dialog);

		parameter = new JMenuItem(resourceBundle.getString("btnParametar"));
		ParameterDialogListener paramL = new ParameterDialogListener(parent);
		parameter.setMnemonic(KeyEvent.VK_R);
		parameter.setIcon(new ImageIcon("Images/Icons/parameter.png"));
		parameter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		parameter.addActionListener(paramL);

		neW.add(panel);
		neW.add(parameter);

		open = new JMenuItem(resourceBundle.getString("btnOtvoriFajl"));
		open.setMnemonic(KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		
		Open openO = new Open();
		open.addActionListener(openO);

		close = new JMenuItem(resourceBundle.getString("btnZatvori"));
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));

		CloseAll closeAll = new CloseAll();
		close.addActionListener(closeAll);

		save = new JMenuItem(resourceBundle.getString("btnSnimi"));
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		
		Save saveS = new Save();
		save.addActionListener(saveS);

		exit = new JMenuItem(resourceBundle.getString("btnIzadji"));
		exit.setMnemonic(KeyEvent.VK_X);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int choice = JOptionPane.showConfirmDialog(
						parent,
						Editor.getInstance().getResourceBundle()
								.getString("sure"),
						Editor.getInstance().getResourceBundle()
								.getString("exitInstaller"),
						JOptionPane.YES_NO_OPTION);
				if (choice != JOptionPane.YES_OPTION) {
					parent.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					LanguageChosen langChosen = new LanguageChosen();
					langChosen.save(Main.LANGUAGE);
					System.exit(0);
				}
			}
		});

		file.add(neW);
		file.add(open);
		file.addSeparator();
		file.add(close);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(exit);

		// Dodavanje elemenata u Edit
		editFrame = new JMenuItem(resourceBundle.getString("EditFrame"));
		editFrame.setMnemonic(KeyEvent.VK_F);
		editFrame.setIcon(new ImageIcon("Images/Icons/edit_panel.png"));
		editFrame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		FrameEditAction editFrameL = new FrameEditAction(parent);
		editFrame.addActionListener(editFrameL);

		delete = new JMenuItem(resourceBundle.getString("btnObrisi"));
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setIcon(new ImageIcon("Images/Icons/delete.png"));
		delete.setAccelerator(KeyStroke.getKeyStroke("DELETE"));
		DeleteElement deleteL = new DeleteElement();
		delete.addActionListener(deleteL);

		edit.add(editFrame);
		edit.addSeparator();
		edit.add(delete);

		// Dodavanje elemenata u Run
		preview = new JMenuItem(resourceBundle.getString("btnPregled"));
		preview.setMnemonic(KeyEvent.VK_E);
		preview.setIcon(new ImageIcon("Images/Icons/view.png"));
		preview.setAccelerator(KeyStroke.getKeyStroke("F11"));

		compile = new JMenuItem(resourceBundle.getString("btnKompajliraj"));
		compile.setMnemonic(KeyEvent.VK_M);
		compile.setIcon(new ImageIcon("Images/Icons/run.png"));
		compile.setAccelerator(KeyStroke.getKeyStroke("F9"));

		run.add(preview);
		run.add(compile);

		// Dodavanje elemenata u Windows
		language = new JMenu(resourceBundle.getString("btnJezik"));
		language.setMnemonic(KeyEvent.VK_L);

		english = new JMenuItem(resourceBundle.getString("Engleski"));
		english.setSelected(true);
		english.addActionListener(new ActionListenerEnglish());
		english.setMnemonic(KeyEvent.VK_E);

		serbian = new JMenuItem(resourceBundle.getString("Srpski"));
		serbian.setSelected(true);
		serbian.addActionListener(new ActionListenerSerbian());
		serbian.setMnemonic(KeyEvent.VK_S);

		language.add(english);
		language.add(serbian);

		window.add(language);

		// Dodavanje elemenata u Help
		helpContents = new JMenuItem(resourceBundle.getString("btnSadrzaj"));
		helpContents.setMnemonic(KeyEvent.VK_H);
		HelpListener helpL = new HelpListener(parent);
		helpContents.addActionListener(helpL);
		
		about = new JMenuItem(resourceBundle.getString("btnOProgramu"));
		about.setMnemonic(KeyEvent.VK_A);
		AboutListener aboutL = new AboutListener(parent);
		about.addActionListener(aboutL);

		help.add(helpContents);
		help.add(about);

		add(file);
		add(edit);
		add(run);
		add(window);
		add(help);
	}

	public void initComponents() {

		file.setText(Editor.getInstance().getResourceBundle()
				.getString("btnFajl"));
		edit.setText(Editor.getInstance().getResourceBundle()
				.getString("btnIzmeni"));
		run.setText(Editor.getInstance().getResourceBundle()
				.getString("btnPokreni"));
		window.setText(Editor.getInstance().getResourceBundle()
				.getString("btnProzor"));
		help.setText(Editor.getInstance().getResourceBundle()
				.getString("btnPomoc"));
		neW.setText(Editor.getInstance().getResourceBundle()
				.getString("btnNovi"));
		panel.setText(Editor.getInstance().getResourceBundle()
				.getString("btnPanel"));
		parameter.setText(Editor.getInstance().getResourceBundle()
				.getString("btnParametar"));
		open.setText(Editor.getInstance().getResourceBundle()
				.getString("btnOtvori"));
		close.setText(Editor.getInstance().getResourceBundle()
				.getString("btnZatvori"));
		save.setText(Editor.getInstance().getResourceBundle()
				.getString("btnSnimi"));
		delete.setText(Editor.getInstance().getResourceBundle()
				.getString("btnObrisi"));
		preview.setText(Editor.getInstance().getResourceBundle()
				.getString("btnPregled"));
		compile.setText(Editor.getInstance().getResourceBundle()
				.getString("btnKompajliraj"));
		language.setText(Editor.getInstance().getResourceBundle()
				.getString("btnJezik"));
		english.setText(Editor.getInstance().getResourceBundle()
				.getString("Engleski"));
		serbian.setText(Editor.getInstance().getResourceBundle()
				.getString("Srpski"));
		helpContents.setText(Editor.getInstance().getResourceBundle()
				.getString("btnSadrzaj"));
		about.setText(Editor.getInstance().getResourceBundle()
				.getString("btnOProgramu"));
		exit.setText(Editor.getInstance().getResourceBundle()
				.getString("btnIzadji"));
		editFrame.setText(Editor.getInstance().getResourceBundle()
				.getString("EditFrame"));

	}
}
