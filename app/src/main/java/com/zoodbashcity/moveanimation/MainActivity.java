package com.zoodbashcity.moveanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ObjectAnimator.AnimatorUpdateListener{

    private static final float STEP_X = 100f;
    private static final float STEP_Y = 100f;
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
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        ViewGroup.LayoutParams goalParams = goal.getLayoutParams();

    }
}
