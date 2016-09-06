package com.erikkramli.androidexamples.infrastructure;

import android.databinding.DataBindingComponent;
import android.support.v7.app.AppCompatActivity;

import com.erikkramli.androidexamples.databinding.DataBindingComponentImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    AppCompatActivity provideAppCompatActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    DataBindingComponent provideDataBindingComponent(DataBindingComponentImpl impl) {
        return impl;
    }
}
