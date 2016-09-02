package com.erikkramli.androidexamples.main.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.presenter.MainPresenter;
import com.erikkramli.androidexamples.util.ViewUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainScreenImpl implements MainScreen, MainPresenter.Callback {

    private final AppCompatActivity activity;
    private final MainPresenter presenter;
    private final Provider<CharactersAdapter> adapterProvider;

    private MainActivityBinding binding;
    private CharactersAdapter adapter;

    @Inject
    public MainScreenImpl(AppCompatActivity activity, MainPresenter presenter, Provider<CharactersAdapter> adapterProvider) {
        this.activity = activity;
        this.presenter = presenter;
        this.adapterProvider = adapterProvider;
    }

    @Override
    public void create() {
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

        adapter = adapterProvider.get();
        binding.list.setAdapter(adapter);

        ViewUtils.gone(binding.text, binding.list);
        ViewUtils.visible(binding.progress);
        presenter.loadStarWarsCharacters(this);
    }

    @Override
    public void onSuccess(List<StarWarsCharacter> characters) {
        ViewUtils.gone(binding.progress, binding.text);
        ViewUtils.visible(binding.list);
        adapter.setCharacters(characters);
    }

    @Override
    public void onFailure() {
        ViewUtils.gone(binding.progress, binding.list);
        ViewUtils.visible(binding.text);
        binding.text.setText("Nooooo :(");
    }
}
