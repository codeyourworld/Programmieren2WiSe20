package de.haw_hamburg.flappybird;

import android.graphics.Rect;

import java.util.Timer;
import java.util.TimerTask;

public class GameController {

    private Rect rect = new Rect(0, 0, 100, 100);
    private GameView gameView;
    private MainActivity mainActivity;

    public GameController(MainActivity mainActivity, GameView gameView) {
        this.mainActivity = mainActivity;
        this.gameView = gameView;
        init();
    }

    private void init() {
        gameView.setRect(rect);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                rect.left++;
                rect.right++;
                gameView.postInvalidate();
            }
        }, 0, 10);
    }

    public void onTouch() {
        rect.left-=20;
        rect.right-=20;
    }
}
