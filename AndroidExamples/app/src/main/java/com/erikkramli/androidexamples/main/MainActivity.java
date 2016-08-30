package com.erikkramli.androidexamples.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.main.infrastructure.MainComponent;
import com.erikkramli.androidexamples.main.ui.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent.IoC.satisfy(this);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.text.setText("Hello");
    }
}
