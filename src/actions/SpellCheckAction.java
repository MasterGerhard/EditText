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
public class SpellCheckAction extends AbstractAction implements FontAction {

	private EditTextModel pagePanel;
	
	public SpellCheckAction(EditTextModel pagePanel){
		this.pagePanel = pagePanel;
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
		doFontAction();
		
		
	}

	@Override
	public void doFontAction() {
		if(enabled){
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
	
}
