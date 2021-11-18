package com.example.zhihu.ui.message.Dynamic;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder> {

    private List<Dynamic_context> list;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
    }


}
