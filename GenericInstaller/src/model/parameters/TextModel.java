package model.parameters;

import java.io.Serializable;
import java.util.Observable;

public class TextModel extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String text;
	boolean lines;// vise ili manje linija teksta true = vise, false = jedna

	public TextModel(String text, boolean lines) {
		super();
		this.text = text;
		this.lines = lines;
		System.out.println(text);
		notifyObservers();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLines() {
		return lines;
	}

	public void setLines(boolean lines) {
		this.lines = lines;
	}

}
