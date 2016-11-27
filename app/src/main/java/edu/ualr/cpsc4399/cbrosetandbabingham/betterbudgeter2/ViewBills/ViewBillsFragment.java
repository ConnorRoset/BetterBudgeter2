package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBills;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill.AddBillFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewIncomes.ViewIncomeRVAdapter;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewBillsFragment extends Fragment {
    RecyclerView rv;
    ViewBillsRVAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.view_bills));
        return inflater.inflate(R.layout.fragment_view_bills, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       rv = (RecyclerView)getActivity().findViewById(R.id.view_bills_list_of_bills_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ViewBillsRVAdapter(((MainActivity)getActivity()).getBudget().getBills(), getContext());
        rv.setAdapter(adapter);

        Button addBill = (Button)getActivity().findViewById(R.id.view_bills_add_button);
        addBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AddBillFragment abf = new AddBillFragment();
                ft.replace(R.id.fragment_container, abf);
                ft.commit();
            }
        });
    }

}
