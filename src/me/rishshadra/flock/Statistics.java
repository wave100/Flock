/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class Statistics implements Runnable {
    int max = 1;

    @Override
    public void run() {
        System.out.println("Init Statistics Thread");
        while (true) {
            NodeContainer.popularityMap.forEach((k, v) -> {
                    System.out.println("ID: " + k + " , POP: " + v);
                if (v > 1) {
                    System.out.println("ID: " + k + " , POP: " + v);
                    max = 2;
                }
            });
            
            if (new Random().nextInt(100000) > 50000) {
                System.out.println("Upping popularity of random node");
                NodeContainer.incrementPopularity(NodeContainer.getList().get(23).id);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
