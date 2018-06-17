package com.giant.materialtransition;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.transition.ChangeClipBounds;
import android.support.transition.Scene;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by panda on 2018/6/16
 **/
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ChangeClipBoundsActivity2 extends BaseActivity {
    private Scene scene1;
    private Scene scene2;
    private LinearLayout sceneRoot;
    private ImageView sceneImage1, sceneImage2;
    boolean isScene1 = true;

    private int width, height;

    ChangeClipBounds xmlChangeClipBounds;
    ChangeClipBounds codeChangeClipBounds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change3);

        sceneRoot = findViewById(R.id.sceneRoot);
        sceneImage1 = findViewById(R.id.sceneImage);
        sceneImage2 = sceneImage1;

        width = getResources().getDisplayMetrics().widthPixels;
        height = dip2px(this, 250);
        scene1 = new Scene(sceneRoot, sceneImage1);
        scene2 = new Scene(sceneRoot, sceneImage2);

        codeChangeClipBounds = new ChangeClipBounds();
        xmlChangeClipBounds = (ChangeClipBounds) TransitionInflater.from(this).inflateTransition(R.transition.changeclipbound);
    }

    private void caculateClipBounds(ImageView imageView) {
        int left = (int) (Math.random() * width);
        int top = (int) (Math.random() * height);
        int right = left + 150;
        if (right > width) {
            right = width;
        }
        int bottom = top + 150;
        if (bottom > height) {
            bottom = height;
        }
        imageView.setClipBounds(new Rect(left, top, right, bottom));
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void one(View view) {
        caculateClipBounds(sceneImage1);
        caculateClipBounds(sceneImage2);
        if (isScene1) {
            isScene1 = true;
            TransitionManager.go(scene2, codeChangeClipBounds);
        } else {
            isScene1 = false;
            TransitionManager.go(scene1, codeChangeClipBounds);
        }
    }

    public void two(View view) {
//        caculateClipBounds();
//        TransitionManager.go(scene, xmlChangeClipBounds);
    }

    @Override
    void duration(int duration) {
        xmlChangeClipBounds.setDuration(duration);
        codeChangeClipBounds.setDuration(duration);
    }

    @Override
    void interpolator(Interpolator interpolator) {
        xmlChangeClipBounds.setInterpolator(interpolator);
        codeChangeClipBounds.setInterpolator(interpolator);
    }
}
