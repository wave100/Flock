/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class NodeContainer {

    private static ArrayList<Node> nodes = new ArrayList<>();
    private static HashMap<String, Integer> popularityMap = new HashMap<>();

    public static void add(Node n) {
        nodes.add(n);
    }

    public static ArrayList<Node> getList() {
        return nodes;
    }

    public static void shuffle() {
        Collections.shuffle(nodes);
    }
    
    public static void incrementPopularity(String nodeID) {
        
    }
    
    public static void decrementPopularity(String nodeID) {
        
    }
    
}
