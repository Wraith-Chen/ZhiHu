package com.example.zhihu.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.zhihu.R;
import com.example.zhihu.databinding.FragmentMessageBinding;
import com.example.zhihu.ui.home.HomeFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    private String[] tabs = {"动态", "消息"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){

        TabLayout tabLayout = view.findViewById(R.id.message_toolbar_tablayout);
        ViewPager2 viewPager = view.findViewById(R.id.message_toolbar_viewpager);

        List<Fragment> list  = new ArrayList<>();
        list.add(new DynamicFragment());
        list.add(new ChatFragment());


        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getActivity(), list);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        }).attach();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
