package com.erikkramli.androidexamples.loadmore;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.databinding.ActivityLoadMoreBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class LoadMoreActivity extends AppCompatActivity {

    private ActivityLoadMoreBinding binding;
    private LoadMoreAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_load_more);

        adapter = new LoadMoreAdapter();
        binding.loadMoreList.setAdapter(adapter);

        loadMore(0, 20);
    }

    private void loadMore(final int offset, final int limit) {
        Observable
                .fromCallable(new Callable<List<String>>() {
                    @Override
                    public List<String> call() throws Exception {
                        List<String> dummyItems = new ArrayList<>();
                        for (int i = offset, n = offset+limit; i<n; i++) {
                            dummyItems.add(String.valueOf(i));
                        }
                        return dummyItems;
                    }
                })
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> items) {
                        adapter.addItems(items);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(":::", throwable.toString());
                        Log.e(":::", throwable.getMessage());
                    }
                });
    }


    public static Intent createLaunchIntent(Context context) {
        return new Intent(context, LoadMoreActivity.class);
    }
}
