package com.erikkramli.androidexamples.application.infrastructure;

import com.erikkramli.androidexamples.application.ExampleApplication;
import com.erikkramli.androidexamples.infrastructure.DependencyGraph;
import com.erikkramli.androidexamples.infrastructure.DiComponent;

import javax.inject.Singleton;

import dagger.Component;

@Component(
        modules = ApplicationModule.class
)
@Singleton
public interface ApplicationComponent extends DiComponent<ExampleApplication> {

    final class IoC {

        public static void satisfy(ExampleApplication application) {
            ApplicationComponent component = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(application))
                    .build();
            DependencyGraph.setApplicationComponent(component);
            component.satisfy(application);
        }

        private IoC() {}
    }
}
