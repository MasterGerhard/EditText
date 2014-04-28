package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JFileChooser;

import pages.OpenPages;
import main.EditTextPageModel;

public class SaveAction {
	

	
	public SaveAction(EditTextPageModel theModel){
		OpenPages pages = theModel.getOpenPages();
		
		
		File fileToSave = getSaveLocation();
		
		
		if(fileToSave!=null){
			Writer writer = null;
	
			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream(fileToSave), "utf-8"));
			    for(int i = 0 ; i<pages.size(); i++){
			    	writer.write("@PAGE"+(i+1)+"@"+System.getProperty( "line.separator" ));
			    	writer.write(pages.get(i).getText()+System.getProperty( "line.separator" ));
			    	
			    }
			    
			} catch (IOException ex) {
			  // report
			} finally {
			   try {writer.close();} catch (Exception ex) {}
			}
		}
	}
	
	private File getSaveLocation() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  
		chooser.setDialogTitle("Select Location");
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showSaveDialog(null);

		if (result == chooser.APPROVE_OPTION) { 
			   File fileToBeSaved = chooser.getSelectedFile();

			   if(!chooser.getSelectedFile().getAbsolutePath().endsWith(".txt")){
			       fileToBeSaved = new File(chooser.getSelectedFile() + ".txt");
			   }
			   return fileToBeSaved;
		   } else {
		      return null;
		   }
		}
}
