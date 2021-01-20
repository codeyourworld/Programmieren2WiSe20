package de.haw_hamburg.flappybird;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GameView extends View {

    private Paint paint = new Paint();

    //default init, falls die onDraw()-Methode vor der setRect() aufgerufen wird
    private Rect rect = new Rect(0,0,0,0);

    public GameView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.argb(100, 0, 255,255));
        paint.setStrokeWidth(4);

        canvas.drawRect(rect, paint);
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
