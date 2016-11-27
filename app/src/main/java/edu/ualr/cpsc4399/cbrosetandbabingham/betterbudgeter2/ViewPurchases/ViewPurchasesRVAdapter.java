package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewPurchases;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Purchase;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/26/16.
 */

public class ViewPurchasesRVAdapter extends RecyclerView.Adapter<ViewPurchasesRVAdapter.ViewPurchasesViewHolder> {

    public static class ViewPurchasesViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView type;
        TextView amount;
        TextView paid;
        Button delete;
        ViewPurchasesViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type = (TextView) itemView.findViewById(R.id.type_card_view);
            amount = (TextView) itemView.findViewById(R.id.amount_card_view);
            paid = (Button) itemView.findViewById(R.id.paid_card_view);
            delete = (Button) itemView.findViewById(R.id.delete_button_card_view);


        }
    }

    private List <Purchase> purchases;
    public ViewPurchasesRVAdapter(List<Purchase> purchases){this.purchases = purchases;}

    @Override
    public int getItemCount(){ return purchases.size();}

    @Override
    public ViewPurchasesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewPurchasesViewHolder viewPurchasesViewHolder = new ViewPurchasesViewHolder(v);
        return viewPurchasesViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewPurchasesViewHolder viewPurchasesViewHolder, final int i) {
        viewPurchasesViewHolder.type.setText(purchases.get(i).getType());
        viewPurchasesViewHolder.amount.setText(String.valueOf(purchases.get(i).getAmount()));
//        viewPurchasesViewHolder.paid.setText("");
        viewPurchasesViewHolder.paid.setVisibility(View.INVISIBLE);
        viewPurchasesViewHolder.delete.setVisibility(View.INVISIBLE);
//        viewPurchasesViewHolder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                purchases.remove(viewPurchasesViewHolder.getAdapterPosition());
//                notifyDataSetChanged();
//            }
//        });


    }

}
