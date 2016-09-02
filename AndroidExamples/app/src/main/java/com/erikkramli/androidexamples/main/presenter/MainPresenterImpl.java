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
                .fromCallable(new Callable<List<StarWarsCharacter>>() {
                    @Override
                    public List<StarWarsCharacter> call() throws Exception {
                        return interactor.getAllStarWarsCharacter();
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<StarWarsCharacter>>() {
                    @Override
                    public void call(List<StarWarsCharacter> characters) {
                        callback.onSuccess(characters);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        callback.onFailure();
                    }
                });
    }
}
