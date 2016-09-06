package com.erikkramli.androidexamples.api.infrastructure;

import android.content.res.Resources;
import android.view.LayoutInflater;

import com.erikkramli.androidexamples.api.StarWarsRepository;
import com.erikkramli.androidexamples.infrastructure.NetworkingScope;

import dagger.Subcomponent;

@Subcomponent(
        modules = {
                ApiModule.class,
                NetworkingModule.class
        }
)
@NetworkingScope
public interface ApiComponent {

    StarWarsRepository starWarsRepository();
    LayoutInflater inflater();
    Resources resources();

    @Subcomponent.Builder
    interface Builder {
        Builder apiModule(ApiModule module);
        Builder networkingModule(NetworkingModule module);
        ApiComponent build();
    }
}
