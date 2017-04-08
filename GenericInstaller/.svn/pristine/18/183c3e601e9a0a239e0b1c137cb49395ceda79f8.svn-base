package gui;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class WelcomeFrame extends JFrame{
	public WelcomeFrame() {
		setSize(317,308);
		setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("Images/Icon.jpg");
		setIconImage(icon.getImage());
		
		ImagePanel panel = new ImagePanel(new ImageIcon("Images/welcomeScreen.png").getImage());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
        add(panel, BorderLayout.CENTER);
        setUndecorated(true);
        setVisible(true);
		
		new WelcomeTimer(this);
		// vremensko usaglasavanje sa trajanjem prozora
		try {
			Thread.sleep(3200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	// namestanje slike
	class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
		    				 (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
		  }
	}
	// trajanje prozora
    class WelcomeTimer {
		private Timer timer;
		private JFrame frame;
		
		public WelcomeTimer(JFrame frame) {
			timer = new Timer();
	        timer.schedule(new RemindTask(), 3000);
	        this.frame = frame;
		}
		
		class RemindTask extends TimerTask {
	        public void run() {
	            frame.setVisible(false);
	            timer.cancel();
	        }
	    }
	}
			
}
