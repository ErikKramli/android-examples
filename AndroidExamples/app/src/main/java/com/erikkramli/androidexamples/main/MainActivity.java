package com.erikkramli.androidexamples.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.api.StarWarsRepository;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.infrastructure.MainComponent;
import com.erikkramli.androidexamples.main.ui.MainActivityBinding;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    StarWarsRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent.IoC.satisfy(this);

        final MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.text.setText("Loading Star Wars characters");

        Observable
                .fromCallable(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        List<StarWarsCharacter> characters = repository.getCharacters(1);
                        StringBuilder sb = new StringBuilder();
                        for (StarWarsCharacter c : characters) {
                            sb.append(c.getName()).append('\n');
                        }
                        return sb.toString();
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        binding.text.setText(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        binding.text.setText(throwable.getMessage());
                    }
                });
    }
}
