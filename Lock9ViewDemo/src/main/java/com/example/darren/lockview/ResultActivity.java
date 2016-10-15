package com.example.darren.lockview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.darren.guesture.views.GestureHandler;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showgesturepwd);
        String password = getIntent().getStringExtra("password");
        View sg = findViewById(R.id.sg);
        GestureHandler.setImage(sg, password);
    }

}
