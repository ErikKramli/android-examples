package com.erikkramli.androidexamples.main.infrastructure;

import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.main.interactor.AllCharacterInteractor;
import com.erikkramli.androidexamples.main.interactor.AllCharacterInteractorImpl;
import com.erikkramli.androidexamples.main.presenter.MainPresenter;
import com.erikkramli.androidexamples.main.presenter.MainPresenterImpl;
import com.erikkramli.androidexamples.main.ui.MainScreen;
import com.erikkramli.androidexamples.main.ui.MainScreenImpl;
import com.erikkramli.androidexamples.main.ui.render.CharacterRender;
import com.erikkramli.androidexamples.main.ui.render.CharacterRenderImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    @ActivityScope
    abstract MainScreen provideScreen(MainScreenImpl impl);

    @Binds
    @ActivityScope
    abstract CharacterRender provideCharacterRender(CharacterRenderImpl impl);

    @Binds
    @ActivityScope
    abstract MainPresenter providePresenter(MainPresenterImpl impl);

    @Binds
    @ActivityScope
    abstract AllCharacterInteractor provideInteractor(AllCharacterInteractorImpl impl);
}
