package com.example.zhihu.ui.home.recommend;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;

import java.util.ArrayList;

public class RecommendFragment extends Fragment {

    private View view;
    private ArrayList<Content> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_recommend, container, false);
        initcontent();
        initRecyclerView();
        return view;
    }

    public void initcontent() {
        for (int i = 0; i < 20; i++) {
            Content content = new Content();
            content.setTitle("下一轮”双一流“，这些双飞稳了");
            content.setProfile(R.drawable.item_profile);
            content.setName("峰考");
            content.setAuthentication(R.drawable.item_authentication);
            content.setInformation("已认证的官方账号");
            content.setPicture(R.drawable.item_picture);
            content.setText("本人积极参加演员选拔，是车辆负责人兼学院负责人。在校排练期间，训练认真听各位导演指挥，牢记每一个动作，并且帮助身边同学快速掌握动作要领。在理工大排练期间，每天认真配合学校和导演组工作，清点人数，搬运餐车，发放餐食，带动大家按时备场排练。在西铁院锁闭期，为生病同学带饭送药");
            content.setComment("70亿赞同 · 15亿评论");
            content.setSetting(R.drawable.item_setting);
            list.add(content);
        }
    }

    private void initRecyclerView() {

        RecyclerView recyclerView = view.findViewById(R.id.recommend_recyclerview);
        contentAdapter adapter = new contentAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            private float mEndY;
            private float mStartY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mStartY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mEndY = event.getY();
                        float v1 = mEndY - mStartY;
                        if (v1 > 0) {
                            //我这个是在fragment中的操作 这个是获取activity中的布局
                            getActivity().findViewById(R.id.home_title).setVisibility(View.VISIBLE);
                            //这个就是当前页面的头布局id
                        } else if (v1 < 0) {
                            getActivity().findViewById(R.id.home_title).setVisibility(View.GONE);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return gestureDetector.onTouchEvent(event);
            }
        });
    }

    GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // do something
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    });
}

