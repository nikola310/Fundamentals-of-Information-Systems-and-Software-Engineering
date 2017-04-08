package model.parameters;

import java.io.Serializable;

public class LabelModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String text;

	public LabelModel(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}
