package main;
/**
 * Stores application attributes.
 * Quits everything when all windows closed
 * 
 * @author SteveG
 *
 */
public class EditTextApplication {

	private int numWindows;
	public String creatorName;
	public String versionNumber;
	public String lastUpdated;
	
	public EditTextApplication(){
		numWindows = 0;
	}
	
	public void createdBy(String me){
		creatorName = me;
	}
	
	public void versionNumber(String version){
		versionNumber = version;
	}
	
	public void lastUpdated(String dateLastUpdate){
		lastUpdated = dateLastUpdate;
	}
	
	public void createNewFrame(){
		EditTextFrame newFrame = new EditTextFrame(this);
	}
	
	public void windowOpened(){
		numWindows++;
	}
	public void windowClosed(){
		numWindows--;
		if(numWindows == 0){
			System.exit(0);
		}
	}
	
	public void launch(){
		createNewFrame();
	}
	
	
}
