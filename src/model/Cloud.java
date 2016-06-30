package model;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by praveensingh on 27/06/16.
 */
public class Cloud {

    public BufferedImage cloudeImage;
    public int cloudX;
    public int cloudY;
    public static final int SPEED=2;
    public Dimension dimension=new Dimension(150,30);

    public BufferedImage getCloudeImage() {
        return cloudeImage;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setCloudeImage(BufferedImage cloudeImage) {
        this.cloudeImage = cloudeImage;
    }

    public int getCloudX() {
        return cloudX;
    }

    public void setCloudX(int cloudX) {
        this.cloudX = cloudX;
    }

    public int getCloudY() {
        return cloudY;
    }

    public void setCloudY(int cloudY) {
        this.cloudY = cloudY;
    }

    public Cloud(int x, int y )  {
        Random r=new Random();
        int a=1+r.nextInt(3);

        try {
            switch (a){
                case 1:
                    this.cloudeImage = ImageIO.read(Game.class.getResource("cloudimage.png"));
                    break;
                case 2:
                    this.cloudeImage = ImageIO.read(Game.class.getResource("cloud1.png"));
                    break;
                default:
                    this.cloudeImage = ImageIO.read(Game.class.getResource("cloud2.png"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.cloudX=x;
        this.cloudY=y;
    }


}
