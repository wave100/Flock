/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author rshad
 */
public class TestNode extends Node {

    public TestNode(double x, double y, double speed, double dir) {
        super(x, y, speed, dir);
    }

    @Override
    void update(Node n) {

    }

    @Override
    void multiUpdate(ArrayList<Node> l) {

    }

    @Override
    void nextPosition() {
        double deltaX = speed * Math.cos(dir);
        double deltaY = speed * Math.sin(dir);

        x += deltaX;
        y += deltaY;
    }

    @Override
    Color getColor() {
        return Color.MAGENTA;
    }

}
