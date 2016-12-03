package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/14/16.
 */

public class ViewBudgetFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.view_budget));
        return inflater.inflate(R.layout.fragment_view_budget, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //purchases
        TextView purchaseBudget = (TextView) getActivity().findViewById(R.id.view_budget_purchases_amount_remaining_text_view);
        purchaseBudget.setText(String.valueOf(((MainActivity)getActivity()).getBudget().getBudgetRemainingForPurchases()));

        //luxuries
        TextView luxuryBudget = (TextView) getActivity().findViewById(R.id.view_budget_luxuries_amount_remaining_text_view);
        luxuryBudget.setText(String.valueOf(((MainActivity)getActivity()).getBudget().getBudgetRemainingForLuxuries()));

        //unpaid bills
        TextView unPaidBills = (TextView) getActivity().findViewById(R.id.view_budget_unpaid_bills_number_remaining_text_view);
        unPaidBills.setText(String.valueOf(((MainActivity)getActivity()).getBudget().getNumberUnPaidBills()));
        Button button = (Button) getActivity().findViewById(R.id.reset_monthly_budget_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getBudget().resetMonthlyBudget();
//                ((MainActivity) getActivity()).getBudget().updateBudget();
                ((MainActivity) getActivity()).saveBudget();
            }
        });
    }
}
