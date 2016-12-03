package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;

/**
 * Created by connorroset on 11/12/16.
 */

public class Income {
//    public static final String SALARY = "Salary";
//    public static final String MONTHLY_ALLOWANCE = "Monthly Allowance";
//    public static final String STIPENDS_GRANTS_AID = "Stipends/Grants/Aid";
//    public static final String SCHOLARSHIPS = "Scholarships";
//    public static final String OTHER_INCOME = "Other";
//    public static final int NUMBER_OF_INCOME_TYPES = 5;
    private float amount;
    private String type;

//    public Income(float amount) {
//        this.amount = amount;
//        type = Income.OTHER_INCOME;
//    }
    public Income(float amount, String type){
        this.amount = amount;
        this.type = type;
    }
    public float getAmount(){return amount;}
    public String getType(){return type;}
//    public String [] getAllTypes(){
//        return new String[] {SALARY, MONTHLY_ALLOWANCE, STIPENDS_GRANTS_AID,SCHOLARSHIPS,OTHER_INCOME};
//    }
}
