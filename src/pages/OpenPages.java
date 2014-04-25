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
	private static int focusedPage;
	private int numPages;
	
	public OpenPages(){
		pages = new ArrayList<JTextPane>();
		focusedPage = 0;
		numPages = 0;
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
		this.add(newPage);
		return newPage;
	}
	
	public JTextPane get(int i){
		return pages.get(i);
	}
	public ArrayList<JTextPane> getPages(){
		return pages;
	}
	public JTextPane getFocusedPage(){
		return pages.get(focusedPage);
	}
	public JTextPane add(JTextPane newPage){
		
		newPage.addFocusListener(new pageFocusListener(this,numPages));
		numPages++;
		pages.add(newPage);
		return newPage;
	}
	
	public JTextPane removePage(){
		numPages--;
		return (pages.remove(pages.size() - 1));
	}
	
	public boolean isEmpty(){
		return pages.isEmpty();
	}
	
	public int size(){
		return numPages;
	}
	
	public void setFocusedPage(int pageIndex){
		focusedPage = pageIndex;
		System.out.println(pageIndex);
	}
	
	public static class pageFocusListener implements FocusListener {
		int pageNum;
		OpenPages pages;
		public pageFocusListener(OpenPages pages, int pageNum){
			this.pageNum = pageNum;
			this.pages = pages;
		}
        @Override
        public void focusGained(FocusEvent e) {
            pages.setFocusedPage(pageNum);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }

    }
}
