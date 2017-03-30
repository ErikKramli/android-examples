package com.erikkramli.androidexamples.loadmore;


import android.util.Log;
import android.widget.AbsListView;

public class LoadMoreListener implements AbsListView.OnScrollListener {

    interface Callback {
        void onMoreItemRequested();
    }

    private final Callback callback;

    LoadMoreListener(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int lastInScreen = firstVisibleItem + visibleItemCount;

        Log.d(":::", "first " + firstVisibleItem + " count " + visibleItemCount + " total " + totalItemCount);

        if (lastInScreen == totalItemCount) {
            callback.onMoreItemRequested();
        }
    }
}
