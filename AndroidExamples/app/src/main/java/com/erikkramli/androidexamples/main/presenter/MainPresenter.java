package com.erikkramli.androidexamples.main.presenter;

public interface MainPresenter {

    interface Callback {
        void onSuccess(String msg);
        void onFailure();
    }

    void loadStarWarsCharacters(Callback callback);
}
