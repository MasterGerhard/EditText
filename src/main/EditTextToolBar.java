package main;
import java.util.ArrayList;

import javax.swing.JToolBar;
import javax.swing.AbstractAction;

import command.CommandStore;

import buttons.EditTextButtonFactory;
import actions.FontAction;

@SuppressWarnings("serial")
public class EditTextToolBar extends JToolBar {


	private ArrayList<FontAction> fontActions;
	
	
	public EditTextToolBar(EditTextPageModel pagePanel, CommandStore cmds){
		super("ribbon");
		super.setFloatable(false);
		
		fontActions = new ArrayList<FontAction>();
		EditTextButtonFactory.addFunctionalButtonsTo(this, pagePanel,cmds);
		EditTextButtonFactory.addFontButtonsTo(this, pagePanel,cmds);
				
	}
	
	public void addFontAction(FontAction act){
		fontActions.add(act);
	}
	
	public ArrayList<FontAction> getFontActions(){
		return fontActions;
	}

}
