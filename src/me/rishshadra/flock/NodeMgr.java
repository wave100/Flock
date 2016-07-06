/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.rishshadra.flock.gui.Display;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class NodeMgr implements Runnable {

    public static ArrayList<Node> nodes = new ArrayList<>();
    public static Display d = new Display();

    public static void main(String[] args) throws InterruptedException {
//        d.setVisible(true);
//        Node n = new Node(0, 0, 0.0008, 190);
//        System.out.println("Dir: " + n.dir);
//        System.out.println("Spd: " + n.speed);
//        while (true) {
//            d.clearFrame();
//            n.replace(NodeUtils.getNewPosition(n));
//            System.out.println(n.x + " " + n.y);
//            d.addDisplayedNode((int)n.x, (int)n.y);
//            d.updateFrame();
//        }

//        nodes.add(new Node(512, 384, 0.008, 190));
//        nodes.add(new Node(203, 230, 0.018, 348));
//        nodes.add(new Node(385, 223, 0.005, 201));
//        nodes.add(new Node(450, 67, 0.014, 109));
//        nodes.add(new Node(223, 78, 0.0023, 60));
        //nodes.add(new Node(100, 100, 1, 180));
        Random r = new Random();

        for (int i = 0; i < 500; i++) {
            nodes.add(new Node(r.nextInt(1025), r.nextInt(769), 0.01 * r.nextInt(100), r.nextInt(360)));
        }
        d.setVisible(true);
        Thread t = new Thread(new NodeMgr());
        t.start();

//        while (true) {
//            Collections.shuffle(nodes);
//            for (Node n : nodes) {
//                n.replace(NodeUtils.getNewPosition(n));
//                d.addDisplayedNode((int) n.x, (int) n.y);
//            }
//            for (Node n : nodes) {
//                n.update(NodeUtils.getNearestNode(n, nodes));
//            }
//            d.commitNextFrame();
//        }
    }

    @Override
    public void run() {
        while (true) {
            Collections.shuffle(nodes);
            for (Node n : nodes) {
                n.replace(NodeUtils.getNewPosition(n));
                d.addDisplayedNode((int) n.x, (int) n.y);
            }
//            try {
//                //Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(NodeMgr.class.getName()).log(Level.SEVERE, null, ex);
//            }
            for (Node n : nodes) {
                n.update(NodeUtils.getNearestNode(n, nodes));
            }
            d.commitNextFrame();
        }
    }
}
