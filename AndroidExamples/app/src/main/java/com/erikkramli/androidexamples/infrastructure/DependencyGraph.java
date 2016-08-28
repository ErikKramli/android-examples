package com.erikkramli.androidexamples.infrastructure;

import com.erikkramli.androidexamples.application.infrastructure.ApplicationComponent;

public final class DependencyGraph {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static void setApplicationComponent(ApplicationComponent applicationComponent) {
        DependencyGraph.applicationComponent = applicationComponent;
    }

    private DependencyGraph() {}
}
