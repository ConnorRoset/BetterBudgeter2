package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewPurchases;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewPurchasesFragment extends Fragment {

    RecyclerView recyclerView;
    ViewPurchasesRVAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.view_purchases));
        return inflater.inflate(R.layout.fragment_view_purchases, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView)getActivity().findViewById(R.id.view_purchases_list_of_purchases_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ViewPurchasesRVAdapter(((MainActivity)getActivity()).getBudget().getPurchases());
        recyclerView.setAdapter(adapter);
    }
}
