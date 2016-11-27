package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewIncomes;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Income;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Purchase;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/26/16.
 */

public class ViewIncomeRVAdapter extends RecyclerView.Adapter<ViewIncomeRVAdapter.ViewIncomeViewHolder> {


    public static class ViewIncomeViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView type;
        TextView amount;
        TextView paid;
        Button delete;

        ViewIncomeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type = (TextView) itemView.findViewById(R.id.type_card_view);
            amount = (TextView) itemView.findViewById(R.id.amount_card_view);
            paid = (Button) itemView.findViewById(R.id.paid_card_view);
            delete = (Button) itemView.findViewById(R.id.delete_button_card_view);
//            cv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    cv.setCardBackgroundColor(Color.BLUE);
//                }
//            });

        }
    }

    private List<Income> incomes;

    public ViewIncomeRVAdapter(List<Income> incomes) {
        this.incomes = incomes;
    }

    @Override
    public int getItemCount() {
        return incomes.size();
    }

    @Override
    public ViewIncomeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewIncomeViewHolder viewIncomeViewHolder = new ViewIncomeViewHolder(v);
        return viewIncomeViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewIncomeViewHolder viewIncomeViewHolder, final int i) {
        viewIncomeViewHolder.type.setText(incomes.get(i).getType());
        viewIncomeViewHolder.amount.setText(String.valueOf(incomes.get(i).getAmount()));
        viewIncomeViewHolder.paid.setText("");
        viewIncomeViewHolder.paid.setVisibility(View.INVISIBLE);
        viewIncomeViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incomes.remove(viewIncomeViewHolder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
