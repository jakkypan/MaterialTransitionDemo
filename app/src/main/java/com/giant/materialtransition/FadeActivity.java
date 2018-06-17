package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by panda on 2018/6/16
 **/
public class FadeActivity extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private LinearLayout sceneRoot;
    boolean isScene1 = true;

    Fade xmlFade;
    Fade codeFade;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fade);

        sceneRoot = findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.content1, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.content2, this);

        codeFade = new Fade();
        xmlFade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.fade);
    }

    public void one(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, codeFade);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, codeFade);
        }
    }

    public void two(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, xmlFade);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, xmlFade);
        }
    }

    @Override
    void duration(int duration) {
        xmlFade.setDuration(duration);
        codeFade.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlFade.setInterpolator(interpolator);
        codeFade.setInterpolator(interpolator);
    }
}
