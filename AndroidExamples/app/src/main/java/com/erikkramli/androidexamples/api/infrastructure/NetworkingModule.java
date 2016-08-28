package com.erikkramli.androidexamples.api.infrastructure;

import com.erikkramli.androidexamples.infrastructure.NetworkingScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkingModule {

    @Provides
    @NetworkingScope
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @NetworkingScope
    OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
