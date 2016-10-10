package com.erikkramli.androidexamples.rotation;

import com.erikkramli.androidexamples.application.infrastructure.ApplicationComponent;
import com.erikkramli.androidexamples.infrastructure.ActivityScope;

import dagger.Component;

@Component(
        dependencies = ApplicationComponent.class
)
@ActivityScope
public interface RotationComponent {

    void satisfy(RotationActivity activity);

    final class IoC {
        public static void satisfy(RotationActivity activity) {
            DaggerRotationComponent.builder()
                    .applicationComponent(ApplicationComponent.IoC.getApplicationComponent())
                    .build()
                    .satisfy(activity);
        }

        private IoC() {}
    }
}
