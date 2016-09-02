package com.erikkramli.androidexamples.main.infrastructure;

import com.erikkramli.androidexamples.api.model.Gender;
import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.main.ui.bind.CharacterBinder;
import com.erikkramli.androidexamples.main.ui.bind.DroidBinder;
import com.erikkramli.androidexamples.main.ui.bind.FemaleBinder;
import com.erikkramli.androidexamples.main.ui.bind.HermaphroditeBinder;
import com.erikkramli.androidexamples.main.ui.bind.MaleBinder;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class CharacterBindModule {

    @Provides
    @ActivityScope
    @IntoMap
    @StringKey(Gender.DROID)
    CharacterBinder provideDroidBinder(DroidBinder binder) {
        return binder;
    }

    @Provides
    @ActivityScope
    @IntoMap
    @StringKey(Gender.MALE)
    CharacterBinder provideMaleBinder(MaleBinder binder) {
        return binder;
    }

    @Provides
    @ActivityScope
    @IntoMap
    @StringKey(Gender.FEMALE)
    CharacterBinder provideFemaleBinder(FemaleBinder binder) {
        return binder;
    }

    @Provides
    @ActivityScope
    @IntoMap
    @StringKey(Gender.HERMAPHRODITE)
    CharacterBinder provideHermaphroditeBinder(HermaphroditeBinder binder) {
        return binder;
    }
}
