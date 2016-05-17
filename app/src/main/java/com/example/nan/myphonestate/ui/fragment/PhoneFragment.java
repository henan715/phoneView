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
public class PhoneFragment extends Fragment {
    @InjectView(R.id.sv_parent)
    ObservableScrollView mScrollView;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private SimpleAdapter simpleAdapter;
    private ArrayList<SimpleKVmodel> items;

    public PhoneFragment() {
        // Required empty public constructor
    }

    public PhoneFragment getInstance(){
        return new PhoneFragment();
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

        Hardware_Phone phone=new Hardware_Phone(getActivity().getApplicationContext());
        items.add(new SimpleKVmodel(phone.PHONE_BOARD,phone.getPhone_board()));
        items.add(new SimpleKVmodel(phone.PHONE_BOOTLOADER,phone.getPhone_bootloader()));
        items.add(new SimpleKVmodel(phone.PHONE_BRAND,phone.getPhone_brand()));
        items.add(new SimpleKVmodel(phone.PHONE_BUILDTIME,phone.getPhone_buildtime()));
        items.add(new SimpleKVmodel(phone.PHONE_DEVICE,phone.getPhone_device()));
        items.add(new SimpleKVmodel(phone.PHONE_HARDWARE,phone.getPhone_hardware()));
        items.add(new SimpleKVmodel(phone.PHONE_MANUFACTER,phone.getPhone_manufacter()));
        items.add(new SimpleKVmodel(phone.PHONE_PRODUCT,phone.getPhone_product()));

        simpleAdapter=new SimpleAdapter(getActivity(),items);
        mRecyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(),mScrollView,null);
    }
}
