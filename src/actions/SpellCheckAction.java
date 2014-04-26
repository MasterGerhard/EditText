package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTextPane;

import JOrtho.com.inet.jortho.SpellChecker;
import JOrtho.com.inet.jortho.FileUserDictionary;
import UI.EditTextModel;

/**
 * Spell Checking functionality toggle
 * implemented using JORtho
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class SpellCheckAction extends AbstractAction {

	private EditTextModel pagePanel;
	private boolean isEnabled=false;
	private JButton source;
	
	public SpellCheckAction(EditTextModel pagePanel, JButton src){
		this.pagePanel = pagePanel;
		source = src;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton)e.getSource()) == source){
			isEnabled = !isEnabled;
		}
		// Create user dictionary in the current working directory of your application
		SpellChecker.setUserDictionaryProvider( new FileUserDictionary() );
			        
		// Load the configuration from the file dictionaries.cnf and 
		// use the current locale or the first language as default (English)
		SpellChecker.registerDictionaries( null, null );
				
		// enable/disable the spell checking on all pages
		if(isEnabled){
			ArrayList<JTextPane> allPages = pagePanel.getOpenPages().getPages();
			for(int i = 0; i<allPages.size();i++){
				JTextPane currentPage = allPages.get(i);
				SpellChecker.register(currentPage);
			}	
		}
		else{
			ArrayList<JTextPane> allPages = pagePanel.getOpenPages().getPages();
			for(int i = 0; i<allPages.size();i++){
				JTextPane currentPage = allPages.get(i);
				SpellChecker.unregister(currentPage);
			}	
		}
		
	}
	
	public boolean isEnabled(){ return isEnabled; }
	
}
