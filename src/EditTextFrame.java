import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
/**
 * Holds the JMenuBar and JPanel
 * also has a command store for undo/redo
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class EditTextFrame extends JFrame {
	
	private EditTextMenuBar menuBar;
	private EditTextPanel textPanel;
	private EditTextApplication application;
	private CommandStore cmdStore;
	
	
	public EditTextFrame(EditTextApplication theApplication){
		super();
		application = theApplication;
		
		this.addWindowListener(new EditTextWindowListener(application));
		
		 
		this.createComponents();
		this.setJMenuBar(menuBar);
	    this.add(textPanel, BorderLayout.NORTH);
		this.setSize(new Dimension(500,400));
		this.setVisible(true);
	}

	private void createComponents() {
		menuBar = new EditTextMenuBar(application);
		textPanel = new EditTextPanel();
		cmdStore = new CommandStore();
		
	}
	
	
	public static class EditTextWindowListener implements WindowListener{
		private EditTextApplication application;
		
		public EditTextWindowListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void windowOpened(WindowEvent e) {
			application.windowOpened();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			application.windowClosed();	
		}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
		
	}
}
