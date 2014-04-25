import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
/**
 * Contains the JTextPane and JToolBar
 * @author SteveG
 * 
 *
 */

@SuppressWarnings("serial")
public class EditTextPanel extends JPanel {

	private JTextPane textPane;
	private EditTextToolBar toolBar;
	
	public EditTextPanel(){
		createTextPane();
		createToolBar();
		//this.setLayout(new FlowLayout(FlowLayout.));
		this.add(toolBar,BorderLayout.PAGE_START);
		this.add(textPane, BorderLayout.SOUTH);
		
	}
	
	public void createTextPane(){
		textPane = new JTextPane();
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPane.setText("one two three four five six seven eight nine ten");
		/*StyledDocument doc = new DefaultStyledDocument();
	      textPane.setDocument(doc);*/
		textPane.setPreferredSize(new Dimension(400,400));
		
	}
	
	public void createToolBar(){
		toolBar = new EditTextToolBar();
	}
}
