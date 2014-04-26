package UI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
/**
 * Holds the JMenuBar and JPanel
 * also has a command store for undo/redo
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class EditTextFrame extends JFrame {
	
	private EditTextMenuBar menuBar;
	private EditTextModel textModel;
	private EditTextApplication application;
	private CommandStore cmdStore;
	
	
	public EditTextFrame(EditTextApplication theApplication){
		super();
		application = theApplication;
		
		this.addWindowListener(new EditTextWindowListener(application));
		
		 
		this.createComponents();
		this.setJMenuBar(menuBar);
		
		this.setLayout(new BorderLayout());
		EditTextToolBar tb = textModel.getToolBar();
		tb.setMaximumSize(new Dimension(this.getWidth(),50));
		this.add(tb, BorderLayout.PAGE_START);
		JScrollPane pageScroll = new JScrollPane(textModel.getPagePanel());
		pageScroll.setPreferredSize(new Dimension(450,550));
	    pageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    pageScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(pageScroll, BorderLayout.AFTER_LAST_LINE);
		
		/*this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(textModel.getToolBar(),c);
		
	    JScrollPane pageScroll = new JScrollPane(textModel.getPagePanel());
	    
	    pageScroll.setPreferredSize(new Dimension(450,400));
	    pageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    pageScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
	    this.add(pageScroll, c);*/
		this.setMinimumSize(new Dimension(500,600));
		pack();
		this.setVisible(true);
	}

	private void createComponents() {
		menuBar = new EditTextMenuBar(application);
		textModel = new EditTextModel();
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
