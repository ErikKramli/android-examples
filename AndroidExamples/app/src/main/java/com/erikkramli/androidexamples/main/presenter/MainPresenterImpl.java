package com.erikkramli.androidexamples.main.presenter;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.interactor.AllCharacterInteractor;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {

    private final AllCharacterInteractor interactor;

    @Inject
    public MainPresenterImpl(AllCharacterInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void loadStarWarsCharacters(final Callback callback) {
        Observable
                .fromCallable(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        List<StarWarsCharacter> characters = interactor.getAllStarWarsCharacter();
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
                        callback.onSuccess(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        callback.onFailure();
                    }
                });
    }
}
