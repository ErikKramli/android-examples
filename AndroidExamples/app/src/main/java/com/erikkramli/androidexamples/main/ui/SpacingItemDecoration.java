package com.erikkramli.androidexamples.main.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public final class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spacing;

    public SpacingItemDecoration(int spacingInPixel) {
        spacing = spacingInPixel;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing;

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = spacing;
        }
    }
}
