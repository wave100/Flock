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
public class ParametricNode extends Node {
    
    public ParametricNode(int x, int y) {
        super(x, y);
    }

    @Override
    void update(Node n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void multiUpdate(ArrayList<Node> l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void nextPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Color getColor() {
        return Color.DARK_GRAY;
    }
    
}
