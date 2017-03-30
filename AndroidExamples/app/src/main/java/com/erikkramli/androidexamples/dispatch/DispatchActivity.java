package com.erikkramli.androidexamples.dispatch;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.databinding.ActivityDispatchBinding;
import com.erikkramli.androidexamples.loadmore.LoadMoreActivity;


public class DispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDispatchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dispatch);

        binding.listPoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoadMoreActivity.createLaunchIntent(DispatchActivity.this));
            }
        });
    }
}
