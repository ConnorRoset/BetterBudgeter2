package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/12/16.
 */

public class Purchase {

    /*
    public variable for the rest of the application
     */
    public static final String DRINK = "Drink";
    public static final String FOOD = "Food";
    public static final String OTHER_PURCHASE = "Other";
    public static final int NUMBER_OF_PURCHASE_TYPES = 3;

    //class information
    private float amount;
    private String type;
    public Purchase(float amount){
        this.amount = amount;
        type = Purchase.OTHER_PURCHASE;
    }
    public Purchase(float amount, String type){
        this.amount = amount;
        this.type = type;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}
}
