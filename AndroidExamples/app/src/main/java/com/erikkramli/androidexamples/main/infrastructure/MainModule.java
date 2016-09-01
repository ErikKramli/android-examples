package com.erikkramli.androidexamples.main.infrastructure;

import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.main.interactor.AllCharacterInteractor;
import com.erikkramli.androidexamples.main.interactor.AllCharacterInteractorImpl;
import com.erikkramli.androidexamples.main.ui.MainScreen;
import com.erikkramli.androidexamples.main.ui.MainScreenImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class MainModule {

    @Provides
    @ActivityScope
    MainScreen provideScreen(MainScreenImpl impl) {
        return impl;
    }

    @Provides
    @ActivityScope
    AllCharacterInteractor provideInteractor(AllCharacterInteractorImpl impl) {
        return impl;
    }
}
