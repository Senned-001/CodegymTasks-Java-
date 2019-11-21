package com.codegym.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document=new HTMLDocument();
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller= new Controller(view);
        view.setController(controller);

        view.init();
        controller.init();

    }

    public void resetDocument(){
        if(this.document!=null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument)new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }

    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader=new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader,document,0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter stringWriter=new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter,document,0,document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML editor");
        view.resetUndo();
        currentFile=null;

    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        if(jFileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION){
            currentFile=jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader fr = new FileReader(currentFile)){
                new HTMLEditorKit().read(fr,document,0);
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();

        }
    }

    public void saveDocument(){     //saving to the current file
        view.selectHtmlTab();
        if(currentFile==null) {
            saveDocumentAs();
        }
        else{
            try (FileWriter fw = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fw,document,0,document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs(){           //saving the file under a new name or if file not exist
        view.selectHtmlTab();
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if(jFileChooser.showDialog(view, "Save File") == JFileChooser.APPROVE_OPTION){   //If the user confirms the file selection:
            currentFile=jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fr = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fr,document,0,document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }
    }
}
