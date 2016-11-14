package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/13/16.
 */

public class Bill {

    /*
    public items
     */
    public static final String OTHER_BILL = "Other";
    //class information
    private float amount;
    private String type;
    private boolean paid;
    public Bill(float amount){
        this.amount = amount;
        type = Bill.OTHER_BILL;
        paid = false;
    }
    public Bill(float amount, String type){
        this.amount = amount;
        this.type = type;
        paid = false;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}
    public boolean isPaid(){
        return paid;
    }
}
