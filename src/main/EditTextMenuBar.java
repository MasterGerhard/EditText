package main;

import actions.OpenAction;
import actions.SaveAction;
import command.CommandStore;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
/**
 * Creates the JMenuBar and sets up ActionListeners
 * @author SteveG
 *
 */

@SuppressWarnings("serial")
public class EditTextMenuBar extends JMenuBar {
		
	public EditTextMenuBar(EditTextFrame theFrame, CommandStore cmdStore){
		super();
		
		//Add menus
        JMenu file = new JMenu("File");
      //  file.setMnemonic('F');
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help"); 

        this.add(file);
        this.add(edit);
        this.add(help);  
       
        // for file menu
        JMenuItem newWindow = new JMenuItem("New Window");
        newWindow.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.META_MASK));
       	JMenuItem open = new JMenuItem("Open...");
       	open.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.META_MASK));
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.META_MASK));
        JMenuItem quit = new JMenuItem("Quit");
        quit.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.META_MASK));
        
        newWindow.addActionListener(new NewWindowListener(theFrame));
        open.addActionListener(new OpenListener(theFrame));
        save.addActionListener(new SaveListener(theFrame));
        quit.addActionListener(new QuitListener(theFrame));
        
        file.add(newWindow);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(quit);
        
        // for edit menu
        JMenuItem undo = new JMenuItem("Undo");
       	JMenuItem redo = new JMenuItem("Redo");
       	
       	redo.addActionListener(new RedoListener(theFrame, cmdStore));
       	undo.addActionListener(new UndoListener(theFrame, cmdStore));
       
       	edit.add(undo);
        edit.add(redo);
        
        // for help menu
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new AboutListener(theFrame));
        
        help.add(about);
	}
	
	public class NewWindowListener implements ActionListener {
		private EditTextFrame theFrame;
		public NewWindowListener(EditTextFrame theFrame){
			this.theFrame = theFrame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			theFrame.getApplication().createNewFrame();

		}

	}	
	public static class OpenListener implements ActionListener{
		private EditTextPageModel theModel;
		
		public OpenListener(EditTextFrame theFrame){
			theModel = theFrame.getModel();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			OpenAction open = new OpenAction(theModel);

		}
		
	}	
	public class SaveListener implements ActionListener {
		private EditTextPageModel theModel;
		
		public SaveListener(EditTextFrame theFrame){
			theModel = theFrame.getModel();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			SaveAction save = new SaveAction(theModel);

		}

	}	
	
	public class QuitListener implements ActionListener {
		private EditTextFrame theFrame;
		public QuitListener(EditTextFrame theFrame){
			this.theFrame = theFrame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}
	
	public class UndoListener implements ActionListener {
		private EditTextFrame theFrame;
		private CommandStore cmdStore;
		public UndoListener(EditTextFrame theFrame, CommandStore cmds){
			this.theFrame = theFrame;
			cmdStore = cmds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cmdStore.Undo();
			System.out.println("Undo");

		}

	}
	public class RedoListener implements ActionListener {
		private EditTextFrame theFrame;
		private CommandStore cmdStore;
		public RedoListener(EditTextFrame theFrame, CommandStore cmds){
			this.theFrame = theFrame;
			cmdStore = cmds;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cmdStore.Redo();
			System.out.println("Redo");
		}

	}
	public class AboutListener implements ActionListener {
		private EditTextApplication application;
		private String popUpMessage;
		public AboutListener(EditTextFrame theFrame){
			application = theFrame.getApplication();
			popUpMessage = "EditText in java\n" 
					+"Version " + application.versionNumber + "\n"
					+"Developed by "+ application.creatorName +"\n"
					+"Last Updated " + application.lastUpdated;
					
					
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(
					new JFrame(),popUpMessage,"EditText",JOptionPane.PLAIN_MESSAGE);

		}

	}
	
}
