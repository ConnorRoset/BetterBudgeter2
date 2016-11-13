package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/12/16.
 */

public class ManageIncomesFragment extends MenuOptionsFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.manage_incomes));
        return inflater.inflate(R.layout.fragment_manage_incomes, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        TextView temp = (TextView)getActivity().findViewById(R.id.manage_incomes_total_tv);
        int temp2 = 0;
        temp2 = ((MainActivity)this.getActivity()).getBudget().getIncomes().size();
        temp.setText(String.valueOf(temp2));
    }
}
