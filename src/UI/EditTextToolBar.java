package UI;
import java.util.ArrayList;

import javax.swing.JToolBar;
import javax.swing.AbstractAction;

import actions.FontAction;

@SuppressWarnings("serial")
public class EditTextToolBar extends JToolBar {


	private ArrayList<FontAction> fontActions;
	
	public EditTextToolBar(EditTextModel pagePanel){
		super("ribbon");
		super.setFloatable(false);
		fontActions = new ArrayList<FontAction>();
		EditTextButtonFactory.addFunctionalButtonsTo(this, pagePanel);
		EditTextButtonFactory.addFontButtonsTo(this, pagePanel);
				
	}
	
	public void addFontAction(FontAction act){
		fontActions.add(act);
	}
	
	public ArrayList<FontAction> getFontActions(){
		return fontActions;
	}

}
