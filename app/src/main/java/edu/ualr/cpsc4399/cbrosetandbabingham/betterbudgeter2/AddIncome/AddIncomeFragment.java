package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddIncome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill.AddBillFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Income;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
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

        final EditText amount = (EditText) getActivity().findViewById(R.id.add_income_income_amount_edit_text);
        final RadioGroup selectType = (RadioGroup) getActivity().findViewById(R.id.add_income_list_of_income_types_radio_group);

        final String[] types = ((MainActivity) getActivity()).getBudget().getIncomeTypes();

        for (String type : types) {
            RadioButton rb = new RadioButton(getContext());
            rb.setText(type);
            selectType.addView(rb);
        }

        Button submit = (Button) getActivity().findViewById(R.id.add_income_submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = selectType.indexOfChild(selectType.findViewById(selectType.getCheckedRadioButtonId()));

                Income income;
                if ((TextUtils.isEmpty(amount.getText()) || index == -1)) {
                    Toast.makeText(getContext(), "You must first select a type and enter an amount", Toast.LENGTH_SHORT).show();

                } else {
                   income = new Income(Float.valueOf(amount.getText().toString()), types[index]);
                    ((MainActivity) getActivity()).getBudget().addIncome(income);
                    ((MainActivity)getActivity()).saveBudget();
                    //navigate back to viewbudget
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ViewBudgetFragment vbf = new ViewBudgetFragment();
                    ft.replace(R.id.fragment_container, vbf);
                    ft.commit();
                }
            }

        });
    }

}
