package com.erikkramli.androidexamples.application.infrastructure;

import com.erikkramli.androidexamples.api.infrastructure.ApiComponent;
import com.erikkramli.androidexamples.application.ExampleApplication;
import com.erikkramli.androidexamples.infrastructure.DiComponent;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = ApplicationModule.class
)
@Singleton
public interface ApplicationComponent extends DiComponent<ExampleApplication> {

    ApiComponent.Builder apiComponentBuilder();

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
