package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;
/**
 * Fired off when bold button is toggled on
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class BoldAction extends AbstractAction {

	private OpenPages pages;
	
	public BoldAction(OpenPages pages){
		this.pages = pages;
	}
	public void actionPerformed(ActionEvent e) {
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		StyleConstants.setBold(doc.getAttrStyle(), ((JToggleButton)e.getSource()).isSelected());
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();
	}		
}