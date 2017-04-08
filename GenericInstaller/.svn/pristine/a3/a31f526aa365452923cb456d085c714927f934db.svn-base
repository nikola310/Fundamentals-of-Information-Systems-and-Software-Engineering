package gui.editor.tabpanel;

import gui.parameters.ParametersImage;
import gui.parameters.ParametersLabel;
import gui.parameters.ParametersPath;
import gui.parameters.ParametersSelection;
import gui.parameters.ParametersText;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.parameters.ImageModel;
import model.parameters.LabelModel;
import model.parameters.PathModel;
import model.parameters.SelectionModel;
import model.parameters.TextModel;
import model.tree.PanelModel;
import model.tree.ParameterModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ViewPanel extends JPanel {
	private ParameterModel pom = null;
	public static boolean STATE = false;

	public ViewPanel() {
		setLayout(new MigLayout());
		setBackground(Color.white);
		setVisible(true);
	}

	public void addParameter(ParameterModel parameter) {
		if (pom != parameter && STATE == false) {
			Object object = parameter.getParameter();

			if (object instanceof TextModel) {

				TextModel text = (TextModel) object;
				ParametersText pText = new ParametersText(text.getText(),
						text.isLines());
				add(pText, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof LabelModel) {

				LabelModel label = (LabelModel) object;
				ParametersLabel pLabel = new ParametersLabel(label.getText());
				add(pLabel, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof PathModel) {

				PathModel path = (PathModel) object;
				ParametersPath pPath = new ParametersPath(path.getLabel(),
						path.getPath());
				add(pPath, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof ImageModel) {

				ImageModel image = (ImageModel) object;
				ParametersImage pImage = new ParametersImage(image.getPath());
				add(pImage, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof SelectionModel) {

				SelectionModel selection = (SelectionModel) object;
				ParametersSelection pSelection = new ParametersSelection(
						selection.getChoicesList(), selection.isType(),
						selection.getLabel());
				add(pSelection, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");
			}
			pom = parameter;

		} else if (STATE == true) {
			Object object = parameter.getParameter();

			if (object instanceof TextModel) {

				TextModel text = (TextModel) object;
				ParametersText pText = new ParametersText(text.getText(),
						text.isLines());
				add(pText, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof LabelModel) {

				LabelModel label = (LabelModel) object;
				ParametersLabel pLabel = new ParametersLabel(label.getText());
				add(pLabel, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof PathModel) {

				PathModel path = (PathModel) object;
				ParametersPath pPath = new ParametersPath(path.getLabel(),
						path.getPath());
				add(pPath, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");

			} else if (object instanceof ImageModel) {

				ImageModel image = (ImageModel) object;
				ParametersImage pImage = new ParametersImage(image.getPath());
				add(pImage, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");
			} else if (object instanceof SelectionModel) {

				SelectionModel selection = (SelectionModel) object;
				ParametersSelection pSelection = new ParametersSelection(
						selection.getChoicesList(), selection.isType(),
						selection.getLabel());
				add(pSelection, "wrap");
				JPanel space = new JPanel();
				space.setPreferredSize(new Dimension(10, 10));
				space.setBackground(Color.white);
				add(space, "wrap");
			}
		}
	}

	public void addPanel(PanelModel panel) {

		int end = panel.getChildCount();
		if (end != 0) {
			for (int i = 0; i < end; i++) {
				ParameterModel parameter = (ParameterModel) panel.getChildAt(i);
				addParameter(parameter);
			}
		}
	}

}
