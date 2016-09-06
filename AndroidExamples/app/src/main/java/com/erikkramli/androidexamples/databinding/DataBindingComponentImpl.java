package com.erikkramli.androidexamples.databinding;

import android.content.res.Resources;
import android.databinding.DataBindingComponent;

import javax.inject.Inject;

public class DataBindingComponentImpl implements DataBindingComponent {

    private final DataBindingAdapter bindingAdapter;

    @Inject
    public DataBindingComponentImpl(Resources resources) {
        bindingAdapter = new DataBindingAdapter(resources);
    }

    @Override
    public DataBindingAdapter getDataBindingAdapter() {
        return bindingAdapter;
    }
}
