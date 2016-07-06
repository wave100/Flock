/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class DiscoNode extends Node {

    DiscoNode(double x, double y, double speed, double dir) {
        super(x, y, speed, dir);
    }

    @Override
    public void update(Node n) {
        speed = (0.999 * speed) + (0.001 * n.speed);
        dir = (0.25 * dir) + (0.75 * n.dir);
    }

    @Override
    public void multiUpdate(ArrayList<Node> l) {

    }

    @Override
    Color getColor() {
        Random ra = new Random();
        float r = ra.nextFloat();
        float g = ra.nextFloat();
        float b = ra.nextFloat();
        return new Color(r, g, b);
    }

    @Override
    Node getTargetNode(Node n, ArrayList<Node> l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void nextPosition() {
        double deltaX = speed * Math.cos(dir);
        double deltaY = speed * Math.sin(dir);

        x += deltaX;
        y += deltaY;
    }
}
