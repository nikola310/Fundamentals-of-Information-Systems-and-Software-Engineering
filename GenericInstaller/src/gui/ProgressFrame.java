package gui;

import gui.editor.Editor;
import gui.preview.PanelPreview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import net.miginfocom.swing.MigLayout;
import controller.installation.InstallListener;
import controller.installation.NextProgressListener;

@SuppressWarnings("serial")
public class ProgressFrame extends JFrame implements ActionListener,
		PropertyChangeListener {

	private JProgressBar bar;
	private Task task;
	private JButton install;
	private JButton next;

	public ProgressFrame(String installDir) {

		super();
		setSize(new Dimension(600, 150));
		setLayout(new MigLayout());
		setLocationRelativeTo(null);
		PanelPreview.setNewIcon(this);
		install = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Install"));
		InstallListener installL = new InstallListener(installDir);
		install.addActionListener(installL);
		install.addActionListener(this);
		next = new JButton(Editor.getInstance().getResourceBundle()
				.getString("Next"));
		NextProgressListener nextL = new NextProgressListener(this, installDir);
		next.addActionListener(nextL);
		next.setEnabled(false);
		bar = new JProgressBar(0, 100);
		bar.setValue(0);
		bar.setStringPainted(true);

		JPanel textpanel = new JPanel();
		JLabel message = new JLabel();
		message.setSize(new Dimension(450, 180));
		message.setText(Editor.getInstance().getResourceBundle()
				.getString("PlsWait"));
		textpanel.setPreferredSize(new Dimension(580, 200));
		textpanel.add(message, BorderLayout.CENTER);
		JPanel buttons = new JPanel();
		buttons.setSize(new Dimension(580, 50));
		buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttons.add(install);
		buttons.add(next);

		add(textpanel, "wrap");
		add(bar, "growx, growy, wrap");
		add(buttons);
		setVisible(true);
	}

	class Task extends SwingWorker<Void, Void> {
		protected Void doInBackground() throws Exception {
			Random random = new Random();
			int progress = 0;
			setProgress(0);
			while (progress < 100) {
				try {
					Thread.sleep(random.nextInt(1000));

				} catch (InterruptedException ignore) {
				}
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
			next.setEnabled(true);
			return null;
		}
	}

	public void actionPerformed(ActionEvent e) {
		install.setEnabled(false);
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			bar.setValue(progress);
		}
	}
}
