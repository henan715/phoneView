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
import com.example.nan.myphonestate.hardware.Hardware_OS;
import com.example.nan.myphonestate.hardware.Hardware_Phone;
import com.example.nan.myphonestate.model.SimpleKVmodel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.

 */
public class OsFragment extends Fragment {
    @InjectView(R.id.sv_parent)
    ObservableScrollView mScrollView;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private SimpleAdapter simpleAdapter;
    private ArrayList<SimpleKVmodel> items;

    public OsFragment() {
        // Required empty public constructor
    }

    public OsFragment getInstance(){
        return new OsFragment();
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

        Hardware_OS os=new Hardware_OS(getActivity().getApplicationContext());
        items.add(new SimpleKVmodel(os.OS_BASE_OS,os.getBaseOS()));
        items.add(new SimpleKVmodel(os.OS_CODENAME,os.getCodeName()));
        items.add(new SimpleKVmodel(os.OS_INCREMENTAL,os.getIncremental()));
        items.add(new SimpleKVmodel(os.OS_SDK_NAME,os.getSdkName()));
        items.add(new SimpleKVmodel(os.OS_SDK_RELEASE,os.getSdkRelease()));
        items.add(new SimpleKVmodel(os.OS_SDK_VERSION,os.getSdkVersion()));

        simpleAdapter=new SimpleAdapter(getActivity(),items);
        mRecyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(),mScrollView,null);
    }
}
