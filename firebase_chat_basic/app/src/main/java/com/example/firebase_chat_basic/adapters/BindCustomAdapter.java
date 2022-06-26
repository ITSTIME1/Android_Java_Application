package com.example.firebase_chat_basic.adapters;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * [BindCustomAdapter]
 *
 * This is very usefully because that using with databinding automatically setAdapter.
 * and then using "ViewModel" more usefully because that in xml can setAdapter.
 */


public class BindCustomAdapter {

    @BindingAdapter("Adapter")
    public static void chatAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
