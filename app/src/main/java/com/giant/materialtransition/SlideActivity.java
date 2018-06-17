package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by panda on 2018/6/16
 **/
public class SlideActivity extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private LinearLayout sceneRoot;
    boolean isScene1 = true;

    Slide xmlSlide;
    Slide codeSlide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fade);

        sceneRoot = findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.content1, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.content2, this);

        codeSlide = new Slide();
        xmlSlide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);
    }

    public void one(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, codeSlide);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, codeSlide);
        }
    }

    public void two(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, xmlSlide);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, xmlSlide);
        }
    }

    @Override
    void duration(int duration) {
        xmlSlide.setDuration(duration);
        codeSlide.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlSlide.setInterpolator(interpolator);
        codeSlide.setInterpolator(interpolator);
    }

    @Override
    void slideEdge(int duration) {
        xmlSlide.setSlideEdge(duration);
        codeSlide.setSlideEdge(duration);
    }
}
