/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rshad
 */
public class RandomNode extends Node {

    Random r = new Random();

    public RandomNode(int x, int y) {
        super(x, y);
    }

    @Override
    void update(Node n) {

    }

    @Override
    void multiUpdate(ArrayList<Node> l) {
    }

    @Override
    void nextPosition() {
        x += (r.nextInt(51) - 25) / 10;
        y += (r.nextInt(51) - 25) / 10;
        this.speed = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        //System.out.println(speed);
    }

    @Override
    Color getColor() {
        return Color.black;
    }

}
