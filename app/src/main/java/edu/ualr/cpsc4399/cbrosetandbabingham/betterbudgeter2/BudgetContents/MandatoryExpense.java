package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/12/16.
 */

public class MandatoryExpense {
    /*
    public attributes to share with the rest of the program
     */

    public static final String ELECTRIC_BILL ="Electric bill";
    public static final String RENT = "Rent";
    public static final String OTHER_MANDATORY_EXPENSE = "Other";

    /*
    private functionality of a Mandatory Expense
     */
    private float amount;
    private String type;
    private boolean paid = false;

    public MandatoryExpense(float amount){
        this.amount = amount;
        type = MandatoryExpense.OTHER_MANDATORY_EXPENSE;
    }
    public MandatoryExpense(float amount, String type){
        this.amount = amount;
        this.type = type;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}

    public boolean isPaid(){return paid;}
    public void setPaid(boolean paidTF){
        paid = paidTF;
    }
}
