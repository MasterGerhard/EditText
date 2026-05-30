# EditText - Distribution Package

**Version:** 1.0  
**Author:** Steven Gerhard  
**Java Application:** Text Editor with Formatting and Spell Check

---

## What's Included

This distribution package contains:
- `EditText.jar` - The executable application (double-click to run)
- `run-edittext.sh` - Launcher script for Linux/Mac
- `run-edittext.bat` - Launcher script for Windows
- `DISTRIBUTION_README.md` - This file

---

## System Requirements

- **Java Runtime Environment (JRE) 8 or higher**
- **Operating System:** Windows, macOS, or Linux
- **Memory:** Minimum 256 MB RAM

---

## Installation

### Quick Start (All Platforms)

1. **Ensure Java is installed:**
   - Open a terminal/command prompt
   - Type: `java -version`
   - If Java is not installed, download it from: https://www.java.com/

2. **Run the application:**
   - **Windows:** Double-click `EditText.jar` or run `run-edittext.bat`
   - **Mac/Linux:** Double-click `EditText.jar` or run `./run-edittext.sh`

### Alternative: Command Line

```bash
java -jar EditText.jar
```

---

## Features

EditText is a feature-rich text editor with the following capabilities:

### Text Editing
- **Multiple Pages:** Create and manage multiple text pages within one window
- **Rich Text Formatting:**
  - Bold, Italic, Underline
  - Font selection and sizing
  - Text color customization

### Tools
- **Spell Checker:** Built-in spell checking with dictionary support
- **Word Count:** Track your document statistics
- **Save/Open:** Save and load your documents (as .txt files)

### Current Limitations
- Text formatting (bold, italic, colors) is not saved to files
- Files are saved as plain text (.txt) only
- Undo/Redo functionality is limited

---

## Usage Tips

1. **Creating New Pages:** Use the toolbar buttons to add or remove pages
2. **Formatting Text:** Select text and use the formatting buttons in the toolbar
3. **Spell Check:** Click the spell check button to review your document
4. **Saving:** Use File → Save to save your work (formatting will not be preserved)

---

## Troubleshooting

### Application Won't Start

**Problem:** Double-clicking the JAR file does nothing  
**Solution:** 
- Ensure Java is installed: `java -version`
- Try running from command line: `java -jar EditText.jar`
- Check that the JAR file is not corrupted

**Problem:** "Java not found" error  
**Solution:**
- Install Java Runtime Environment from https://www.java.com/
- Ensure Java is in your system PATH

### Application Crashes

**Problem:** Application closes unexpectedly  
**Solution:**
- Run from terminal to see error messages: `java -jar EditText.jar`
- Ensure you have sufficient memory available
- Try with a fresh Java installation

## License & Credits

**Created by:** Steven Gerhard  
**Spell Checking:** Powered by JOrtho library

This application is provided as-is for educational and personal use.

---

## Support

For issues or questions about this application, please refer to the source repository or contact the developer.

---

## Version History

**Version 1.0** (Current)
- Initial distributable release
- Core text editing features
- Spell checking support
- Multiple page management
- Basic formatting tools

---

**Enjoy using EditText!**