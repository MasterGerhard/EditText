package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;

import Style.EditTextStyledDocument;
import pages.OpenPages;

/**
 * Fired off when color combo button is changed
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class FontColorAction extends AbstractAction {

	private OpenPages pages;
	
	public FontColorAction(OpenPages pages){
		this.pages = pages;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextPane textPane = pages.getFocusedPage();
		EditTextStyledDocument doc = (EditTextStyledDocument) textPane.getDocument();
		String selection = ((JComboBox)e.getSource()).getSelectedItem().toString();
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(selection);
		    color = (Color)field.get(null);
		    StyleConstants.setForeground(doc.getAttrStyle(), color);
		    doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), doc.getAttrStyle(), false);
		    textPane.requestFocus();
		} catch (Exception ex) {
		    color = null; // Not defined
		    System.out.println(ex.toString());
		}
		
		
		
	}
}