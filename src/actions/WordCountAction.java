package actions;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import UI.EditText;
import UI.EditTextPageModel;
import pages.OpenPages;
/**
 * Displays a wordcount
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class WordCountAction extends AbstractAction {

	private OpenPages pages;
	public WordCountAction(OpenPages pages){
		this.pages = pages;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int numPages = pages.size();
		String pageNumMessage;
		if(numPages > 1){
			pageNumMessage = numPages + " pages.";
		}
		else{
			pageNumMessage = numPages + " page.";
		}
		
		String allWords = "";
		
		for(int i = 0; i < pages.size(); i++){
			JTextPane currentPage = pages.get(i) ;
			String currentPageText = currentPage.getText();
			allWords = allWords + " " + currentPageText;
		}
		
		String[] pageWords = allWords.split("\\W+");
		int numWords = pageWords.length-1;
		String popUpMessage;
		
		popUpMessage = "No words typed on " + pageNumMessage;
		
		if(numWords == 1){
			popUpMessage = "Only 1 word on " + pageNumMessage;
		}
		else if(numWords > 1){
			popUpMessage = numWords + " words on " + pageNumMessage;
		}
		String imgLocation = "images/"
				+ "wordCount"
				+ ".png";
		URL imageURL = EditText.class.getResource(imgLocation);
		if (imageURL != null) {		//image found
			ImageIcon icon = new ImageIcon(imageURL, "WordCount");
			JOptionPane.showMessageDialog(
				new JFrame(),popUpMessage,"Word Count",JOptionPane.PLAIN_MESSAGE,icon);
		}
		else{
			JOptionPane.showInternalMessageDialog(
				new JFrame(),popUpMessage,"Word Count",JOptionPane.PLAIN_MESSAGE);
		}
	}

}
