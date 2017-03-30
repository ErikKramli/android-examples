package com.erikkramli.androidexamples.loadmore;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.databinding.ActivityLoadMoreBinding;


public class LoadMoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoadMoreBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_load_more);
    }

    public static Intent createLaunchIntent(Context context) {
        return new Intent(context, LoadMoreActivity.class);
    }
}
