package controller.parameters.listeners.action;

import gui.parameters.dialogs.ImageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;

import model.parameters.ImageModel;
import model.tree.ParameterModel;

import org.apache.commons.io.FileUtils;

import controller.tree.actions.NewParameterAction;

public class ImageDialogListener implements ActionListener {

	private JTextField imagePath; // putanja do slike
	private ImageDialog parent;
	private JTextField name;

	public ImageDialogListener(ImageDialog parent, JTextField imagePath,
			JTextField name) {
		super();
		this.imagePath = imagePath;
		this.parent = parent;
		this.name = name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String img = "";
		System.out.println("ovde");
		try {
			System.out.println("ovde1");
			System.out.println(imagePath.getText());
			File inF = new File(imagePath.getText());
			System.out.println("ovde2");
			File outF = new File(System.getProperty("user.dir")
					+ File.separatorChar + "Files" + File.separatorChar
					+ "user_images");
			img = inF.getName();
			FileUtils.copyFileToDirectory(inF, outF);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		img = System.getProperty("user.dir") + File.separatorChar + "Files"
				+ File.separatorChar + "user_images" + File.separatorChar + img;
		System.out.println(img);
		ImageModel model = new ImageModel(imagePath.getText());
		@SuppressWarnings("unused")
		NewParameterAction paramAct = new NewParameterAction(name.getText(),
				ParameterModel.IMAGE, model);
		parent.setVisible(false);

	}
}
