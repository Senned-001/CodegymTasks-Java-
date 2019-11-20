package com.codegym.task.task32.task3209;

import com.codegym.task.task32.task3209.listeners.FrameListener;
import com.codegym.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.codegym.task.task32.task3209.listeners.TextEditMenuListener;
import com.codegym.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private UndoManager undoManager=new UndoManager();
    private UndoListener undoListener=new UndoListener(undoManager);
    private TextEditMenuListener textEditMenuListener=new TextEditMenuListener(this);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void undo(){
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }


    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    private JTabbedPane tabbedPane=new JTabbedPane();
    private JTextPane htmlTextPane=new JTextPane();
    private JEditorPane plainTextPane=new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener frameListener=new FrameListener(this);
        addWindowListener(frameListener);
        this.setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar jMenuBar=new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        this.getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPanehtml = new JScrollPane(htmlTextPane);

        tabbedPane.addTab("HTML",jScrollPanehtml);

        JScrollPane jScrollPanetext = new JScrollPane(plainTextPane);

        tabbedPane.addTab("Text",jScrollPanetext);
        tabbedPane.setPreferredSize(new Dimension(150, 100));
        TabbedPaneChangeListener tabbedPaneChangeListener=new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        this.getContentPane().add(tabbedPane,BorderLayout.CENTER);

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex()==0?true:false;
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){

        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){

        JOptionPane.showMessageDialog(this,"This is SuperEditor","About",JOptionPane.INFORMATION_MESSAGE);

    }

    public void selectedTabChanged(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
