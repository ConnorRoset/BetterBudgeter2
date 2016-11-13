package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/13/16.
 */

public class Luxury {

    /*
    public members for other functions
     */
    public static final String OTHER_LUXURY = "Other";
    //class information
    private float amount;
    private String type;
    public Luxury(float amount){
        this.amount = amount;
        type = Luxury.OTHER_LUXURY;
    }
    public Luxury(float amount, String type){
        this.amount = amount;
        this.type = type;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}
}
