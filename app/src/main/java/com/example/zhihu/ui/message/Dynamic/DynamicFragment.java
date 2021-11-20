package com.example.zhihu.ui.message.Dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;
import com.example.zhihu.ui.home.recommend.Content;
import com.example.zhihu.ui.home.recommend.contentAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DynamicFragment extends Fragment {
    private View view;

    private ArrayList<Dynamic_context> list = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.message_dynamic,container,false);
        initContext();
        initRecyclerView();
        return view;
    }
    public void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.dynamic_recycler);
        DynamicAdapter adapter = new DynamicAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
    public void initContext(){
        for(int i = 0 ;i<20;i++){
            Dynamic_context dynamic_context = new Dynamic_context();
            dynamic_context.setProfile(R.drawable.item_picture);
            dynamic_context.setName("陈末末");
            dynamic_context.setState("赞同了回答·9小时前");
            dynamic_context.setContext("本人积极参加演员选拔，是车辆负责人兼学院负责人。在校排练期间，训练认真听各位导演指挥，牢记每一个动作，并且帮助身边同学快速掌握动作要领。在理工大排练期间，每天认真配合学校和导演组工作，清点人数，搬运餐车，发放餐食，带动大家按时备场排练。在西铁院锁闭期，为生病同学带饭送药k");
            dynamic_context.setInformation("匿名用户的回答·1.6万赞·468评论");
            dynamic_context.setPicture(R.drawable.item_picture);
            list.add(dynamic_context);
        }
    }
}
