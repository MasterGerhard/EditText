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
public class FontSizeAction extends AbstractAction implements FontAction{

	private OpenPages pages;
	private int selectedSize;
	
	public FontSizeAction(OpenPages pages){
		this.pages = pages;
		selectedSize = 12;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		selectedSize = Integer.parseInt(((JComboBox)e.getSource()).getSelectedItem().toString());
		if(!pages.isEmpty()){
			doFontAction();
		}
		
	}

	@Override
	public void doFontAction() {
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		StyleConstants.setFontSize(doc.getAttrStyle(), selectedSize);
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();
		
		// set all pages to the color
		for(int i = 0; i<pages.size();i++){
			JTextPane currentPage = pages.get(i);
			EditTextStyledDocument tempDoc = (EditTextStyledDocument) currentPage.getDocument();
			StyleConstants.setFontSize(tempDoc.getAttrStyle(), selectedSize);	
		}
		
	}
}