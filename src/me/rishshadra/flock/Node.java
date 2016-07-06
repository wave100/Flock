/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.awt.Color;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public abstract class Node {

    protected double x = 0, y = 0;
    protected double speed = 0, dir = 0;
    protected String id = UUID.randomUUID().toString();
    
    Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Node(double x, double y, double speed, double dir) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
    }

    abstract void update(Node n);

    abstract void multiUpdate(ArrayList<Node> l);
    
    abstract void nextPosition();
    
    abstract Color getColor();
}
