package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddIncome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill.AddBillFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;

/**
 * Created by connorroset on 11/14/16.
 */

public class AddIncomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.add_income));
        return inflater.inflate(R.layout.fragment_add_income, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //find selected item on Recycler view
        //convert it to string
        //extract text from text field
        //button.onclick = add purchase to top of purchase list

        Button submit = (Button)getActivity().findViewById(R.id.add_income_submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //navigate back to viewbudget
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ViewBudgetFragment vbf = new ViewBudgetFragment();
                ft.replace(R.id.fragment_container, vbf);
                ft.commit();
            }
        });
    }

}