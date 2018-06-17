package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by panda on 2018/6/17
 **/
public class ComplexActivity extends BaseActivity implements View.OnClickListener {
    GridLayout root;
    ImageView one, two, three, four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex);

        root = findViewById(R.id.root);
        one = findViewById(R.id.one);
        one.setOnClickListener(this);
        two = findViewById(R.id.two);
        two.setOnClickListener(this);
        three = findViewById(R.id.three);
        three.setOnClickListener(this);
        four = findViewById(R.id.four);
        four.setOnClickListener(this);
    }

    @Override
    void duration(int duration) {

    }

    @Override
    void interpolator(Interpolator interpolator) {

    }

    @Override
    public void onClick(View view) {
        TransitionManager.go(new Scene(root), TransitionInflater.from(this).inflateTransition(R.transition.complex));
        changeSize((ImageView) view);
        changeVisibility();
        view.setVisibility(View.VISIBLE);
    }

    private void changeSize(ImageView view) {
        if (view.getScaleX() == 1) {
            view.setScaleX(1.5f);
            view.setScaleY(1.5f);
        } else {
            view.setScaleX(1f);
            view.setScaleY(1f);
        }
    }

    private void changeVisibility(){
        for (int i = 0; i < root.getChildCount(); i++) {
            View view = root.getChildAt(i);
            view.setVisibility(view.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);
        }
    }
}
