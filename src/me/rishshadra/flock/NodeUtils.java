/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class NodeUtils {

    public static Node getNearestNode(Node n, ArrayList<Node> l) {
        double mindist = -1;
        Node nearest = new Node(-1, -1);
        for (Node q : l) {
            if (((getDistance(n, q) < mindist) || (mindist == -1)) && (getDistance(n, q) != 0)) {
                mindist = getDistance(n, q);
                nearest = q;
                //if (new Random().nextInt(1001) <= 1) {
                //    mindist = -2;
                //}
            }
        }
        return nearest;
    }

    public static double getDistance(Node a, Node b) {
        return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
    }
    
    public static Node getNewPosition(Node n) {
        double deltaX = n.speed * Math.cos(n.dir);
        double deltaY = n.speed * Math.sin(n.dir);
        
        return new Node(n.x + deltaX, n.y + deltaY, n.speed, n.dir);
    }
    
//    public Node randomizeMagnitude(Node n) {
//        
//    }
//    
//    public Node randomizeDirection(Node n) {
//        
//    }
}
