package com.erikkramli.androidexamples.main.di;

import com.erikkramli.androidexamples.application.di.ApplicationComponent;
import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.infrastructure.DiComponent;
import com.erikkramli.androidexamples.main.MainActivity;

import dagger.Component;

@Component(
        dependencies = ApplicationComponent.class
)
@ActivityScope
public interface MainComponent extends DiComponent<MainActivity> {

    final class IoC {
        public static void satisfy(MainActivity activity) {
            DaggerMainComponent.builder()
                    .applicationComponent(ApplicationComponent.IoC.getApplicationComponent())
                    .build()
                    .satisfy(activity);
        }
    }
}
