/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
//        while (true) {
//            d.clearFrame();
//            n.replace(NodeUtils.getNewPosition(n));
//            System.out.println(n.x + " " + n.y);
//            d.addDisplayedNode((int)n.x, (int)n.y);
//            d.updateFrame();
//        }

        Random r = new Random();

        for (int i = 0; i < 500; i++) {
            //nodes.add(new BasicNode(r.nextInt(1025), r.nextInt(769), 0.0001 * r.nextInt(10000), r.nextInt(360)));
            nodes.add(new RandomNode(r.nextInt(1025), r.nextInt(769)));
        }
        
        //for (int i = 0; i < 1; i++) {
        //    nodes.add(new RandomNode(r.nextInt(1025), r.nextInt(769)));
        //}
        
        //nodes.add(new TestNode(512, 384, 0.1, Math.PI));
        //nodes.add(new BasicNode(-10, -10, 0.1, 180));

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
                n.nextPosition();
                d.addDisplayedNode((int) n.x, (int) n.y, n.getColor());
                n.update(NodeUtils.getTargetNode(n, nodes));
            }

            //for (Node n : nodes) {
            //    n.update(NodeUtils.getTargetNode(n, nodes));
            //}
            d.commitNextFrame();
        }
    }
}
