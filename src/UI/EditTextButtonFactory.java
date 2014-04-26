package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import actions.*;

/**
 * Responsible for creating toolbar buttons
 * @author SteveG
 *
 */
public class EditTextButtonFactory {
	
	public static void addFunctionalButtonsTo(EditTextToolBar tb, EditTextModel pagePanel){
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
		
		// Spell Check needs to be called on new pages if they are
		// added after spell check has been pressed
		// we pass the action onto add/remove page
		AbstractAction spellCheckAction = new SpellCheckAction(pagePanel,spellCheck);
		
		
		newPage.addActionListener(new addRemovePageListener(true,pagePanel,spellCheckAction));
		removePage.addActionListener(new addRemovePageListener(false,pagePanel,spellCheckAction));
		wordCount.addActionListener(new wordToolListener(new WordCountAction(pagePanel)));
		spellCheck.addActionListener(new wordToolListener(spellCheckAction));
		
		
		tb.add(newPage);
		tb.add(removePage);
		tb.add(wordCount);
		tb.add(spellCheck);
	}
	
	/**
	 * Adds bold, italics, underlined, font size, and font color buttons to 
	 * the given toolbar.
	 * @param tb
	 * @param pagePanel
	 */
	public static void addFontButtonsTo(EditTextToolBar tb, EditTextModel pagePanel){
		JToggleButton bold = new JToggleButton();
		JToggleButton italics = new JToggleButton();
		JToggleButton underlined = new JToggleButton();
		
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
				"lightGray",
				"darkGray"};
		JComboBox color = new JComboBox(textColors);
		
		setButtonIcon(bold,"bold");
		setButtonIcon(italics, "italics");
		setButtonIcon(underlined,"underlined");
		
		bold.setToolTipText("Bold");
		italics.setToolTipText("Italics");
		underlined.setToolTipText("Underlined");
		size.setToolTipText("Text Size");
		color.setToolTipText("Text Color");
		
		bold.addActionListener(new fontListener(new BoldAction(pagePanel.getOpenPages())));
		italics.addActionListener(new fontListener(new ItalicsAction(pagePanel.getOpenPages())));
		underlined.addActionListener(new fontListener(new UnderlinedAction(pagePanel.getOpenPages())));
		size.addActionListener(new fontListener(new FontSizeAction(pagePanel.getOpenPages())));
		color.addActionListener(new fontListener(new FontColorAction(pagePanel.getOpenPages())))
		;
		size.setSelectedIndex(11);
		color.setSelectedIndex(0);
		tb.add(bold);
		tb.add(italics);
		tb.add(underlined);
		tb.add(size);
		tb.add(color);
		
	}

	
	public static void setButtonIcon(AbstractButton button, String iconName){
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
	
	public static class addRemovePageListener implements ActionListener{
		private EditTextModel pagePanel;
		private boolean add;
		private AbstractAction spellCheck;
		/**
		 * Adds a page iff addPage is true.
		 * Removes a page otherwise.
		 * @param addPage
		 */
		public addRemovePageListener(boolean addPage, EditTextModel pagePanel,
				AbstractAction spellCheck){
			this.add = addPage;
			this.pagePanel = pagePanel;
			this.spellCheck = spellCheck;
		}
		public void actionPerformed(ActionEvent e) {
			if(add){
				pagePanel.addPage();
			}
			else{
				pagePanel.removePage();
			}
			spellCheck.actionPerformed(e);
		}
		
	}

	public static class wordToolListener implements ActionListener{
		private AbstractAction wordAction;
		public wordToolListener(AbstractAction a){
			wordAction = a;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			wordAction.actionPerformed(e);	
		}
	}

	public static class fontListener implements ActionListener {
		private AbstractAction fontAction;
		public fontListener(AbstractAction a){
			fontAction = a;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			fontAction.actionPerformed(e);	
		}
		
	}
}
