package gui;

import gui.editor.locale.listeners.ActionListenerEnglish;
import gui.editor.locale.listeners.ActionListenerSerbian;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.listeners.mouse.MouseListenerClose;
import controller.listeners.mouse.MouseListenerLanguage;



@SuppressWarnings("serial")
public class Language extends JFrame{
	public static boolean useLanguage; // da li je frejm aktivan
	private int indexLanguage; // redosled frejma
	
	public Language() {
				useLanguage = false; 
				indexLanguage = 0;
				
			 	setResizable(false);
	            setSize(400, 150);
	            setLocationRelativeTo(null);
	            
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.setPreferredSize(new Dimension(400,150));
	            
	            JPanel center = new JPanel();
	            
	            WinCardL card = new WinCardL(this);
	            card.addComponent(center); 
	            panel.add(center, BorderLayout.CENTER);
   
	            JPanel west = new JPanel();

	            JLabel logo = new JLabel(new ImageIcon("Images/IconLarge.png"), JLabel.CENTER);
	            west.add(logo);         
	            panel.add(west, BorderLayout.WEST);
        	            
	            Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
	            setIconImage(icon);
	            
	            add(panel);
	            validate();
	            setVisible(useLanguage);
		
	}
	
	public boolean getUseLanguage() {
		return useLanguage;
	}


	public void setUseLanguage(boolean useLanguage) {
		Language.useLanguage = useLanguage;
	}


	public int getIndexLanguage() {
		return indexLanguage;
	}


	public void setIndexLanguage(int indexLanguage) {
		this.indexLanguage = indexLanguage;
	}


	
	// Odabir jezika
	private class WinCardL implements ItemListener {
		private JButton ok;
		private JButton cancel;
		private JButton da;
		private JButton prekini;
		private JPanel cards;
		private JFrame frame;
		
		public WinCardL(JFrame frame) {
			super();
			this.frame = frame;
			
		}
		public void addComponent(Container pane) {
			JPanel boxPane = new JPanel();
			boxPane.setLayout(new GridLayout(3,2,10,10));
			String boxItems[] = { "English", "Srpski"};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox cb = new JComboBox (boxItems);
			cb.setEditable(false);
			cb.addItemListener(this);
			boxPane.add(cb);
			
			MouseListenerClose close = new MouseListenerClose();
			
	        MouseListenerLanguage next = new MouseListenerLanguage(frame);
	        
			
	        JLabel labelS = new JLabel("   Molim vas unesite jezik.");
	        JLabel labelE = new JLabel("   Please select a language.");
	        
	        JPanel cardS = new JPanel();
	        cardS.setLayout(new GridLayout(3,2,10,10));
			cardS.add(labelS, BorderLayout.NORTH);
			
			JPanel cardE = new JPanel();
			cardE.setLayout(new GridLayout(3,2,10,10));
			cardE.add(labelE, BorderLayout.NORTH);
			
	        
			ok = new JButton("Ok");
			ok.addMouseListener(next);
			ActionListenerEnglish english = new ActionListenerEnglish();
			ok.addActionListener(english);
			
			cancel = new JButton("Cancel");
			cancel.addMouseListener(close);
			
			da = new JButton("Nastavi");
			da.addMouseListener(next);
			ActionListenerSerbian sebian = new ActionListenerSerbian();
			da.addActionListener(sebian);
			
			prekini = new JButton("Prekini");
			prekini.addMouseListener(close);
			
			JPanel card1 = new JPanel();
			cardE.add(labelE, BorderLayout.NORTH);
			card1.add(ok);
			card1.add(cancel);
			cardE.add(card1, BorderLayout.SOUTH);
			
			JPanel card2 = new JPanel();
			cardS.add(labelS, BorderLayout.NORTH);
			card2.add(da);
			card2.add(prekini);
			cardS.add(card2, BorderLayout.SOUTH);
			
			// Promena jezika svih elemenata
			cards = new JPanel(new CardLayout());
			cards.add(cardE, "English");
			cards.add(cardS, "Srpski");
			
			pane.add(boxPane, BorderLayout.PAGE_START);
			pane.add(cards, BorderLayout.CENTER);
			
		}
		// trenutno odabran jezik
		@Override
		public void itemStateChanged(ItemEvent event) {
			// TODO Auto-generated method stub
			
			CardLayout cl = (CardLayout)(cards.getLayout());
			String langChosen = (String)event.getItem();
			
	        cl.show(cards, langChosen);
	        
			
			
		}
		
	}
}