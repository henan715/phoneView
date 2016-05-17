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
import com.example.nan.myphonestate.model.SimpleKVmodel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.

 */
public class BatteryFragment extends Fragment {
    @InjectView(R.id.sv_parent)
    ObservableScrollView mScrollView;
    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private SimpleAdapter simpleAdapter;
    private ArrayList<SimpleKVmodel> items;

    public BatteryFragment() {
        // Required empty public constructor
    }

    public BatteryFragment getInstance(){
        return new BatteryFragment();
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

        Hardware_Battery battery=new Hardware_Battery(getActivity().getApplicationContext());
        items.add(new SimpleKVmodel(battery.BATTERY_STATUS,battery.getBattery_status()));
        items.add(new SimpleKVmodel(battery.BATTERY_HEALTH,battery.getBattery_health()));
        items.add(new SimpleKVmodel(battery.BATTERY_LEVEL,battery.getBattery_level()));
        items.add(new SimpleKVmodel(battery.BATTERY_TEMPERATURE,battery.getBattery_temperature()));
        items.add(new SimpleKVmodel(battery.BATTERY_VOLTAGE,battery.getBattery_voltage()));
        items.add(new SimpleKVmodel(battery.BATTERY_PLUNGGED,battery.getBattery_plungged()));
        items.add(new SimpleKVmodel(battery.BATTERY_TECHNOLOGY,battery.getBattery_technology()));

        simpleAdapter=new SimpleAdapter(getActivity(),items);
        mRecyclerView.setAdapter(simpleAdapter);

        MaterialViewPagerHelper.registerScrollView(getActivity(),mScrollView,null);
    }
}
