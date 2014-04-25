import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import pages.OpenPages;
import actions.BoldAction;

/**
 * Responsible for creating toolbar buttons
 * @author SteveG
 *
 */
public class EditTextButtonFactory {
	
	public static void addFunctionalButtonsTo(EditTextToolBar tb){
		JButton newPage = new JButton();
		JButton removePage = new JButton();
		JButton wordCount = new JButton();
		JButton spellCheck = new JButton();
		
		setButtonIcon(newPage,"newPage");
		setButtonIcon(removePage, "removePage");
		setButtonIcon(wordCount,"wordCount");
		setButtonIcon(spellCheck, "spellCheck");
		
		newPage.setToolTipText("Add a page");
		removePage.setToolTipText("Remove a page");
		wordCount.setToolTipText("Get Word Count");
		spellCheck.setToolTipText("Toggle Spell Check");
		
		tb.add(newPage);
		tb.add(removePage);
		tb.add(wordCount);
		tb.add(spellCheck);
	}
	
	public static void addFontButtonsTo(EditTextToolBar tb, OpenPages pages){
		JButton bold = new JButton();
		JButton italics = new JButton();
		JButton underlined = new JButton();
		
		String[] fontSizes = new String[40];
		fontSizes[0] = "1";
		for(int i = 2; i <= 40; i++){
			fontSizes[i-1] = String.valueOf(i);
		}
		JComboBox size = new JComboBox(fontSizes);
		//TODO color chooser
		String[] textColors = {"black",
				"red",
				"blue",
				"orange",
				"yellow",
				"green",
				"pink",
				"magenta",
				"white",
				"gray",
				"light gray",
				"dark gray"};
		JComboBox color = new JComboBox(textColors);
		
		setButtonIcon(bold,"bold");
		setButtonIcon(italics, "italics");
		setButtonIcon(underlined,"underlined");
		
		bold.setToolTipText("Bold");
		italics.setToolTipText("Italics");
		underlined.setToolTipText("Underlined");
		size.setToolTipText("Text Size");
		color.setToolTipText("Text Color");
		
		bold.addActionListener(new fontListener(new BoldAction(pages)));
		size.setSelectedIndex(11);
		color.setSelectedIndex(0);
		tb.add(bold);
		tb.add(italics);
		tb.add(underlined);
		tb.add(size);
		tb.add(color);
		
	}
	
	public static void setButtonIcon(JButton button, String iconName){
		//Look for the image
		String imgLocation = "images/"
		+ iconName
		+ ".png";
		URL imageURL = EditTextToolBar.class.getResource(imgLocation);
		if (imageURL != null) {		//image found
			button.setIcon(new ImageIcon(imageURL, iconName));
		} 
		else {		//no image found
			button.setText(iconName);
			System.err.println("Resource not found: " + imgLocation);
		}
	}
	
	// Action Listeners
	
	public static class fontListener implements ActionListener {
		BoldAction fontAction;
		public fontListener(BoldAction f){
			fontAction = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			fontAction.actionPerformed(e);
			
		}
		
	}
}
