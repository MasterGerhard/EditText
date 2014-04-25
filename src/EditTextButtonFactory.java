import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Responsible for creating toolbar buttons
 * @author SteveG
 *
 */
public class EditTextButtonFactory {

	protected JButton makeNavigationButton(String imageName,
	           String toolTipText,
	            String altText) {
	
	
	//Create and initialize the button.
		JButton button = new JButton();
	button.setToolTipText(toolTipText);
	
	
	return button;
	}
	
	public static void addFontButtonsTo(EditTextToolBar tb){
		JButton bold = new JButton();
		JButton italics = new JButton();
		JButton underlined = new JButton();
		
		String[] fontSizes = new String[32];
		fontSizes[0] = "1";
		for(int i = 2; i < 40; i++){
			fontSizes[i-1] = String.valueOf(i);
		}
		JComboBox size = new JComboBox(fontSizes);
		
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
		
		bold.setToolTipText("Bold");
		italics.setToolTipText("Italics");
		underlined.setToolTipText("Underlined");
		size.setToolTipText("Text Size");
		color.setToolTipText("Text Color");
		
		size.setSelectedIndex(11);
		color.setSelectedIndex(0);
	}
	
	public static ImageIcon getImage(String imageName){
		ImageIcon theImage;
		//Look for the image.
		String imgLocation = "images/"
		+ imageName
		+ ".png";
		URL imageURL = EditTextToolBar.class.getResource(imgLocation);
		if (imageURL != null) {		//image found
			theImage = new ImageIcon(imageURL, imageName);
		} 
		else {		//no image found
			theImage = null;
			System.err.println("Resource not found: " + imgLocation);
		}
		return theImage;
	}
	
}
