package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddLuxury;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddIncome.AddIncomeFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Luxury;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;

/**
 * Created by connorroset on 11/14/16.
 */

public class AddLuxuryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.add_a_luxury));
        return inflater.inflate(R.layout.fragment_add_luxury, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //find selected item on Recycler view
        //convert it to string
        //extract text from text field
        //button.onclick = add purchase to top of purchase list
        Button submit = (Button) getActivity().findViewById(R.id.add_luxury_submit_button);
        final EditText amount = (EditText) getActivity().findViewById(R.id.add_luxury_luxury_amount_edit_text);
        final RadioGroup selectType = (RadioGroup) getActivity().findViewById(R.id.add_luxury_radio_group);
        final String[] types = Luxury.getAllTypes();
        //populate the radiogroup:
        for (int i = 0; i < Luxury.getAllTypes().length; i++) {
            RadioButton rb = new RadioButton(getContext());
            rb.setText(types[i]);
            selectType.addView(rb);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go back to view budget
                Luxury lux = new Luxury(45.00f, Luxury.OTHER_LUXURY);

                //get the index of the radio group that was added
                int idx = selectType.indexOfChild(selectType.findViewById(selectType.getCheckedRadioButtonId()));

                //this is to ensure there is both a radio button selected and text in the field to submit a purchase
                if ((TextUtils.isEmpty(amount.getText()) || idx == -1)) {
                    Toast.makeText(getContext(), "You must first select a type and enter an amount", Toast.LENGTH_SHORT).show();

                } else {

                    //convert that value and the amount to a luxury, put that luxury in the budget

                   lux = new Luxury(Float.valueOf( amount.getText().toString()), Luxury.getTypeAtIndex(idx));
                    //add that luxury to the budget
                    ((MainActivity) getActivity()).getBudget().addLuxury(lux);
                     ((MainActivity) getActivity()).saveBudget();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ViewBudgetFragment aif = new ViewBudgetFragment();
                    ft.replace(R.id.fragment_container, aif);
                    ft.commit();
                }
            }
        });
    }

}
