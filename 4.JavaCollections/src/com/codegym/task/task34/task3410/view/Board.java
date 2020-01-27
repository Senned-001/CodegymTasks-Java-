package com.codegym.task.task34.task3410.view;

import com.codegym.task.task34.task3410.controller.EventListener;
import com.codegym.task.task34.task3410.model.Box;
import com.codegym.task.task34.task3410.model.Direction;
import com.codegym.task.task34.task3410.model.GameObject;
import com.codegym.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Board extends JPanel {
    private View view;
    private EventListener eventListener;

    public Board(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        view.addKeyListener(keyHandler);
        view.setFocusable(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,view.getWidth(),view.getHeight());
        Set<GameObject> allObjects = view.getGameObjects().getAll();
        for(GameObject o:allObjects){
            o.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }

    public class KeyHandler extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT : {
                    Board.this.eventListener.move(Direction.LEFT);
                    break;
                }
                case KeyEvent.VK_RIGHT : {
                    Board.this.eventListener.move(Direction.RIGHT);
                    break;
                }
                case KeyEvent.VK_UP : {
                    Board.this.eventListener.move(Direction.UP);
                    break;
                }
                case KeyEvent.VK_DOWN : {
                    Board.this.eventListener.move(Direction.DOWN);
                    break;
                }
                case KeyEvent.VK_R : {
                    Board.this.eventListener.restart();
                    break;
                }
            }
        }
    }
}
