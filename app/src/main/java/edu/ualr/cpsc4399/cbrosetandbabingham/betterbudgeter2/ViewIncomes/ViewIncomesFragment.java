package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewIncomes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill.AddBillFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddIncome.AddIncomeFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewIncomesFragment extends Fragment {
    RecyclerView rv;
    ViewIncomeRVAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle(getResources().getString(R.string.view_incomes));
        return inflater.inflate(R.layout.fragment_view_incomes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv =  (RecyclerView)getActivity().findViewById(R.id.view_incomes_list_of_incomes_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setHasFixedSize(true);


        adapter = new ViewIncomeRVAdapter(((MainActivity)getActivity()).getBudget().getIncomes());
        rv.setAdapter(adapter);
        Button addIncome = (Button)getActivity().findViewById(R.id.view_incomes_add_button);
        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AddIncomeFragment aif = new AddIncomeFragment();
                ft.replace(R.id.fragment_container, aif);
                ft.commit();
            }
        });

//        Button removeIncome = (Button)getActivity().findViewById(R.id.view_incomes_delete_button);
//        removeIncome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //(MainActivity)((MainActivity) getActivity()).getBudget().removeIncome();
//                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
    }
}
