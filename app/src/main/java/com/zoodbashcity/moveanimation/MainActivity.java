package com.zoodbashcity.moveanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private static final float STEP_X = 200f;
    private static final float STEP_Y = 200f;
    ImageView ball;  //ball
    ImageView goal; //goal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = findViewById(R.id.object);
        goal = findViewById(R.id.goal);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        ObjectAnimator animator;
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                animator = ObjectAnimator.ofFloat(ball, "translationX", ball.getX() + STEP_X);
                        animator.start();
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                animator = ObjectAnimator.ofFloat(ball, "translationX", ball.getX() - STEP_X);
                animator.start();
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                animator = ObjectAnimator.ofFloat(ball, "translationY", ball.getY() - STEP_Y);
                animator.start();
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                animator = ObjectAnimator.ofFloat(ball, "translationY",   ball.getY() + STEP_Y);
                animator.start();
            break;
        }
        Rect ballRect = new Rect(ball.getLeft(), ball.getTop(), ball.getRight(), ball.getBottom());
        Rect goalRect = new Rect(goal.getLeft(), goal.getTop(), goal.getRight(), ball.getBottom());

        if(goalRect.contains(ballRect)) {
            Toast.makeText(MainActivity.this, "Goal", Toast.LENGTH_SHORT).show();
        }

        return super.onKeyDown(keyCode, event);
    }

}
