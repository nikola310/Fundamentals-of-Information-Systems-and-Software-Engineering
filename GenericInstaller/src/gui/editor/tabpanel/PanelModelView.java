package gui.editor.tabpanel;

import java.util.Observable;
import java.util.Observer;

import model.tree.PanelModel;
import model.tree.ParameterModel;

public class PanelModelView implements Observer {

	private PanelModel model;

	public PanelModelView(PanelModel model) {
		this.model = model;

		model.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getState().equals(PanelModel.SELECTION)) {
			ViewPanel.STATE = false;
			if (TabPanel.getInstance().indexOfTab(model.getName()) == -1) {
				TabPanel.getInstance().addTabbedPanel(model.getName());
			}
		} else if (model.getState().equals(PanelModel.PARAMETARADD)) {
			ParameterModel parameter = (ParameterModel) arg;
			TabPanel.getInstance().addPanel(parameter);
		}
	}

}
