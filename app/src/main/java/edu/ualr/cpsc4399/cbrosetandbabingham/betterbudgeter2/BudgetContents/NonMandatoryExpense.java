package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/12/16.
 */

public class NonMandatoryExpense {

    /*
    private values to share with the rest of the application
     */
    public static final String NETFLIX = "Netflix";
    public static final String MOVIES = "Movies";
    public static final String EATING_OUT = "Eating out";
    public static final String OTHER_NON_MANDATORY_EXPENSE = "Other";


    //Private members for the class
    private float amount;
    private String type;
    private boolean paid = false;

    public NonMandatoryExpense(float amount){
        this.amount = amount;
        type = NonMandatoryExpense.OTHER_NON_MANDATORY_EXPENSE;
    }
    public NonMandatoryExpense(float amount, String type){
        this.amount = amount; this.type = type;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}
    public boolean isPaid(){return paid;}
    public void setPaid(boolean paidTF){
        paid = paidTF;
    }
}
