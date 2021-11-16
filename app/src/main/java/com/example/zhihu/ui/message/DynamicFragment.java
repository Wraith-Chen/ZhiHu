package com.example.zhihu.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zhihu.R;

import org.jetbrains.annotations.NotNull;

public class DynamicFragment extends Fragment {
    private View view;


    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.message_dynamic,container,false);
        return view;
    }


}
