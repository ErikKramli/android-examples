package com.erikkramli.androidexamples.main.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int dividerSize;

    public DividerItemDecoration() {
        dividerSize = 20;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = dividerSize;
            outRect.bottom = dividerSize / 2;

        } else if (parent.getChildAdapterPosition(view) == (parent.getChildCount() -1)) {
            outRect.top = dividerSize / 2;
            outRect.bottom = dividerSize;

        } else {
            outRect.top = dividerSize / 2;
            outRect.bottom = dividerSize / 2;
        }
    }
}
