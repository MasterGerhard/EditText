package command;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 * Command for text removal operations
 * Supports undo/redo functionality
 */
public class TextRemoveCmd implements EditTextCmd {
    private JTextPane textPane;
    private int offset;
    private int length;
    private String removedText;
    private boolean executed;
    
    public TextRemoveCmd(JTextPane textPane, int offset, int length) {
        this.textPane = textPane;
        this.offset = offset;
        this.length = length;
        this.executed = false;
        
        // Store the text that will be removed
        try {
            StyledDocument doc = textPane.getStyledDocument();
            this.removedText = doc.getText(offset, length);
        } catch (BadLocationException e) {
            this.removedText = "";
            e.printStackTrace();
        }
    }
    
    @Override
    public void Execute() {
        if (!executed) {
            try {
                StyledDocument doc = textPane.getStyledDocument();
                doc.remove(offset, length);
                executed = true;
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void UnExecute() {
        if (executed) {
            try {
                StyledDocument doc = textPane.getStyledDocument();
                doc.insertString(offset, removedText, null);
                executed = false;
                textPane.setCaretPosition(offset + removedText.length());
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}

// Made with Bob
