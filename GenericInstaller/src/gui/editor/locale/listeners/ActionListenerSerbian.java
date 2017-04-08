package gui.editor.locale.listeners;
import gui.editor.Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import user.Main;
public class ActionListenerSerbian implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		Locale.setDefault(new Locale("sr","RS"));
		Editor.getInstance().changeLanguage();
		Main.LANGUAGE = "Serbian";
		
	}
}
