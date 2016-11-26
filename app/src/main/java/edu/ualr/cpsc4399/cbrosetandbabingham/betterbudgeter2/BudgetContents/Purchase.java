package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/12/16.
 */

public class Purchase {

    /*
    public variable for the rest of the application
     */
    public static final String REPAIRS_PURCHASE = "Repairs";
    public static final String MEDICAL_PURCHASE = "Medical";
    public static final String CAR_PARTS_PURCHASE = "Car Parts";
    public static final String SUPPLIES_PURCHASE = "Supplies";
    public static final String ALCOHOL_PURCHASE = "Alcohol";
    public static final String FUEL_PURCHASE = "Fuel";
    public static final String SNACKS_PURCHASE = "Snacks";
    public static final String SERVICES_PURCHASE = "Services";
    public static final String GIFT_PURCHASE = "Gift";
    public static final String CLOTHING_BILL = "Clothing";
    public static final String GAMES_BILL = "Games";
    public static final String DRINK_PURCHASE = "Drink";
    public static final String FOOD_PURCHASE = "Food";
    public static final String OTHER_PURCHASE = "Other";

    public static final int NUMBER_OF_PURCHASE_TYPES = 14;

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
    public String [] getAllTypes(){
        return new String[]{REPAIRS_PURCHASE,MEDICAL_PURCHASE,CAR_PARTS_PURCHASE,SUPPLIES_PURCHASE,ALCOHOL_PURCHASE,FUEL_PURCHASE,SNACKS_PURCHASE,SERVICES_PURCHASE,GIFT_PURCHASE,CLOTHING_BILL,GAMES_BILL,DRINK_PURCHASE,FOOD_PURCHASE};
    }
}
