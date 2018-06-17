package com.giant.materialtransition;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.transition.ChangeClipBounds;
import android.support.transition.ChangeTransform;
import android.support.transition.Scene;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by panda on 2018/6/16
 **/
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ChangeClipBoundsActivity extends BaseActivity {

    private Scene scene;
    private LinearLayout sceneRoot;
    private ImageView sceneImage;

    private int width, height;

    ChangeClipBounds xmlChangeClipBounds;
    ChangeClipBounds codeChangeClipBounds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change3);

        sceneRoot = findViewById(R.id.sceneRoot);
        sceneImage = findViewById(R.id.sceneImage);

        width = getResources().getDisplayMetrics().widthPixels;
        height = dip2px(this, 250);
        scene = new Scene(sceneRoot, sceneImage);

        codeChangeClipBounds = new ChangeClipBounds();
        xmlChangeClipBounds = (ChangeClipBounds) TransitionInflater.from(this).inflateTransition(R.transition.changeclipbound);
    }

    private void caculateClipBounds() {
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
        sceneImage.setClipBounds(new Rect(left, top, right, bottom));
    }

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void one(View view) {
        caculateClipBounds();
        TransitionManager.go(scene, codeChangeClipBounds);
    }

    public void two(View view) {
        caculateClipBounds();
        TransitionManager.go(scene, xmlChangeClipBounds);
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
