package model.tree;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

public class ParameterModel extends Observable implements TreeNode,
		Serializable {

	/*
	 * Model parametra, sadzi, ime, tip, vrednost parametra i panel kome pripada
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String IMAGE = "image";
	public static String TEXT = "text";
	public static String PATH = "path";
	public static String LABEL = "label";
	public static String SELECTION = "selection";

	private String name;
	private String type;
	private Object parameter;
	private PanelModel parent;

	public ParameterModel(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public ParameterModel(String name, String type, Object parameter,
			PanelModel parent) {
		this.name = name;
		this.type = type;
		this.parameter = parameter;
		this.parent = parent;
	}

	public ParameterModel(ParameterModel parameterModel) {
		// TODO Auto-generated constructor stub
		this.name = parameterModel.name;
		this.type = parameterModel.type;
		this.parameter = parameterModel.parameter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
		setChanged();
		notifyObservers();
	}

}
