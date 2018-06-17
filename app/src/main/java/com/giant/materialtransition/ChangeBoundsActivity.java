package com.giant.materialtransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
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
public class ChangeBoundsActivity extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private LinearLayout sceneRoot;
    int isScene = 0;

    ChangeBounds xmlChangeBounds;
    ChangeBounds codeChangeBounds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);

        sceneRoot = findViewById(R.id.sceneRoot);

        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.content3, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.content4, this);
        scene3 = Scene.getSceneForLayout(sceneRoot, R.layout.content5, this);

        codeChangeBounds = new ChangeBounds();
        xmlChangeBounds = (ChangeBounds) TransitionInflater.from(this).inflateTransition(R.transition.changebounds);
    }

    public void one(View view) {
        switch (isScene) {
            case 0:
                isScene = 1;
                TransitionManager.go(scene2, codeChangeBounds);
                break;
            case 1:
                isScene = 2;
                TransitionManager.go(scene3, codeChangeBounds);
                break;
            case 2:
                isScene = 0;
                TransitionManager.go(scene1, codeChangeBounds);
                break;
        }
    }

    public void two(View view) {
        switch (isScene) {
            case 0:
                isScene = 1;
                TransitionManager.go(scene2, codeChangeBounds);
                break;
            case 1:
                isScene = 2;
                TransitionManager.go(scene3, codeChangeBounds);
                break;
            case 2:
                isScene = 0;
                TransitionManager.go(scene1, codeChangeBounds);
                break;
        }
    }

    @Override
    void duration(int duration) {
        xmlChangeBounds.setDuration(duration);
        codeChangeBounds.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlChangeBounds.setInterpolator(interpolator);
        codeChangeBounds.setInterpolator(interpolator);
    }

    @Override
    void resizeClip(boolean resizeClip) {
        xmlChangeBounds.setResizeClip(resizeClip);
        codeChangeBounds.setResizeClip(resizeClip);
    }
}
