package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;

/**
 * Fired off when color combo button is changed
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class FontColorAction extends AbstractAction implements FontAction{

	private OpenPages pages;
	private Color selectedColor;
	
	public FontColorAction(OpenPages pages){
		this.pages = pages;
		selectedColor = java.awt.Color.black;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selection = ((JComboBox)e.getSource()).getSelectedItem().toString();
		
		try {
		    Field field = Class.forName("java.awt.Color").getField(selection);
		    selectedColor = (Color)field.get(null);
		    
		} catch (Exception ex) {
		    selectedColor = null; // Not defined
		    System.out.println(ex.toString());
		}
	
		
		doFontAction();
		
	}
	
	public void doFontAction(){
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		StyleConstants.setForeground(doc.getAttrStyle(), selectedColor);
        doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		textPane.requestFocus();
		
		// set all pages to the color
		for(int i = 0; i<pages.size();i++){
			JTextPane currentPage = pages.get(i);
			EditTextStyledDocument tempDoc = (EditTextStyledDocument) currentPage.getDocument();
			StyleConstants.setForeground(tempDoc.getAttrStyle(), selectedColor);	
		}
		
	}
}