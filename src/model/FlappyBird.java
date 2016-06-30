package model;
import game.Game;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by praveensingh on 25/06/16.
 */
public class FlappyBird {
    float yvelocity;
    int xcoordinate;
    int ycoordinate;
    BufferedImage image;
    int accelaration= 0;
    public static Dimension d=new Dimension(40,40);
    Rectangle flappyBirdRectangle;




    public int getAccelaration() {return accelaration;}

    public float getYvelocity() {return yvelocity;}

    public int getXcoordinate() {
        return xcoordinate;
    }

    public int getYcoordinate() {
        return ycoordinate;
    }

    public Dimension getD() {return d;}

    public void setYvelocity(float yvelocity) {
        this.yvelocity = yvelocity;
    }

    public void setXcoordinate(int xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public void setYcoordinate(int ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setD(Dimension d) {
        this.d = d;
    }

    public void setAccelaration(int accelaration) {this.accelaration = accelaration;}

    public BufferedImage getImage() {return image;}


    public Rectangle getFlappyBirdRectangle() {
       flappyBirdRectangle= new Rectangle(this.getXcoordinate(),this.getYcoordinate(),this.getD().width,this.getD().height);
        return flappyBirdRectangle;
    }

    public FlappyBird(float yvelocity, int xcoordinate, int ycoordinate) {
        try {

             image=ImageIO.read(Game.class.getResource("flpbrd.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.yvelocity = yvelocity;
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
       // flappyBirdRectangle=new Rectangle(xcoordinate,ycoordinate,d.width,d.height);


    }
}
