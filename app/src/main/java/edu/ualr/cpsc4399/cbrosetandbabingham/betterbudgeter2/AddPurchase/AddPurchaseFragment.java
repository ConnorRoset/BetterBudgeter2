package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddPurchase;

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

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Luxury;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Purchase;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;

/**
 * Created by connorroset on 11/14/16.
 */

public class AddPurchaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle(getResources().getString(R.string.add_a_purchase));
        return inflater.inflate(R.layout.fragment_add_purchase, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       //prepare the items on the screen
        Button submit = (Button) getActivity().findViewById(R.id.add_purchase_submit_button);
        final EditText amount = (EditText) getActivity().findViewById(R.id.add_purchase_purchase_amount_edit_text);
        final RadioGroup selectType = (RadioGroup) getActivity().findViewById(R.id.add_purchase_list_of_purchase_types_radio_group);

        //fetch the types from main activity
        final String[] types = ((MainActivity) getActivity()).getBudget().getPurchaseTypes();

        //populate the radiogroup
        for (String type : types) {
            RadioButton rb = new RadioButton(getContext());
            rb.setText(type);
            selectType.addView(rb);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Purchase purchase;
                int index = selectType.indexOfChild(selectType.findViewById(selectType.getCheckedRadioButtonId()));

                if ((TextUtils.isEmpty(amount.getText()) || index == -1)) {
                    Toast.makeText(getContext(), "You must first select a type and enter an amount", Toast.LENGTH_SHORT).show();

                } else {

                    //convert that value and the amount to a luxury, put that luxury in the budget

                    purchase = new Purchase(Float.valueOf( amount.getText().toString()), types[index]);
                    //add that luxury to the budget
                    ((MainActivity) getActivity()).getBudget().addPurchase(purchase);
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
