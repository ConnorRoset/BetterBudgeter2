package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddBill;

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

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Bill;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;

import static edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R.string.submit;

/**
 * Created by connorroset on 11/14/16.
 */

public class AddBillFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.add_bill));
        return inflater.inflate(R.layout.fragment_add_bill, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //find selected item on Recycler view
        //convert it to string
        //extract text from text field

        //declare the items on the screen
        final RadioGroup selectType = (RadioGroup) getActivity().findViewById(R.id.add_bill_list_of_bill_types_radio_group);
        final EditText amount = (EditText) getActivity().findViewById(R.id.add_bill_bill_amount_edit_text);
        Button submit = (Button) getActivity().findViewById(R.id.add_bill_submit_button);

        //fetch the bill types from main activity
        final String[] types = ((MainActivity) getActivity()).getBudget().getBillTypes();
        for (String type : types) {
            RadioButton rb = new RadioButton(getContext());
            rb.setText(type);
            selectType.addView(rb);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bill bill;
                int index = selectType.indexOfChild(selectType.findViewById(selectType.getCheckedRadioButtonId()));
                if ((TextUtils.isEmpty(amount.getText()) || index == -1)) {
                    Toast.makeText(getContext(), "You must first select a type and enter an amount", Toast.LENGTH_SHORT).show();

                } else {

                    //convert that value and the amount to a luxury, put that luxury in the budget

                   bill= new Bill(Float.valueOf( amount.getText().toString()), types[index]);
                    //add that luxury to the budget
                    ((MainActivity) getActivity()).getBudget().addBill(bill);
                    ((MainActivity) getActivity()).saveBudget();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ViewBudgetFragment aif = new ViewBudgetFragment();
                    ft.replace(R.id.fragment_container, aif);
                    ft.commit();
                }

//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ViewBudgetFragment vbf = new ViewBudgetFragment();
//                ft.replace(R.id.fragment_container, vbf);
//                ft.commit();
            }
        });
    }

}
