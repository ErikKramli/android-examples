package com.erikkramli.androidexamples.main.infrastructure;

import com.erikkramli.androidexamples.api.infrastructure.ApiComponent;
import com.erikkramli.androidexamples.api.infrastructure.ApiModule;
import com.erikkramli.androidexamples.api.infrastructure.NetworkingModule;
import com.erikkramli.androidexamples.application.infrastructure.ApplicationComponent;
import com.erikkramli.androidexamples.infrastructure.ActivityModule;
import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.infrastructure.DiComponent;
import com.erikkramli.androidexamples.main.MainActivity;

import dagger.Component;

@Component(
        dependencies = ApiComponent.class,
        modules = {
                ActivityModule.class,
                MainModule.class
        }
)
@ActivityScope
public interface MainComponent extends DiComponent<MainActivity> {

    final class IoC {
        public static void satisfy(MainActivity activity) {
            ApiComponent apiComponent = ApplicationComponent.IoC.getApplicationComponent()
                    .apiComponentBuilder()
                    .apiModule(new ApiModule())
                    .networkingModule(new NetworkingModule())
                    .build();

            DaggerMainComponent.builder()
                    .apiComponent(apiComponent)
                    .activityModule(new ActivityModule(activity))
                    .build()
                    .satisfy(activity);
        }

        private IoC() {}
    }
}
