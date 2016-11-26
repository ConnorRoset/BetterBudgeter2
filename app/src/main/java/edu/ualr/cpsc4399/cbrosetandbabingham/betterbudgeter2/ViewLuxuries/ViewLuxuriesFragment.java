package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewLuxuries;

/**
 * Created by connorroset on 11/14/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewPurchases.ViewPurchasesRVAdapter;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewLuxuriesFragment extends Fragment {
    RecyclerView recyclerView;
    ViewLuxuriesRVAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.view_luxuries));
        return inflater.inflate(R.layout.fragment_view_luxuries, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.view_luxuries_list_of_luxuries_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ViewLuxuriesRVAdapter(((MainActivity)getActivity()).getBudget().getLuxuries());
        recyclerView.setAdapter(adapter);
    }
}