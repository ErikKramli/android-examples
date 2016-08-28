package com.erikkramli.androidexamples.api.infrastructure;

import com.erikkramli.androidexamples.api.StarWarsApi;
import com.erikkramli.androidexamples.infrastructure.NetworkingScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @NetworkingScope
    StarWarsApi provideStarWarsApi(Converter.Factory converterFactory, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(StarWarsApi.BASE_URL)
                .addConverterFactory(converterFactory)
                .client(httpClient)
                .build()
                .create(StarWarsApi.class);
    }
}
