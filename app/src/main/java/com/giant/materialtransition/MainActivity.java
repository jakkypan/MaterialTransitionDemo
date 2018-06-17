package com.giant.materialtransition;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private String[] categories = {
            "fade",
            "slide",
            "explode",
            "changeBounds",
            "changeTransform",
            "changeClipBound",
            "changeClipBound2",
            "complex"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter implements View.OnClickListener {

        @Override
        public int getCount() {
            return categories.length;
        }

        @Override
        public Object getItem(int position) {
            return categories[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Button button = null;
            if (convertView == null) {
                button = new Button(parent.getContext());
            } else {
                button = (Button) convertView;
            }

            button.setAllCaps(false);
            button.setText(getItem(position) + "");
            button.setId(position);
            button.setOnClickListener(this);
            return button;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case 0:
                    startActivity(new Intent(MainActivity.this, FadeActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, SlideActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, ExplodeActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, ChangeBoundsActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(MainActivity.this, ChangeTransformActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(MainActivity.this, ChangeClipBoundsActivity.class));
                    break;
                case 6:
                    startActivity(new Intent(MainActivity.this, ChangeClipBoundsActivity2.class));
                    break;
                case 7:
                    startActivity(new Intent(MainActivity.this, ComplexActivity.class));
                    break;
            }
        }
    }
}
