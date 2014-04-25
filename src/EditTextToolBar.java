import javax.swing.JTextPane;
import javax.swing.JToolBar;

import pages.OpenPages;

@SuppressWarnings("serial")
public class EditTextToolBar extends JToolBar {

	public EditTextToolBar(OpenPages pages){
		super("ribbon");
		EditTextButtonFactory.addFunctionalButtonsTo(this);
		EditTextButtonFactory.addFontButtonsTo(this, pages);
				
	}

}
