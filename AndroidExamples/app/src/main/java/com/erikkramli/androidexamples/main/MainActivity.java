package com.erikkramli.androidexamples.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.main.infrastructure.MainComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent.IoC.satisfy(this);

        setContentView(R.layout.activity_main);
    }
}
