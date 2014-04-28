package command;
import java.util.ArrayList;

/**
 * For store history of command.
 */
public class CommandStore {
	ArrayList<EditTextCmd> listCommands;
	int indexCurCmd;
	
	public CommandStore() {
		listCommands = new ArrayList<EditTextCmd>();
		indexCurCmd = -1;
	}
	public void Execute(EditTextCmd cmd) {
		cmd.Execute();
		listCommands.add(cmd);
		indexCurCmd = listCommands.size()-1;
	}
	
	public void Undo() {
		
		if(indexCurCmd > -1){
			EditTextCmd theCommand = listCommands.get(indexCurCmd);
			indexCurCmd--;
			theCommand.UnExecute();
		}
		
	}
	
	public void Redo() {
		
		if(indexCurCmd < listCommands.size()-1){
			indexCurCmd++;
			EditTextCmd theCommand = listCommands.get(indexCurCmd);
			theCommand.Execute();
		}
	}

}
