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
import com.example.nan.myphonestate.hardware.Hardware_Battery;
import com.example.nan.myphonestate.hardware.Hardware_RAM;
import com.example.nan.myphonestate.model.SimpleKVmodel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Nan on 2016/5/12.
 */
public class RamFragment extends Fragment {
    @InjectView(R.id.sv_parent)
    ObservableScrollView mScrollView;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private SimpleAdapter simpleAdapter;
    private ArrayList<SimpleKVmodel> items;

    public RamFragment() {
        // Required empty public constructor
    }

    public RamFragment getInstance(){
        return new RamFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.inject(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        items=new ArrayList<>();

        Hardware_RAM ram=new Hardware_RAM(getActivity().getApplicationContext());
        items.add(new SimpleKVmodel(ram.RAM_TOTAL,ram.getTotal_ram()));
        items.add(new SimpleKVmodel(ram.RAM_FREE,ram.getFree_ram()));
        items.add(new SimpleKVmodel(ram.RAM_USED,ram.getUsed_ram()));

        simpleAdapter=new SimpleAdapter(getActivity(),items);
        mRecyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(),mScrollView,null);
    }
}
