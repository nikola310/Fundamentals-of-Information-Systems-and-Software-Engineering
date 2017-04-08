package gui.tree.view;

import gui.editor.tabpanel.TabPanel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.tree.PanelModel;

public class WorkSpaceTreeEditor extends DefaultTreeCellEditor implements ActionListener{
	private Object stavka = null;
	private JTextField edit = null;
	
	public WorkSpaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5){
		stavka = arg1;
		
		edit = new JTextField(arg1.toString());
		edit.addActionListener(this);
		return edit;
	}
	
	public boolean isCellEditable(EventObject arg0) {
		//if (arg0 instanceof MouseEvent)
		//	if (((MouseEvent)arg0).getClickCount() == 2) {
		//		return true;
		//	}
			
		return false;	
	}
	
	/*public void actionPerformed(ActionEvent e){
		if (stavka instanceof PanelTreeModel) {
			((PanelTreeModel)stavka).setName(e.getActionCommand());
		} else {
			((ParameterTreeModel)stavka).setName(e.getActionCommand());
		}
	}*/
	
	public void actionPerformed(ActionEvent e){
		System.out.println("TEST");
		if (stavka instanceof PanelModel) {
			//((PanelTreeModel)stavka).setName(e.getActionCommand());
			String name = ((PanelModel)stavka).getName();
			if (TabPanel.getInstance().getName() == name) {
				Component c = TabPanel.getInstance().getC(name);
				TabPanel.getInstance().setSelectedComponent(c);
			}
		} else {
			//((ParameterTreeModel)stavka).setName(e.getActionCommand());
		}
	}

}
