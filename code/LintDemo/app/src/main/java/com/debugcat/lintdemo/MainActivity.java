package com.debugcat.lintdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int paintColor = 0xe8554d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv_hello);
        tv.setTextColor(0xfcfcfc);
        tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        tv.getPaint().setColor(paintColor);
        tv.getPaint().setColorFilter(new PorterDuffColorFilter(paintColor, PorterDuff.Mode.SRC_ATOP));
        setTextColor("hhhhh");
    }

    private void setTextColor(String color) {

    }
}
