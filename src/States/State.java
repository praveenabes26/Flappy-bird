package States;

import game.GameMain;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by praveensingh on 25/06/16.
 */
public abstract class State {
    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Graphics g);

    public abstract void onClick(MouseEvent e);

    public abstract void onKeyPress(KeyEvent e);

    public abstract void onKeyRelease(KeyEvent e);

//    public void setCurrentState(State newState) {
//        GameMain.setCurrentState(newState);
//    }
}
