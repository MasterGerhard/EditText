package actions;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import pages.OpenPages;


@SuppressWarnings("serial")
public class BoldAction extends AbstractAction {

	private OpenPages pages;
	
	public BoldAction(OpenPages pages){
		this.pages = pages;
	}
	public void actionPerformed(ActionEvent e) {
		JTextPane textPane = pages.getFocusedPage();
		Font fontChoice = new Font(textPane.getFont().getFamily(), Font.BOLD,textPane.getFont().getSize());
		MutableAttributeSet attrs = textPane.getInputAttributes();
				
		StyleConstants.setBold(attrs, (fontChoice.getStyle() == Font.BOLD));
				
		StyledDocument doc = textPane.getStyledDocument();
		doc.setCharacterAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), attrs, false);
		
	}
		
		
}
