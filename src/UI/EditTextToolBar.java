package UI;
import javax.swing.JToolBar;

import pages.OpenPages;

@SuppressWarnings("serial")
public class EditTextToolBar extends JToolBar {

	public EditTextToolBar(EditTextModel pagePanel){
		super("ribbon");
		super.setFloatable(false);
		EditTextButtonFactory.addFunctionalButtonsTo(this, pagePanel);
		EditTextButtonFactory.addFontButtonsTo(this, pagePanel);
				
	}

}
