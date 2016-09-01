package com.erikkramli.androidexamples.main.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.main.presenter.MainPresenter;
import com.erikkramli.androidexamples.util.ViewUtils;

import javax.inject.Inject;

public class MainScreenImpl implements MainScreen, MainPresenter.Callback {

    private final AppCompatActivity activity;
    private final MainPresenter presenter;

    private MainActivityBinding binding;

    @Inject
    public MainScreenImpl(AppCompatActivity activity, MainPresenter presenter) {
        this.activity = activity;
        this.presenter = presenter;
    }

    @Override
    public void create() {
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

        ViewUtils.gone(binding.text);
        ViewUtils.visible(binding.progress);
        presenter.loadStarWarsCharacters(this);
    }

    @Override
    public void onSuccess(String msg) {
        ViewUtils.gone(binding.progress);
        ViewUtils.visible(binding.text);
        binding.text.setText(msg);
    }

    @Override
    public void onFailure() {
        ViewUtils.gone(binding.progress);
        ViewUtils.visible(binding.text);
        binding.text.setText("Nooooo :(");
    }
}
