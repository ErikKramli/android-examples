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
import com.erikkramli.androidexamples.databinding.ListFooterLoadMoreBinding;
import com.erikkramli.androidexamples.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class LoadMoreActivity extends AppCompatActivity {

    private ActivityLoadMoreBinding binding;
    private ListFooterLoadMoreBinding footerBinding;
    private LoadMoreAdapter adapter;

    private Subscription loadMoreSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_load_more);
        footerBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.list_footer_load_more, null, false);

        adapter = new LoadMoreAdapter();
        binding.loadMoreList.addFooterView(footerBinding.getRoot());
        binding.loadMoreList.setOnScrollListener(new LoadMoreListener(loadMoreCallback));
        binding.loadMoreList.setAdapter(adapter);

        ViewUtils.gone(footerBinding.loadMoreContainer);
    }

    LoadMoreListener.Callback loadMoreCallback = new LoadMoreListener.Callback() {
        @Override
        public void onMoreItemRequested() {
            if (loadMoreSubscription == null) {
                ViewUtils.visible(footerBinding.loadMoreContainer);
                Log.d(":::", "load more triggered");
                loadMore(adapter.getCount(), 20);
            }
        }
    };

    private void loadMore(final int offset, final int limit) {
        loadMoreSubscription = Observable
                .fromCallable(new Callable<List<String>>() {
                    @Override
                    public List<String> call() throws Exception {
                        List<String> dummyItems = new ArrayList<>();
                        if (offset < 60) {
                            for (int i = offset, n = offset + limit; i < n; i++) {
                                dummyItems.add(String.valueOf(i));
                            }
                        }
                        return dummyItems;
                    }
                })
                .delay(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> items) {
                        onItemsLoaded(items);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        onItemsLoadFailure(throwable);
                    }
                });
    }

    void onItemsLoaded(List<String> items) {
        adapter.addItems(items);
        stop();
    }

    void onItemsLoadFailure(Throwable throwable) {
        Log.e(":::", throwable.toString());
        Log.e(":::", throwable.getMessage());
        stop();
    }

    private void stop() {
        ViewUtils.gone(footerBinding.loadMoreContainer);
        if (loadMoreSubscription != null) {
            loadMoreSubscription.unsubscribe();
            loadMoreSubscription = null;
        }
    }


    public static Intent createLaunchIntent(Context context) {
        return new Intent(context, LoadMoreActivity.class);
    }
}
