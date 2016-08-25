package com.erikkramli.androidexamples.application;

import android.app.Application;

import com.erikkramli.androidexamples.application.di.ApplicationComponent;

public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationComponent.IoC.satisfy(this);
    }
}
