package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeTransform;
import android.support.transition.Scene;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by panda on 2018/6/16
 **/
public class ChangeTransformActivity extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private LinearLayout sceneRoot;
    boolean isScene1 = true;

    ChangeTransform xmlChangeTransform;
    ChangeTransform codeChangeTransform;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change2);

        sceneRoot = findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.content6, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.content7, this);

        codeChangeTransform = new ChangeTransform();
        xmlChangeTransform = (ChangeTransform) TransitionInflater.from(this).inflateTransition(R.transition.changetransform);
    }

    public void one(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, codeChangeTransform);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, codeChangeTransform);
        }
    }

    public void two(View view) {
        if (isScene1) {
            isScene1 = false;
            TransitionManager.go(scene2, codeChangeTransform);
        } else {
            isScene1 = true;
            TransitionManager.go(scene1, codeChangeTransform);
        }
    }

    @Override
    void duration(int duration) {
        xmlChangeTransform.setDuration(duration);
        codeChangeTransform.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlChangeTransform.setInterpolator(interpolator);
        codeChangeTransform.setInterpolator(interpolator);
    }
}
