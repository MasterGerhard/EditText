package pages;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;

import command.CommandStore;
import command.TextInsertCmd;
import command.TextRemoveCmd;

/**
 * Extended StyledDocument that integrates with the command pattern
 * for undo/redo functionality
 * @author SteveG
 *
 */
@SuppressWarnings("serial")
public class UndoableStyledDocument extends EditTextStyledDocument {
    private CommandStore commandStore;
    private JTextPane textPane;
    private boolean isUndoRedoOperation = false;
    
    public UndoableStyledDocument(CommandStore cmdStore, JTextPane pane) {
        super();
        this.commandStore = cmdStore;
        this.textPane = pane;
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // Only create command if this is a user action (not undo/redo)
        if (!isUndoRedoOperation && commandStore != null && str != null && !str.isEmpty()) {
            final String insertedText = str;
            final int insertOffset = offs;
            
            TextInsertCmd cmd = new TextInsertCmd(textPane, offs, str) {
                @Override
                public void Execute() {
                    isUndoRedoOperation = true;
                    try {
                        UndoableStyledDocument.super.insertString(insertOffset, insertedText, null);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    } finally {
                        isUndoRedoOperation = false;
                    }
                }
                
                @Override
                public void UnExecute() {
                    isUndoRedoOperation = true;
                    try {
                        UndoableStyledDocument.this.remove(insertOffset, insertedText.length());
                        textPane.setCaretPosition(insertOffset);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    } finally {
                        isUndoRedoOperation = false;
                    }
                }
            };
            
            // Execute the command (which will insert the text)
            commandStore.Execute(cmd);
        } else {
            // For undo/redo operations, just insert directly
            super.insertString(offs, str, a);
        }
    }
    
    @Override
    public void remove(int offs, int len) throws BadLocationException {
        // Only create command if this is a user action (not undo/redo)
        if (!isUndoRedoOperation && commandStore != null && len > 0) {
            // Store the text before removing
            final String removedText = getText(offs, len);
            final int removeOffset = offs;
            final int removeLength = len;
            
            TextRemoveCmd cmd = new TextRemoveCmd(textPane, offs, len) {
                @Override
                public void Execute() {
                    isUndoRedoOperation = true;
                    try {
                        UndoableStyledDocument.super.remove(removeOffset, removeLength);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    } finally {
                        isUndoRedoOperation = false;
                    }
                }
                
                @Override
                public void UnExecute() {
                    isUndoRedoOperation = true;
                    try {
                        UndoableStyledDocument.this.insertString(removeOffset, removedText, null);
                        textPane.setCaretPosition(removeOffset + removedText.length());
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    } finally {
                        isUndoRedoOperation = false;
                    }
                }
            };
            
            // Execute the command (which will remove the text)
            commandStore.Execute(cmd);
        } else {
            // For undo/redo operations, just remove directly
            super.remove(offs, len);
        }
    }
}

// Made with Bob
