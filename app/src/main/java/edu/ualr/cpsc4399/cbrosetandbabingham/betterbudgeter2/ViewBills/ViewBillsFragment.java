package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBills;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill.AddBillFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewBillsFragment extends Fragment {
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
