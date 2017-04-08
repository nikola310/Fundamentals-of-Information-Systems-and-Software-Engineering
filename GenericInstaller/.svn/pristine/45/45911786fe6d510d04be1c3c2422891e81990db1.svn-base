package controller.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.tree.WorkSpaceTreeModel;

public class SerializationWorkSpace {
	public static boolean FLAG = false;

	public void save(WorkSpaceTreeModel model) {
		try {
			BrowseFile bf = new BrowseFile("directories");
			String path = bf.getPath();
			if (bf.getBrowse().getApproveButtonText().equals("Save")) {

				try {
					FileOutputStream fileOut = new FileOutputStream(path
							+ ".nkvd");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(model);
					out.close();
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.err.println("Cuvanje datoteke prekinuto!");

		}

	}

	public WorkSpaceTreeModel load() {
		String path = "";
		WorkSpaceTreeModel model = null;
		try {
			BrowseFile bf = new BrowseFile("nkvd");
			path = bf.getPath();
			if (bf.getBrowse().getApproveButtonText().equals("Open")) {
				FLAG = false;
				try {
					FileInputStream fileIn = new FileInputStream(path);
					ObjectInputStream in = new ObjectInputStream(fileIn);
					model = (WorkSpaceTreeModel) in.readObject();
					in.close();
					fileIn.close();
					FLAG = false;
				} catch (IOException i) {
					i.printStackTrace();
					return null;
				} catch (ClassNotFoundException c) {
					c.printStackTrace();
					return null;
				}
			}
		} catch (Exception e) {
			FLAG = true;
			System.err.println("Otvaranje datoteke je prekinuto!");
		}

		return model;
	}
}
