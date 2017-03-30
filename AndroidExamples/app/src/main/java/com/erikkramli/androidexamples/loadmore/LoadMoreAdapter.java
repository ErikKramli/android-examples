package com.erikkramli.androidexamples.loadmore;


import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.databinding.ListItemLoadMoreBinding;

import java.util.ArrayList;
import java.util.List;

final class LoadMoreAdapter extends BaseAdapter {

    private final List<String> items;

    LoadMoreAdapter() {
        items = new ArrayList<>();
    }

    void addItems(List<String> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemLoadMoreBinding binding;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.list_item_load_more, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListItemLoadMoreBinding) convertView.getTag();
        }

        String item = getItem(position);
        binding.label.setText(item);

        return convertView;
    }
}
