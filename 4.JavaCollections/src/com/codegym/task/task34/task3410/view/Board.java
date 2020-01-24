package com.codegym.task.task34.task3410.view;

import com.codegym.task.task34.task3410.model.Box;
import com.codegym.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private View view;

    public Board(View view) {
        this.view = view;
    }

    public void paint(Graphics g){
        //new Box(10,10).draw(g);
        //new Player(100, 100).draw(g);
    }

}
