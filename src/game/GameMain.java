package game;
import model.Block;
import model.Cloud;
import model.FlappyBird;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by praveensingh on 23/06/16.
 */
public class GameMain extends JPanel implements ActionListener,KeyListener,MouseListener {

    static  int clock=0;
    public static FlappyBird flappyBird ;
    public ArrayList<Block> blocks;
    private ArrayList<Cloud> clouds;
    static int i=1;
    private static  int score=0;
    private boolean gameOver=false,isStart=false ;
   // private int flag=0,preFlag=0;

    public GameMain(){
        flappyBird=new FlappyBird(0,150,150);

        Timer timer =new Timer(20,this);
        this.setBackground(Color.CYAN);

        blocks=new ArrayList<Block>();
        clouds=new ArrayList<Cloud>();

        addClouds(true);
        addClouds(true);
        addClouds(true);
        addClouds(true);

        addBlocks(true);
        addBlocks(true);
        addBlocks(true);
        addBlocks(true);



        this.addMouseListener(this);
        this.addKeyListener(this);
        timer.start();


    }



    private void addClouds(boolean isStart){
        if(isStart) {
            Random r=new Random();
            clouds.add(new Cloud(Game.WIDTH + clouds.size() * 600, 100+r.nextInt(100)));
        }
    }

    private void paintClouds(Graphics g,Cloud cloud){
        g.drawImage(cloud.getCloudeImage(),cloud.getCloudX(),cloud.getCloudY(),cloud.getDimension().width,cloud.getDimension().height,null);
     //   g.drawImage()
    }





    private void addBlocks(boolean start){

        int space=300;
        int height=50+new Random().nextInt(300);

        if(start){
                blocks.add(new Block(Game.WIDTH+Block.WIDTH+blocks.size()*300,Game.HEIGHT-height-95,height));
                blocks.add(new Block(Game.WIDTH+Block.WIDTH+(blocks.size()-1)*300,0,Game.HEIGHT-height-space));
        }else{
             blocks.add(new Block(blocks.get(blocks.size()-1).getX()+600,Game.HEIGHT-height-95,height));
             blocks.add(new Block(blocks.get(blocks.size()-1).getX(),0,Game.HEIGHT-height-space));

        }

    }

    private void paintblocks(Graphics g, Block block){
       // System.out.println("asjdfhdjsfjh");
        g.setColor(Block.getColor());
        g.fillRect(block.getX(),block.getY(),block.getWidth(),block.getHieght());

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawString("Repainted "+i+" times ",100,100);
        g.drawImage(flappyBird.getImage(),flappyBird.getXcoordinate(),flappyBird.getYcoordinate(),flappyBird.getD().width,flappyBird.getD().height,null);
        g.setColor(Color.ORANGE);
        g.fillRect(0,520,Game.WIDTH,80);
        g.setColor(Color.green);
        g.fillRect(0,505,Game.WIDTH,15);

        for(Cloud cloud : clouds){
            paintClouds(g,cloud);
        }

        g.drawImage(flappyBird.getImage(),flappyBird.getXcoordinate(),flappyBird.getYcoordinate(),flappyBird.getD().width,flappyBird.getD().height,null);

//        System.out.println(" clouds "+clouds.size());
//        System.out.println("blocks "+blocks.size());
        for(Block block : blocks){
            paintblocks(g,block);

        }

        if(gameOver){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",1,20));
            g.drawString("Score : "+score,20,25);
            g.setFont(new Font("Arial",1,100));
            g.drawString("Game Over !",200,Game.HEIGHT/2);

            g.drawRect(Game.WIDTH-Game.WIDTH/2-60,Game.HEIGHT/2-200,165,70);
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("Arial",1,50));
            g.drawString("Replay",Game.WIDTH-Game.WIDTH/2-60,Game.HEIGHT/2-150);

        }
        if(!isStart){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",1,100));
            g.drawString("Click to play!",200,Game.HEIGHT/2);
        }

      if(!gameOver) {
          g.setFont(new Font("Arial",1,20));
          g.drawString("Score : " + score, 20, 25);

      }
//        if(flag!=preFlag){
//            preFlag=flag;
//            g.setColor(Color.DARK_GRAY);
//            g.drawString("Level up !",Game.WIDTH-200,Game.HEIGHT-400);
//        }
        i++;
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("repainted");
      // System.out.println(clock);
        clock++;
      if(isStart ) {

          for(int i=0;i<clouds.size();i++){
              Cloud cloud=clouds.get(i);
              cloud.setCloudX(cloud.getCloudX()-Cloud.SPEED);
          }

//          if((score%100)==1){
//              Block.SPEED++;
//              flag++;
//          }

          for (int i = 0; i < blocks.size(); i++) {
              Block block = blocks.get(i);
              block.setX(block.getX() - Block.SPEED);
          }

          if (clock % 2 == 0 && flappyBird.getAccelaration() < 15) {
              flappyBird.setAccelaration(flappyBird.getAccelaration() + 2);

             // if(clock%5==0)
              score++;
          }


          for (int i = 0; i < clouds.size(); i++) {
              Cloud cloud = clouds.get(i);
              if (cloud.getCloudX() + cloud.getDimension().width < 0) {
                  clouds.remove(cloud);
                      addClouds(true);

              }
          }
          for (int i = 0; i < blocks.size(); i++) {
              Block block = blocks.get(i);
              if (block.getX() + Block.WIDTH < 0) {
                  blocks.remove(block);
                  if (block.getY() == 0) {
                      addBlocks(false);
                  }
              }
          }

          flappyBird.setYcoordinate(flappyBird.getYcoordinate() + flappyBird.getAccelaration());

          for (Block block : blocks) {
              Rectangle rect = new Rectangle(block.getX(), block.getY(), block.getWidth(), block.getHieght());
              Rectangle flapybirdRectangle = flappyBird.getFlappyBirdRectangle();
              if (rect.intersects(flapybirdRectangle)) {

                  gameOver = true;
                  // isStart=false;
                  flappyBird.setXcoordinate(block.getX() - flappyBird.getD().width);
              }
          }
          if (flappyBird.getYcoordinate() > Game.HEIGHT - 95 || flappyBird.getYcoordinate() < 0) {
              //  isStart=false;
              gameOver = true;
          }


          if (gameOver) {

              flappyBird.setYcoordinate(Game.HEIGHT - 95 - flappyBird.getD().height);
          }


      }        this.repaint();


    }


    private void move(MouseEvent event){
        if(gameOver){

            int x=event.getX();
            int y=event.getY();
            if((x>(Game.WIDTH-Game.WIDTH/2-60) &&x<(Game.WIDTH-Game.WIDTH/2-60+165)) &&(y>(Game.HEIGHT/2-200)&&y<(Game.HEIGHT/2-200+70))){

            flappyBird=new FlappyBird(0,150,150);
            blocks.clear();

            addBlocks(true);
            addBlocks(true);
            addBlocks(true);
            addBlocks(true);

            score=0;
            gameOver=false;
        }
        }
        if(!isStart){
            isStart=true;
        }else  if(!gameOver){
            if(flappyBird.getAccelaration()>0){
                flappyBird.setAccelaration(0);
                flappyBird.setAccelaration(flappyBird.getAccelaration()-10);

            }
        }

    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//    if (e.getKeyCode()==KeyEvent.VK_SPACE){
//         flappyBird.setAccelaration(flappyBird.getAccelaration()-2);
//
//    }
//        System.out.println("space key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // isStart=true;
        this.move(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
