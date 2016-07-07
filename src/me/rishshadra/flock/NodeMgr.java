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
import static me.rishshadra.flock.Consts.*;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class NodeMgr implements Runnable {

    public static Display d = new Display();
    public static Statistics s = new Statistics();

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
            NodeContainer.add(new BasicNode(r.nextInt(SIZE_X + 1), r.nextInt(SIZE_Y + 1), 0.0001 * r.nextInt(10000), r.nextInt(360)));
            //NodeContainer.add(new RandomNode(r.nextInt(SIZE_X + 1), r.nextInt(SIZE_Y + 1)));
        }

        //for (int i = 0; i < 1; i++) {
        //    nodes.add(new RandomNode(r.nextInt(1025), r.nextInt(769)));
        //}
        //nodes.add(new TestNode(512, 384, 0.1, Math.PI));
        //nodes.add(new BasicNode(-10, -10, 0.1, 180));
        d.setVisible(true);
        Thread t = new Thread(new NodeMgr());
        t.start();
        Thread t2 = new Thread(s);
        t2.start();

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
            NodeContainer.shuffle();
            for (Node n : NodeContainer.getList()) {
                n.nextPosition();
                d.addDisplayedNode((int) n.x, (int) n.y, n.getColor());
                n.update(n.getTargetNode(n, NodeContainer.getList()));
            }

            //for (Node n : nodes) {
            //    n.update(NodeUtils.getTargetNode(n, nodes));
            //}
            d.commitNextFrame();
        }
    }
}
