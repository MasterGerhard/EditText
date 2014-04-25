package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;

/**
 * Fired off when font size box is changed
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class FontSizeAction extends AbstractAction {

	private OpenPages pages;
	
	public FontSizeAction(OpenPages pages){
		this.pages = pages;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		int selection = Integer.parseInt(((JComboBox)e.getSource()).getSelectedItem().toString());
		StyleConstants.setFontSize(doc.getAttrStyle(), selection);
		doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();
	}
}