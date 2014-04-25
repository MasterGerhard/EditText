package UI;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Creates the JMenuBar and sets up ActionListeners
 * @author SteveG
 *
 */

@SuppressWarnings("serial")
public class EditTextMenuBar extends JMenuBar {


	private EditTextApplication application;
	
	public EditTextMenuBar(EditTextApplication theApplication){
		super();
		application = theApplication;
		
		//Add menus
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help"); 

        this.add(file);
        this.add(edit);
        this.add(help);  
       
        // for file menu
        JMenuItem newWindow = new JMenuItem("New Window");
       	JMenuItem open = new JMenuItem("Open...");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        
        newWindow.addActionListener(new NewWindowListener(application));
        open.addActionListener(new OpenListener(application));
        save.addActionListener(new SaveListener(application));
        quit.addActionListener(new QuitListener(application));
        
        file.add(newWindow);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(quit);
        
        // for edit menu
        JMenuItem undo = new JMenuItem("Undo");
       	JMenuItem redo = new JMenuItem("Redo");
       	
       	redo.addActionListener(new RedoListener(application));
       	undo.addActionListener(new UndoListener(application));
       
       	edit.add(undo);
        edit.add(redo);
        
        // for help menu
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new AboutListener(application,about.getParent()));
        
        help.add(about);
	}
	
	public class NewWindowListener implements ActionListener {
		private EditTextApplication application;
		public NewWindowListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			application.createNewFrame();

		}

	}	
	public static class OpenListener implements ActionListener{
		private EditTextApplication application;
		
		public OpenListener(EditTextApplication theApplication){
			application = theApplication;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}	
	public class SaveListener implements ActionListener {
		private EditTextApplication application;
		public SaveListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}	
	
	public class QuitListener implements ActionListener {
		private EditTextApplication application;
		public QuitListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}
	
	public class UndoListener implements ActionListener {
		private EditTextApplication application;
		public UndoListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public class RedoListener implements ActionListener {
		private EditTextApplication application;
		public RedoListener(EditTextApplication theApplication){
			application = theApplication;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public class AboutListener implements ActionListener {
		private EditTextApplication application;
		private Container container;
		private String popUpMessage;
		public AboutListener(EditTextApplication theApplication, Container theContainer){
			application = theApplication;
			container = theContainer;
			popUpMessage = "EditText in java\n" 
					+"Version " + application.versionNumber + "\n"
					+"Developed by "+ application.creatorName +"\n"
					+"Last Updated " + application.lastUpdated;
					
					
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(
					container,popUpMessage,"EditText",JOptionPane.PLAIN_MESSAGE);

		}

	}
	
}
