package model;

import java.awt.*;

/**
 * Created by praveensingh on 25/06/16.
 */
public class Block  {

    int x;
    int y;
    public static final int WIDTH=100;
    int hieght;
    public static  int SPEED =10;

    public int getSpeed() {
        return SPEED;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public void setHieght(int hieght) {
        this.hieght = hieght;
    }



    final static Color color=Color.GREEN.darker();

    public Block(int x, int y, int hieght) {
        this.x = x;
        this.y = y;

        this.hieght = hieght;
    }

    public int getX() {return x;}

    public int getY() {
        return y;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHieght() {
        return hieght;
    }

    public static Color getColor() {
        return color;
    }
}
