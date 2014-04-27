package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

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
		AbstractAction spellCheckAction = new SpellCheckAction(pagePanel.getOpenPages());
		tb.addFontAction((FontAction)spellCheckAction);
		ArrayList<FontAction> fontActions = tb.getFontActions();
		
		newPage.addActionListener(new addRemovePageListener(true,pagePanel,fontActions));
		removePage.addActionListener(new addRemovePageListener(false,pagePanel,fontActions));
		wordCount.addActionListener(new wordToolListener(new WordCountAction(pagePanel.getOpenPages())));
		spellCheck.addActionListener(new wordToolListener(spellCheckAction));
		
		
		tb.add(newPage);
		tb.add(removePage);
		tb.addSeparator();
		tb.add(wordCount);
		tb.add(spellCheck);
		tb.addSeparator();
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
		
		AbstractAction boldAction = new BoldAction(pagePanel.getOpenPages());
		AbstractAction italicsAction = new ItalicsAction(pagePanel.getOpenPages());
		AbstractAction underlinedAction = new UnderlinedAction(pagePanel.getOpenPages());
		AbstractAction sizeAction = new FontSizeAction(pagePanel.getOpenPages());
		AbstractAction colorAction = new FontColorAction(pagePanel.getOpenPages());
		
		tb.addFontAction((FontAction)boldAction);
		tb.addFontAction((FontAction)italicsAction);
		tb.addFontAction((FontAction)underlinedAction);
		tb.addFontAction((FontAction)sizeAction);
		tb.addFontAction((FontAction)colorAction);
		
		
		bold.addActionListener(new fontListener(boldAction));
		italics.addActionListener(new fontListener(italicsAction));
		underlined.addActionListener(new fontListener(underlinedAction));
		size.addActionListener(new fontListener(sizeAction));
		color.addActionListener(new fontListener(colorAction));
		
		size.setSelectedIndex(11);
		color.setSelectedIndex(0);
		tb.add(bold);
		tb.add(italics);
		tb.add(underlined);
		tb.addSeparator();
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
		private ArrayList<FontAction> fontActions;
		/**
		 * Adds a page iff addPage is true.
		 * Removes a page otherwise.
		 * @param addPage
		 */
		public addRemovePageListener(boolean addPage, EditTextModel pagePanel,
				ArrayList<FontAction> actions){
			this.add = addPage;
			this.pagePanel = pagePanel;
			fontActions = actions;
		}
		public void actionPerformed(ActionEvent e) {
			if(add){
				pagePanel.addPage();
				setNewPageAttributes(e);
			}
			else{
				pagePanel.removePage();
			}
			
		}
		// if a new page is added, set its attributes
		// to match the current selections
		public void setNewPageAttributes(ActionEvent e) {
			for(int i = 0; i < fontActions.size();i++){
				FontAction tempAct = fontActions.get(i);
				if(tempAct.isEnabled()){
					tempAct.doFontAction();
				}
			}
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
