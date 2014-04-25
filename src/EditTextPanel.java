import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import pages.OpenPages;

/**
 * Contains the JTextPane and JToolBar
 * @author SteveG
 * 
 */

@SuppressWarnings("serial")
public class EditTextPanel extends JPanel {

	private EditTextToolBar toolBar;
	private OpenPages pages;
	
	public EditTextPanel(){
		this.setLayout(new GridBagLayout());
		createComponents();
		addPage();
		//addPage();
	}
	
	/**
	 * Initialise all components and add one page
	 */
	public void createComponents(){
		// Holds all the pages
		pages = new OpenPages();
		toolBar = new EditTextToolBar(pages);
		JTextPane firstPage = pages.newPage();
	
		firstPage.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		firstPage.setText("one two three four five six seven eight nine ten");
		/*StyledDocument doc = new DefaultStyledDocument();
	      textPane.setDocument(doc);*/
		firstPage.setPreferredSize(new Dimension(400,400));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(toolBar,c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		this.add(firstPage,c);//, BorderLayout.SOUTH);
		
		
	}
	
	public void addPage(){
		JTextPane newPage = pages.newPage();
		newPage.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		newPage.setText("one two three four five six seven eight nine ten");
		newPage.setPreferredSize(new Dimension(400,400));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = pages.size()+1;
		c.insets = new Insets(10,10,10,10);
		this.add(newPage,c);//, BorderLayout.SOUTH);
		
	}
	
	public void removePage(){
		
	}
	
	public void createToolBar(){
		
	}
}
