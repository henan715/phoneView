package com.example.nan.myphonestate.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nan.myphonestate.R;
import com.example.nan.myphonestate.adapter.SimpleAdapter;
import com.example.nan.myphonestate.model.SimpleKVmodel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ScrollFragment extends Fragment {
    private RecyclerView recyclerView;

    private ObservableScrollView mScrollView;

    public static ScrollFragment newInstance() {
        return new ScrollFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);

//        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView11);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setHasFixedSize(true);
//        ArrayList<SimpleKVmodel> items=new ArrayList<>();
//        items.add(new SimpleKVmodel("111","key1"));
//        items.add(new SimpleKVmodel("222","key2"));
//        items.add(new SimpleKVmodel("333","val1"));
//        items.add(new SimpleKVmodel("444","val2"));
//        items.add(new SimpleKVmodel("555","key1"));
//        items.add(new SimpleKVmodel("666","key2"));
//        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),items);
//        recyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }
}
