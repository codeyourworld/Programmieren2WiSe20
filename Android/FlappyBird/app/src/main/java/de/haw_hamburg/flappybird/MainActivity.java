package de.haw_hamburg.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private GameController gameController;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);

        gameController = new GameController(this, gameView);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameController.onTouch();
        return super.onTouchEvent(event);
    }
}