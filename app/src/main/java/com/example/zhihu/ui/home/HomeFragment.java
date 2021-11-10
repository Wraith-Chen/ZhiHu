package com.example.zhihu.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.zhihu.R;

import com.example.zhihu.ui.home.recommend.Content;
import com.example.zhihu.ui.home.recommend.RecommendFragment;
import com.example.zhihu.ui.home.recommend.contentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private String[] tabs = {"关注", "推荐", "热榜", "11.11", "高赞", "知识", "心理", "脑洞"};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        TabLayout tabLayout = view.findViewById(R.id.home_title_tablayout);
        ViewPager2 viewPager = view.findViewById(R.id.home_title_pager);

        List<Fragment> list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());
        list.add(new RecommendFragment());

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getActivity(), list);
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(1,false);//修改默认标签页

        new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        }).attach();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    static class MyFragmentPagerAdapter extends FragmentStateAdapter {

        List<Fragment> list;

        public MyFragmentPagerAdapter(FragmentActivity fa, List<Fragment> list) {
            super(fa);
            this.list = list;

        }

        @NonNull
        @NotNull
        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}