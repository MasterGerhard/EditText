import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class EditTextToolBar extends JToolBar {

	public EditTextToolBar(){
		super("ribbon");
		EditTextButtonFactory.addFontButtonsTo(this);
				
	}

}
