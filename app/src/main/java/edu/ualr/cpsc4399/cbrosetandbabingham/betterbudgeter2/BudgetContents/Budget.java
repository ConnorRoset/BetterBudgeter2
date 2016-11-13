package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;



import java.util.ArrayList;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;


/**
 * Created by connorroset on 11/12/16.
 */

public class Budget {
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<MandatoryExpense>mandatoryExpenses = new ArrayList<>();
    private ArrayList<NonMandatoryExpense>nonMandatoryExpenses = new ArrayList<>();
    private ArrayList<Purchase>purchases = new ArrayList<>();
    private float budgetRemaining;

    public Budget(){

    }
    public Budget(Boolean makeTestBudget){
        if(makeTestBudget){
            //populate a temp budget
            incomes.add(new Income(20.00f, Income.OTHER_INCOME));
            incomes.add(new Income(30.00f, Income.SALARY));
            incomes.add(new Income(30.00f, Income.SALARY));
            mandatoryExpenses.add(new MandatoryExpense(21.00f, MandatoryExpense.ELECTRIC_BILL));
            nonMandatoryExpenses.add(new NonMandatoryExpense(34.00f, NonMandatoryExpense.EATING_OUT));



        }
    }

    public float mandatoryExpenseTotal(){
        float temp = 0;
        for(int i = 0; i<mandatoryExpenses.size(); i++){
            temp += mandatoryExpenses.get(i).getAmount();
        }
        return temp;
    }
    public float nonMandatoryExpensetotal(){
        float temp = 0;
        for(int i = 0; i<nonMandatoryExpenses.size(); i++){
            temp += nonMandatoryExpenses.get(i).getAmount();
        }
        return temp;
    };
    public float purchaseTotal(){
        float temp = 0;
        for(int i = 0; i<purchases.size(); i++){
            temp += purchases.get(i).getAmount();
        }
        return temp;
    }


    public ArrayList<Income> getIncomes(){
        return incomes;
    }
    public ArrayList<MandatoryExpense> getMandatoryExpenses(){
        return mandatoryExpenses;
    }
    public ArrayList<NonMandatoryExpense> getNonMandatoryExpenses(){
        return nonMandatoryExpenses;
    }
    public ArrayList<Purchase> getPurchases(){
        return purchases;
    }


    public void addIncome(Income income){
        incomes.add(income);
    }
    public void remvomeIncome(Income income){
        //Find that income, remove it from internal list
        if(incomes.contains(income)){
            incomes.remove(income);
        }
    }
    public void addMandatoryExpense(MandatoryExpense mandatoryExpense){
        mandatoryExpenses.add(mandatoryExpense);
    }
    public void removeMandatoryExpense(MandatoryExpense mandatoryExpense){
        //find that MandExpense, remove it from list
        if(mandatoryExpenses.contains(mandatoryExpense)){
            mandatoryExpenses.remove(mandatoryExpense);
        }
    }
    public void addNonMandatoryExpense(NonMandatoryExpense nonMandatoryExpense){
        nonMandatoryExpenses.add(nonMandatoryExpense);
    }
    public void removeNonMandatoryExpense(NonMandatoryExpense nonMandatoryExpense){
        //find the nonMandExpense, remove it from internal list
        if(nonMandatoryExpenses.contains(nonMandatoryExpense)){
            nonMandatoryExpenses.remove(nonMandatoryExpense);
        }
    }
    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }


    //will need to call in on create method of main to see if budget needs to be refreshed
    public void resetMonthlyBudget(){
        /*
        if(startofnewmonth){
            clear purchases
            restore income amount to original
            set all expenses to unpaid
         */
    }
}
