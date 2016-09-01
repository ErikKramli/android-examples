package com.erikkramli.androidexamples.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.main.infrastructure.MainComponent;
import com.erikkramli.androidexamples.main.ui.MainScreen;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainScreen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainComponent.IoC.satisfy(this);
        screen.create();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screen = null;
    }
}
