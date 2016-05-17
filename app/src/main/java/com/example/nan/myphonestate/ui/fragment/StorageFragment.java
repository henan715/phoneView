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
import com.example.nan.myphonestate.hardware.Hardware_Storage;
import com.example.nan.myphonestate.model.SimpleKVmodel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.

 */
public class StorageFragment extends Fragment {
    @InjectView(R.id.sv_parent)
    ObservableScrollView mScrollView;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private SimpleAdapter simpleAdapter;
    private ArrayList<SimpleKVmodel> items;

    public StorageFragment() {
        // Required empty public constructor
    }

    public StorageFragment getInstance(){
        return new StorageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        Hardware_Storage storage=new Hardware_Storage();
        items.add(new SimpleKVmodel(storage.INTERNAL_STORAGE_TOTALSIZE,storage.getInternalStorageSize()));
        items.add(new SimpleKVmodel(storage.INTERNAL_STORAGE_USEDSIZE,storage.getInternalStorageUsed()));
        items.add(new SimpleKVmodel(storage.INTERNAL_STORAGE_FREESIZE,storage.getInternalStorageFree()));
        items.add(new SimpleKVmodel(storage.EXTERNAL_STORAGE_TOTALSIZE,storage.getExternalStorageSize()));
        items.add(new SimpleKVmodel(storage.EXTERNAL_STORAGE_USEDSIZE,storage.getExternalStorageUsed()));
        items.add(new SimpleKVmodel(storage.EXTERNAL_SOTRAGE_FREESIZE,storage.getExternalStorageFree()));

        simpleAdapter=new SimpleAdapter(getActivity(),items);
        mRecyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(),mScrollView,null);
    }
}
