package com.erikkramli.androidexamples.api.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({Gender.DROID, Gender.MALE, Gender.FEMALE, Gender.HERMAPHRODITE})
@Retention(RetentionPolicy.SOURCE)
public @interface Gender {
    String DROID = "n/a";
    String MALE = "male";
    String FEMALE = "female";
    String HERMAPHRODITE = "hermaphrodite";
}
