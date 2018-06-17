package com.giant.materialtransition;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by panda on 2018/6/16
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.d1000:
            case R.id.d2000:
            case R.id.d5000:
                duration(new Integer(item.getTitle().toString()));
                break;
            case R.id.adinterpolator:
                interpolator(new AccelerateDecelerateInterpolator());
                break;
            case R.id.ainterpolator:
                interpolator(new AccelerateInterpolator());
                break;
            case R.id.dinterpolator:
                interpolator(new DecelerateInterpolator());
                break;
            case R.id.linterpolator:
                interpolator(new LinearInterpolator());
                break;
            case R.id.binterpolator:
                interpolator(new BounceInterpolator());
                break;
            case R.id.cinterpolator:
                interpolator(new CycleInterpolator(1));
                break;
            case R.id.left:
                slideEdge(Gravity.LEFT);
                break;
            case R.id.right:
                slideEdge(Gravity.RIGHT);
                break;
            case R.id.top:
                slideEdge(Gravity.TOP);
                break;
            case R.id.bottom:
                slideEdge(Gravity.BOTTOM);
                break;
            case R.id.start:
                slideEdge(Gravity.START);
                break;
            case R.id.end:
                slideEdge(Gravity.END);
                break;
            case R.id.yes:
                resizeClip(true);
                break;
            case R.id.no:
                resizeClip(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    abstract void duration(int duration);

    abstract void interpolator(Interpolator interpolator);

    void slideEdge(int duration) {

    }

    void resizeClip(boolean resizeClip) {

    }
}
