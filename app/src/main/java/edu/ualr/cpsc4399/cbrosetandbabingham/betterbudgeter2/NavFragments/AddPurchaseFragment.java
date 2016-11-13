package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/12/16.
 */

public class AddPurchaseFragment extends MenuOptionsFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.add_a_purchase));
        return inflater.inflate(R.layout.fragment_add_purchase, container, false);
    }
}
