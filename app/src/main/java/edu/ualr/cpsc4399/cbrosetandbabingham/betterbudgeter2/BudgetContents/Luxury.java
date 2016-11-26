package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/13/16.
 */

public class Luxury {

    /*
    public members for other functions
     */
    public static final String SUBSCRIPTIONS_LUXURY = "Subscriptions";
    public static final String HOBBY_LUXURY = "Hobby";
    public static final String MEMBERSHIP_LUXURY = "Membership";
    public static final String CAR_PARTS_LUXURY = "Car Parts";
    public static final String ALCOHOL_LUXURY = "Alcohol";
    public static final String SNACKS_LUXURY = "Snacks";
    public static final String CLOTHING_LUXURY = "Clothing";
    public static final String OTHER_LUXURY = "Other";

    public static final int NUMBER_OF_LUXURY_TYPES = 8;
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
    public String [] getAllTypes(){
        return new String[]{SUBSCRIPTIONS_LUXURY, HOBBY_LUXURY, MEMBERSHIP_LUXURY,CAR_PARTS_LUXURY,ALCOHOL_LUXURY,SNACKS_LUXURY,CLOTHING_LUXURY,OTHER_LUXURY};
    }
}
