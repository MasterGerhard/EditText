package main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import command.CommandStore;
/**
 * Holds the JMenuBar and JPanel
 * also has a command store for undo/redo
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class EditTextFrame extends JFrame {
	
	private EditTextMenuBar menuBar;
	private EditTextPageModel textModel;
	private EditTextApplication application;
	private CommandStore cmdStore;
	
	
	public EditTextFrame(EditTextApplication theApplication){
		super();
		application = theApplication;
		
		this.addWindowListener(new EditTextWindowListener(application));
		
		 
		this.createComponents();
		
		
		this.setLayout(new GridBagLayout());
		EditTextToolBar tb = textModel.getToolBar();
		
		JScrollPane pageScroll = new JScrollPane(textModel.getPagePanel());
	    pageScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    pageScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    pageScroll.setBorder(new BevelBorder(BevelBorder.LOWERED));
	    

		this.setJMenuBar(menuBar);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		this.add(tb,c);
		c.fill = GridBagConstraints.BOTH;
		
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		this.add(pageScroll,c);
		
		pack();
		this.setVisible(true);
	}

	private void createComponents() {
		cmdStore = new CommandStore();
		textModel = new EditTextPageModel(cmdStore);
		menuBar = new EditTextMenuBar(this,cmdStore);
		
		
		
	}
	
	public EditTextApplication getApplication() {
		return application;
	}
	
	public EditTextPageModel getModel(){
		return textModel;
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
