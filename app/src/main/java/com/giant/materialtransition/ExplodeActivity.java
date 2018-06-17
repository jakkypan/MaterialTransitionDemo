package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Explode;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by panda on 2018/6/16
 **/
public class ExplodeActivity extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private LinearLayout sceneRoot;
    boolean isScene1 = true;

    Explode xmlExplode;
    Explode codeExplode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fade);

        sceneRoot = findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.content1, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.content2, this);

        codeExplode = new Explode();
        xmlExplode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.explode);
    }

    public void one(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, codeExplode);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, codeExplode);
        }
    }

    public void two(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, xmlExplode);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, xmlExplode);
        }
    }

    @Override
    void duration(int duration) {
        xmlExplode.setDuration(duration);
        codeExplode.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlExplode.setInterpolator(interpolator);
        codeExplode.setInterpolator(interpolator);
    }
}
