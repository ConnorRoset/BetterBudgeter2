package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;



/**
 * Created by connorroset on 11/13/16.
 */

public class Bill {

    /*
    public items
     */
    public static final String UTILITIES_BILL = "Utilities";
    public static final String GROCERIES_BILL = "Groceries";
    public static final String SUBSCRIPTIONS_BILL = "Subscriptions";
    public static final String INSURANCE_BILL = "Insurance";
    public static final String PAYMENT_BILL = "Payment";
    public static final String MOBILE_BILL = "Mobile";
    public static final String INTERNET_BILL = "Internet";
    public static final String TUITION_BILL = "Tuition";
    public static final String RENT_BILL = "Rent";
    public static final String FUEL_BILL = "Fuel";
    public static final String MEDICAL_BILL = "Medical";
    public static final String MEMBERSHIP_BILL = "Membership";
    public static final String SERVICES_BILL = "Services";
    public static final String OTHER_BILL = "Other";

    public static final int NUMBER_OF_BILL_TYPES = 14;

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
    public String [] getAllTypes(){

        return new String[]{UTILITIES_BILL, GROCERIES_BILL, SUBSCRIPTIONS_BILL, INSURANCE_BILL, PAYMENT_BILL, MOBILE_BILL, INTERNET_BILL, TUITION_BILL, RENT_BILL, FUEL_BILL, MEDICAL_BILL, MEMBERSHIP_BILL, SERVICES_BILL};

    }
}
