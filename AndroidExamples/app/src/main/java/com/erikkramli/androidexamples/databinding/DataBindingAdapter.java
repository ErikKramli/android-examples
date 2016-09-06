package com.erikkramli.androidexamples.databinding;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.api.model.Gender;

public final class DataBindingAdapter {

    private final Resources resources;

    public DataBindingAdapter(Resources resources) {
        this.resources = resources;
    }

    @BindingAdapter({"binding:gender"})
    public void setGender(TextView view, String gender) {
        switch (gender) {
            case Gender.DROID:
                view.setText(R.string.droid);
                break;
            case Gender.MALE:
                view.setText(R.string.male);
                break;
            case Gender.FEMALE:
                view.setText(R.string.female);
                break;
            case Gender.HERMAPHRODITE:
                view.setText(R.string.hermaphrodite);
                break;
            default:
                view.setText(gender);
        }
    }
}
