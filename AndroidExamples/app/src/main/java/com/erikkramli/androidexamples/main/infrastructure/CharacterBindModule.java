package com.erikkramli.androidexamples.main.infrastructure;

import com.erikkramli.androidexamples.api.model.Gender;
import com.erikkramli.androidexamples.infrastructure.ActivityScope;
import com.erikkramli.androidexamples.main.ui.bind.CharacterBinder;
import com.erikkramli.androidexamples.main.ui.bind.DroidBinder;
import com.erikkramli.androidexamples.main.ui.bind.FemaleBinder;
import com.erikkramli.androidexamples.main.ui.bind.HermaphroditeBinder;
import com.erikkramli.androidexamples.main.ui.bind.MaleBinder;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class CharacterBindModule {

    @Binds
    @ActivityScope
    @IntoMap @StringKey(Gender.DROID)
    abstract CharacterBinder provideDroidBinder(DroidBinder binder);

    @Binds
    @ActivityScope
    @IntoMap @StringKey(Gender.MALE)
    abstract CharacterBinder provideMaleBinder(MaleBinder binder);

    @Binds
    @ActivityScope
    @IntoMap @StringKey(Gender.FEMALE)
    abstract CharacterBinder provideFemaleBinder(FemaleBinder binder);

    @Binds
    @ActivityScope
    @IntoMap @StringKey(Gender.HERMAPHRODITE)
    abstract CharacterBinder provideHermaphroditeBinder(HermaphroditeBinder binder);
}
