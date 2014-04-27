package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTextPane;

import pages.OpenPages;
import JOrtho.com.inet.jortho.SpellChecker;
import JOrtho.com.inet.jortho.FileUserDictionary;
import UI.EditTextPageModel;

/**
 * Spell Checking functionality toggle
 * implemented using JORtho
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class SpellCheckAction extends AbstractAction implements FontAction {

	private OpenPages pages;
	
	public SpellCheckAction(OpenPages pages){
		this.pages = pages;
		enabled = false;
		// Create user dictionary in the current working directory of your application
		SpellChecker.setUserDictionaryProvider( new FileUserDictionary() );
			        
		// Load the configuration from the file dictionaries.cnf and 
		// use the current locale or the first language as default (English)
		SpellChecker.registerDictionaries( null, null );
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		enabled = !enabled;
		if(!pages.isEmpty()){
			doFontAction();
		}
		
		
	}

	@Override
	public void doFontAction() {
		if(enabled){
			
			for(int i = 0; i<pages.size();i++){
				JTextPane currentPage = pages.get(i);
				SpellChecker.register(currentPage);
			}	
		}
		else{
			for(int i = 0; i<pages.size();i++){
				JTextPane currentPage = pages.get(i);
				SpellChecker.unregister(currentPage);
			}	
		}
		
	}
	
}
