package com.erikkramli.androidexamples.application.infrastructure;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;

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

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater() {
        return (LayoutInflater) application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
