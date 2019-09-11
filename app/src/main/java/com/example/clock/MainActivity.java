package com.example.clock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView myView = new MyView(this);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout.addView(myView);
    }


    public class MyView extends View
    {

        public MyView(Context context) {
            super(context);
        }

        /*public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }*/

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int x = getWidth();
            int y = getHeight();

            int radius = x/2;

            Paint paint = new Paint();

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.parseColor("#ffffff"));
            paint.setStrokeWidth(7);

            canvas.drawPaint(paint);
            paint.setColor(getResources().getColor(R.color.colorAccent));
            //canvas.drawCircle(radius,radius,radius,paint);
            canvas.drawArc(linearLayout.getLeft(),linearLayout.getTop(),linearLayout.getRight(),linearLayout.getBottom(),90,90,false,paint);
        }
    }
}
