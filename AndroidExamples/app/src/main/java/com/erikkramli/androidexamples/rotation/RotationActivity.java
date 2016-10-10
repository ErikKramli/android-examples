package com.erikkramli.androidexamples.rotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.erikkramli.androidexamples.R;

import javax.inject.Inject;
import javax.inject.Provider;


public class RotationActivity extends AppCompatActivity implements RotationPresenter.Callbacks {

    @Inject
    Provider<RotationPresenter> presenterProvider;

    private RotationPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
        RotationComponent.IoC.satisfy(this);


        findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.load();
            }
        });

        findViewById(R.id.stop_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.stop();
            }
        });

        RotationPresenter p = (RotationPresenter) getLastCustomNonConfigurationInstance();
        if (p == null) {
            presenter = presenterProvider.get();
        } else {
            presenter = p;
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setCallbacks(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.setCallbacks(null);
    }

    @Override
    public void onLoad(String text) {
        TextView textView = (TextView) findViewById(R.id.rotation_text);
        textView.setText(text);
    }
}
