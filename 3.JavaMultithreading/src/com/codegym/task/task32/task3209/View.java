package com.codegym.task.task32.task3209;

import com.codegym.task.task32.task3209.listeners.FrameListener;
import com.codegym.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;

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

    public void selectedTabChanged(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
