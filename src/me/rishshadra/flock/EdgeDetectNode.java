/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;
import static me.rishshadra.flock.Consts.*;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class EdgeDetectNode extends Node {

    EdgeDetectNode(double x, double y, double speed, double dir) {
        super(x, y, speed, dir);
    }

    @Override
    public void update(Node n) {
        if (!n.id.equals(targetID)) {
            NodeContainer.decrementPopularity(targetID);
            NodeContainer.incrementPopularity(id);
            targetID = id;
        }
        speed = (0.75 * speed) + (0.25 * n.speed);
        dir = (0.25 * dir) + (0.75 * n.dir);
    }

    @Override
    public void multiUpdate(ArrayList<Node> l) {

    }

    @Override
    Color getColor() {
        return Color.RED;
    }

    @Override
    Node getTargetNode(Node n, ArrayList<Node> l) {
        return NodeUtils.getNearestNode(n, l);
    }

    @Override
    void nextPosition() {

        double deltaX = speed * Math.cos(dir);
        double deltaY = speed * Math.sin(dir);

        if (x < EDGE_DETECT_X_THRESHOLD) {
            deltaX += 0.00001 * (Math.abs(x - EDGE_DETECT_X_THRESHOLD));
            speed = Math.sqrt((Math.pow(deltaX, 2)) + Math.pow(deltaY, 2));
            dir = Math.acos(deltaX / speed);
        }

        if (x > SIZE_X - EDGE_DETECT_X_THRESHOLD) {
            deltaX -= 0.00001 * (Math.abs(x - EDGE_DETECT_X_THRESHOLD));
            speed = Math.sqrt((Math.pow(deltaX, 2)) + Math.pow(deltaY, 2));
            dir = Math.acos(deltaX / speed);
        }

        if (y < EDGE_DETECT_Y_THRESHOLD) {
            deltaY += 0.00001 * (Math.abs(x - EDGE_DETECT_Y_THRESHOLD));
            speed = Math.sqrt((Math.pow(deltaX, 2)) + Math.pow(deltaY, 2));
            dir = Math.asin(deltaY / speed);
        }

        if (y > SIZE_Y - EDGE_DETECT_Y_THRESHOLD) {
            deltaY -= 0.00001 * (Math.abs(x - EDGE_DETECT_Y_THRESHOLD));
            speed = Math.sqrt((Math.pow(deltaX, 2)) + Math.pow(deltaY, 2));
            dir = Math.asin(deltaY / speed);
        }

        x += deltaX;
        y += deltaY;
    }
}
