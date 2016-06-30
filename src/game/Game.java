package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by praveensingh on 22/06/16.
 */
public class Game  {

    public static final int WIDTH=1000;
    public static final int HEIGHT=600;
    public static void main(String[] args) {

        JFrame frame=new JFrame("Flappy bird");


        GameMain mainPanel=new GameMain();

        frame.setContentPane(mainPanel);

//        JButton startButton=new JButton("Play");
//        frame.add(startButton);

        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }



}
