package com.erikkramli.androidexamples.api.util;

import com.erikkramli.androidexamples.api.model.Gender;

import java.util.Locale;

public final class GenderMapper {

    @Gender
    public static String mapToAnnotation(String gender) {
        switch (gender.toLowerCase(Locale.ENGLISH)) {
            case Gender.DROID:
                return Gender.DROID;
            case Gender.MALE:
                return Gender.MALE;
            case Gender.FEMALE:
                return Gender.FEMALE;
            case Gender.HERMAPHRODITE:
            default:
                return Gender.HERMAPHRODITE;
        }
    }

    private GenderMapper() {}
}
