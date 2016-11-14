package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;



import java.util.ArrayList;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;


/**
 * Created by connorroset on 11/12/16.
 */

public class Budget {
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<Bill>bills = new ArrayList<>();
    private ArrayList<Luxury>luxuries = new ArrayList<>();

    public float getBudgetRemainingForPurchases() {
        return budgetRemainingForPurchases;
    }

    public float getBudgetRemainingForLuxuries() {
        return budgetRemainingForLuxuries;
    }

    private ArrayList<Purchase>purchases = new ArrayList<>();
    private float budgetRemainingForPurchases;
    private float budgetRemainingForLuxuries;

    public Budget(){

    }
    public Budget(Boolean makeTestBudget){
        if(makeTestBudget){
            //populate a temp budget
            incomes.add(new Income(20.00f, Income.OTHER_INCOME));
            incomes.add(new Income(30.00f, Income.SALARY));
            incomes.add(new Income(30.00f, Income.SALARY));
            bills.add(new Bill(21.00f, Bill.OTHER_BILL));
//            .add(new NonMandatoryExpense(34.00f, NonMandatoryExpense.EATING_OUT));



        }
    }

    public float billTotal(){
        float temp = 0;
        for(int i = 0; i<bills.size(); i++){
            temp += bills.get(i).getAmount();
        }
        return temp;
    }
    public float luxuryTotal(){
        float temp = 0;
        for(int i = 0; i<luxuries.size(); i++){
            temp += luxuries.get(i).getAmount();
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
    public ArrayList<Bill> getBills(){
        return bills;
    }
    public ArrayList<Luxury> getLuxuries(){
        return luxuries;
    }
    public ArrayList<Purchase> getPurchases(){
        return purchases;
    }

    public int getNumberUnPaidBills(){
        int count = 0;
        for(Bill bill : bills){
            if(bill.isPaid()){
                count++;
            }
        }
        return count;
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

    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }
    public void removePurchase(Purchase purchase){
        if(purchases.contains(purchase)){
            purchases.remove(purchase);
        }
    }

    public void addBill(Bill bill){
        bills.add(bill);
    }
    public void removeBill(Bill bill){
        if(bills.contains(bill)){
            bills.remove(bill);
        }
    }

    public void addLuxury(Luxury luxury){
        luxuries.add(luxury);
    }
    public void removeLuxury(Luxury luxury){
        if(luxuries.contains(luxury)){
            luxuries.remove(luxury);
        }
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
