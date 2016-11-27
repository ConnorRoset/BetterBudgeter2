package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewLuxuries;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Luxury;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/26/16.
 */

public class ViewLuxuriesRVAdapter extends RecyclerView.Adapter<ViewLuxuriesRVAdapter.ViewLuxuriesViewHolder> {

    public static class ViewLuxuriesViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView type;
        TextView amount;
        TextView paid;
        Button delete;
        ViewLuxuriesViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type = (TextView) itemView.findViewById(R.id.type_card_view);
            amount = (TextView) itemView.findViewById(R.id.amount_card_view);
            paid = (Button) itemView.findViewById(R.id.paid_card_view);
            delete = (Button) itemView.findViewById(R.id.delete_button_card_view);


        }
    }

    private List <Luxury> luxuries;
    public ViewLuxuriesRVAdapter(List<Luxury> luxuries){this.luxuries = luxuries;}

    @Override
    public int getItemCount(){return luxuries.size();}

    @Override
    public ViewLuxuriesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewLuxuriesViewHolder viewLuxuriesViewHolder = new ViewLuxuriesViewHolder(v);
        return viewLuxuriesViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewLuxuriesViewHolder viewLuxuriesViewHolder, final int i){
        viewLuxuriesViewHolder.type.setText(luxuries.get(i).getType());
        viewLuxuriesViewHolder.amount.setText(String.valueOf(luxuries.get(i).getAmount()));
//        viewPurchasesViewHolder.paid.setText("");
        viewLuxuriesViewHolder.paid.setVisibility(View.INVISIBLE);
        viewLuxuriesViewHolder.delete.setVisibility(View.INVISIBLE);
    }


}
