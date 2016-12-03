package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBills;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Bill;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Budget;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.R;

/**
 * Created by connorroset on 11/26/16.
 */

public class ViewBillsRVAdapter extends RecyclerView.Adapter<ViewBillsRVAdapter.ViewBillsViewHolder> {

    public static class ViewBillsViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView type;
        TextView amount;
        TextView paid;
        Button delete;

        ViewBillsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            type = (TextView) itemView.findViewById(R.id.type_card_view);
            amount = (TextView) itemView.findViewById(R.id.amount_card_view);
            paid = (Button) itemView.findViewById(R.id.paid_card_view);
            delete = (Button) itemView.findViewById(R.id.delete_button_card_view);


        }
    }

    private List<Bill> bills;
    private Context context;
    private Budget mBudget;
    public ViewBillsRVAdapter(List<Bill> bills, Context context) {
        this.bills = bills;
        this.context = context;
        mBudget = ((MainActivity)context).getBudget();
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    @Override
    public ViewBillsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewBillsViewHolder viewBillsViewHolder = new ViewBillsViewHolder(v);
        return viewBillsViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewBillsViewHolder viewBillsViewHolder, final int i) {
        viewBillsViewHolder.type.setText(bills.get(i).getType());
        viewBillsViewHolder.amount.setText(String.valueOf(bills.get(i).getAmount()));
        viewBillsViewHolder.paid.setText("Pay");
        viewBillsViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBudget.removeBill(bills.get(i));
                ((MainActivity)context).saveBudget();
                notifyDataSetChanged();
                //remove bill from budget

            }
        });

        if (bills.get(i).isPaid()) {
            viewBillsViewHolder.paid.setEnabled(false);
            viewBillsViewHolder.paid.setText("Paid");

        } else {

            viewBillsViewHolder.paid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //change bill to PAID, update the budget
                    viewBillsViewHolder.paid.setEnabled(false);
                    viewBillsViewHolder.paid.setText("Paid");
                    mBudget.payBill(bills.get(viewBillsViewHolder.getAdapterPosition()));
                    ((MainActivity)context).saveBudget();
                    notifyDataSetChanged();
                    viewBillsViewHolder.paid.setEnabled(false);
                }
            });

        }

    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
