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
        Node nearest = null;
        for (Node q : l) {
            if (((getDistance(n, q) < mindist) || (mindist == -1)) && (getDistance(n, q) != 0)) {
                mindist = getDistance(n, q);
                nearest = q;
            }
        }
        return nearest;
    }

    public static double getDistance(Node a, Node b) {
        return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
    }

    public static Node getTargetNode(Node n, ArrayList<Node> l) {
        return getNearestNode(n, l);
    }

//    public Node randomizeMagnitude(Node n) {
//        
//    }
//    
//    public Node randomizeDirection(Node n) {
//        
//    }
}
