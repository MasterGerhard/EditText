package actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pages.OpenPages;
import main.EditTextPageModel;

public class OpenAction {

	
	public OpenAction(EditTextPageModel theModel) {

		OpenPages pages = theModel.getOpenPages();
		System.out.println(pages.size() + "pages");
		File fileToOpen = getOpenedFile();
		
		
		if(fileToOpen!=null){
			
			Scanner scan;
			try {
				scan = new Scanner(new FileReader(fileToOpen));
				String allText="";
				while(scan.hasNext()){
					allText = allText + scan.next() + " ";
					
				}
				String[] docText = allText.split("(@PAGE)\\d@\\s");
				
				for(int i = 1; i <docText.length;i++){
					
					if(i>pages.size()){
						theModel.addPage(docText[i]);
					}
					else{
						pages.get(i-1).setText(docText[i]);
					}
				}
				
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		else{
			
		}
	}
	
	private File getOpenedFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
		chooser.setDialogTitle("Open file");
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);

		if (result == chooser.APPROVE_OPTION) { 
			File fileToBeOpened = chooser.getSelectedFile();

			if(!chooser.getSelectedFile().getAbsolutePath().endsWith(".txt")){
				return null;
			}
			else {
				return fileToBeOpened;   
			}
			   
		} 
		else {
			return null;
		}
	}
}