package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;
/**
 * Fired off when Italic button is toggled on
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class ItalicsAction extends AbstractAction implements FontAction {
	
	private OpenPages pages;
	
	public ItalicsAction(OpenPages pages){
		this.pages = pages;
		enabled = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		enabled = ((JToggleButton)e.getSource()).isSelected();
		if(!pages.isEmpty()){
			doFontAction();
		}
	}
	
	public void doFontAction(){
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		StyleConstants.setItalic(doc.getAttrStyle(), enabled);
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();
		
		// set all pages to Italic
		for(int i = 0; i<pages.size();i++){
			JTextPane currentPage = pages.get(i);
			EditTextStyledDocument tempDoc = (EditTextStyledDocument) currentPage.getDocument();
			StyleConstants.setItalic(tempDoc.getAttrStyle(), enabled);	
		}	
	}
	
}