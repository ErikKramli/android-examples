package com.erikkramli.androidexamples.application.di;

import android.content.Context;
import android.content.res.Resources;

import com.erikkramli.androidexamples.application.ExampleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final ExampleApplication application;

    public ApplicationModule(ExampleApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }
}
