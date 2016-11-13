package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/13/16.
 */

public class ViewLuxuriesFragment extends MenuOptionsFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(getResources().getString(R.string.view_luxuries));
        return inflater.inflate(R.layout.fragment_view_luxuries, container, false);
    }
}