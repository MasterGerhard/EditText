package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;
/**
 * Fired off when underline button is toggled on
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class UnderlinedAction extends AbstractAction {

	private OpenPages pages;
	
	public UnderlinedAction(OpenPages pages){
		this.pages = pages;
	}
	public void actionPerformed(ActionEvent e) {
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		StyleConstants.setUnderline(doc.getAttrStyle(), ((JToggleButton)e.getSource()).isSelected());
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();	
	}
		
		
}