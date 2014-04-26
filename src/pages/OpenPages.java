package pages;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JTextPane;
/**
 * Wrapper class for all JTextPanes within a given frame.
 * Attaches focusListeners to the pages to get current
 * focused page.
 * @author SteveG
 *
 */
public class OpenPages {

	private ArrayList<JTextPane> pages;
	private int focusedPage;
	
	public OpenPages(){
		pages = new ArrayList<JTextPane>();
		focusedPage = 0;
	}
	
	/**
	 * Convenience method.
	 * Creates new JTextPane and adds to the Arraylist
	 * of pages
	 * @return
	 * JTextPane
	 */
	public JTextPane newPage(){
		JTextPane newPage = new JTextPane();
		newPage = this.add(newPage);
		return newPage;
	}
	
	public ArrayList<JTextPane> getPages(){
		return pages;
	}
	
	public JTextPane get(int i){
		return pages.get(i);
	}
	
	public JTextPane getFocusedPage(){
		return pages.get(focusedPage);
	}
	public JTextPane add(JTextPane newPage){
		
		newPage.addFocusListener(new pageFocusListener(this,pages.size()));
		pages.add(newPage);
		return newPage;
	}
	
	public JTextPane removePage(){
		JTextPane removedPage;
		
		if(pages.size() < 1){
			removedPage = null;
		}
		else{
			removedPage = (pages.remove(pages.size() - 1));
		}
		return removedPage;
	}
	
	public boolean isEmpty(){
		return pages.isEmpty();
	}
	
	public int size(){
		return pages.size();
	}
	
	public void setFocusedPage(int pageIndex){
		focusedPage = pageIndex;
	}
	
	public static class pageFocusListener implements FocusListener {
		int pageID;
		OpenPages pages;
		public pageFocusListener(OpenPages pages, int pageID){
			this.pageID = pageID;
			this.pages = pages;
		}
        @Override
        public void focusGained(FocusEvent e) {
            pages.setFocusedPage(pageID);
        }

        @Override
        public void focusLost(FocusEvent e) {}

    }
}
