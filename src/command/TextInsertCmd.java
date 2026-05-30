package command;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 * Command for text insertion operations
 * Supports undo/redo functionality
 */
public class TextInsertCmd implements EditTextCmd {
    private JTextPane textPane;
    private int offset;
    private String insertedText;
    private boolean executed;
    
    public TextInsertCmd(JTextPane textPane, int offset, String text) {
        this.textPane = textPane;
        this.offset = offset;
        this.insertedText = text;
        this.executed = false;
    }
    
    @Override
    public void Execute() {
        if (!executed) {
            try {
                StyledDocument doc = textPane.getStyledDocument();
                doc.insertString(offset, insertedText, null);
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
                doc.remove(offset, insertedText.length());
                executed = false;
                textPane.setCaretPosition(offset);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}

// Made with Bob
