package com.erikkramli.androidexamples.application.infrastructure;

import com.erikkramli.androidexamples.api.infrastructure.NetworkingComponent;
import com.erikkramli.androidexamples.application.ExampleApplication;
import com.erikkramli.androidexamples.infrastructure.DiComponent;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = ApplicationModule.class
)
@Singleton
public interface ApplicationComponent extends DiComponent<ExampleApplication> {

    NetworkingComponent.Builder networkingComponentBuilder();

    final class IoC {

        private static ApplicationComponent applicationComponent;

        public static void satisfy(ExampleApplication application) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(application))
                    .build();
            applicationComponent.satisfy(application);
        }

        public static ApplicationComponent getApplicationComponent() {
            return applicationComponent;
        }

        private IoC() {}
    }
}
