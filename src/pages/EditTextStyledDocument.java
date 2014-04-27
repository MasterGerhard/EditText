package pages;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;

@SuppressWarnings("serial")
/**
 * Needed to allow font types to set and reset appropriately
 * @author SteveG
 *
 */
public class EditTextStyledDocument extends DefaultStyledDocument
{
    private  Style initialStyle;

    public EditTextStyledDocument() {
        super();
         initialStyle = this.addStyle("initial", null);
    }
    public Style getAttrStyle()
    {
        return initialStyle;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str, initialStyle); 

    }

}
