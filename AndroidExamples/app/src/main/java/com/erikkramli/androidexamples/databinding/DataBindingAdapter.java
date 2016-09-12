package com.erikkramli.androidexamples.databinding;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.support.annotation.ColorInt;
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

    @BindingAdapter({"binding:bgColor"})
    public void setBackgroundColor(View view, int colorRes) {
        @ColorInt int color = resources.getColor(colorRes);

        int alpha = 100;
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        color = Color.argb(alpha, red, green, blue);
        view.setBackgroundColor(color);
    }
}
