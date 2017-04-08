package controller.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.tree.FinishModel;

public class FinishData {
	public void save(FinishModel model) {

				try {
					FileOutputStream fileOut = new FileOutputStream("Files"+File.separatorChar+"finish.dat");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(model);
					out.close();
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	

	public FinishModel load() {
		FinishModel model;
				try {
					FileInputStream fileIn = new FileInputStream("Files"+File.separatorChar+"finish.dat");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					model = (FinishModel) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException i) {
					i.printStackTrace();
					return null;
				} catch (ClassNotFoundException c) {
					c.printStackTrace();
					return null;
				}
			
		return model;
	}

}
