/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.rishshadra.flock;

import java.util.Random;

/**
 *
 * @author Rish Shadra <rshadra@gmail.com>
 */
public class Node {

    public double x, y;
    public double speed, dir;
    private Random r = new Random();

    Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Node(double x, double y, double speed, double dir) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
    }

    public void update(Node n) {
        //if (r.nextInt(1001) <= 1) {
         //   speed = speed + ((r.nextDouble() - 0.5) / 100);
          //  dir = dir + 1 * (r.nextDouble() - 0.5);
        //} else {
            speed = (0.9 * speed) + (0.1 * n.speed);
            dir = (0.75 * dir) + (0.25 * n.dir);
        //}
    }

    public void replace(Node n) {
        this.x = n.x;
        if (n.x >= 1024) {
            this.x = 0;
        }
        if (n.x < 0) {
            this.x = 1024;
        }
        this.y = n.y;
        if (n.y >= 768) {
            this.y = 0;
        }
        if (n.y < 0) {
            this.y = 768;
        }
        this.speed = n.speed;
        this.dir = n.dir;
    }
}
