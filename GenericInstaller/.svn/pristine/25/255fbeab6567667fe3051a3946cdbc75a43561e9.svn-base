package gui.parameters;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class ParametersImage extends JPanel{
   
	
	public ParametersImage(String path) {
		super();
		setBackground(new Color(0, 255, 0, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon image = new ImageIcon();
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
				JLabel preview = new JLabel(new ImageIcon(path));
				add(preview);
	}
	
}