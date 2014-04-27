package UI;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.StyledDocument;

import pages.EditTextStyledDocument;
import pages.OpenPages;

/**
 * Contains the JTextPane and JToolBar
 * @author SteveG
 * 
 */

@SuppressWarnings("serial")
public class EditTextPageModel {

	private EditTextToolBar toolBar;
	private OpenPages pages;
	private JPanel pagePanel;
	
	public EditTextPageModel(){
		super();
		createPageComponents();
		createToolBars();
	}
	
	/**
	 * add one page and initialise components. 
	 */
	public void createPageComponents(){
		
		pages = new OpenPages();
		pagePanel = new JPanel();
		pagePanel.setLayout(new GridBagLayout());
		
		this.addPage();		
	}
	
	public void createToolBars(){
		toolBar = new EditTextToolBar(this);
	}
	
	public void addPage(){
		JTextPane newPage = pages.newPage();
		StyledDocument doc = new EditTextStyledDocument();
	    newPage.setDocument(doc);
		newPage.setFont(new Font("Myraid", Font.PLAIN, 12));
		newPage.setPreferredSize(new Dimension(400,400));
		newPage.setBorder(new BevelBorder(BevelBorder.RAISED));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = pages.size();
		c.insets = new Insets(10,0,10,0);
		pagePanel.add(newPage,c);
		pagePanel.setSize(new Dimension(450,500*pages.size()));
		pagePanel.revalidate();
	}
	
	public void removePage(){
		if(pages.size() > 0){
			JTextPane pageToRemove = pages.removePage();
			pagePanel.remove(pageToRemove);
		}
		pagePanel.setSize(new Dimension(450,500*pages.size()));
		pagePanel.revalidate();
	}
	
	public OpenPages getOpenPages(){
		return pages;
	}
	public JPanel getPagePanel(){
		return pagePanel;
	}
	public EditTextToolBar getToolBar(){
		return toolBar;
	}
}
