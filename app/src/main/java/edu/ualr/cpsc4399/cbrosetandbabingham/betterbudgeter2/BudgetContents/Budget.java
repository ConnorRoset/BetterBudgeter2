package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents;


import java.util.ArrayList;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.MainActivity;


/**
 * Created by connorroset on 11/12/16.
 */

public class Budget {
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<Bill> bills = new ArrayList<>();
    private ArrayList<Luxury> luxuries = new ArrayList<>();

    public float getBudgetRemainingForPurchases() {
        return budgetRemainingForPurchases;
    }

    public float getBudgetRemainingForLuxuries() {
        return budgetRemainingForLuxuries;
    }

    private ArrayList<Purchase> purchases = new ArrayList<>();
    private float budgetRemainingForPurchases;
    private float budgetRemainingForLuxuries;
    private float totalRemainingBudget;
    public boolean isMade = false;


    private String[] incomeTypes, billTypes, purchaseTypes, luxuryTypes;

    public String[] getIncomeTypes() {
        return incomeTypes;
    }

    public String[] getBillTypes() {
        return billTypes;
    }

    public String[] getPurchaseTypes() {
        return purchaseTypes;
    }

    public String[] getLuxuryTypes() {
        return luxuryTypes;
    }

    public Budget(Boolean makeTestBudget, String[] incomeTypes, String[] billTypes, String[] purchaseTypes, String[] luxuryTypes) {
        if (makeTestBudget) {
            //populate a temp budget
            this.incomeTypes = incomeTypes;
            this.billTypes = billTypes;
            this.purchaseTypes = purchaseTypes;
            this.luxuryTypes = luxuryTypes;
//            budgetRemainingForPurchases = (((0.30f) * incomeTotal()) - purchaseTotal());
//            budgetRemainingForLuxuries = (((0.20f) * incomeTotal()) - luxuryTotal());
            isMade = true;
        }
        updateBudget();
    }


    public void updateBudget() {
        totalRemainingBudget = incomeTotal() - billTotal();
        budgetRemainingForPurchases = ((float) 0.7 * totalRemainingBudget) - purchaseTotal();
        budgetRemainingForLuxuries = ((float) 0.3 * totalRemainingBudget) - luxuryTotal();
    }

    public float incomeTotal() {
        float temp = 0f;
        for (int i = 0; i < incomes.size(); i++) {
            temp += incomes.get(i).getAmount();
        }
        return temp;
    }

    public float billTotal() {
        float temp = 0;
        for (int i = 0; i < bills.size(); i++) {
            temp += bills.get(i).getAmount();
        }
        return temp;
    }

    public float luxuryTotal() {
        float temp = 0;
        for (int i = 0; i < luxuries.size(); i++) {
            temp += luxuries.get(i).getAmount();
        }
        return temp;
    }


    public float purchaseTotal() {
        float temp = 0;
        for (int i = 0; i < purchases.size(); i++) {
            temp += purchases.get(i).getAmount();
        }
        return temp;
    }


    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public ArrayList<Luxury> getLuxuries() {
        return luxuries;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }


    public void payBill(Bill bill) {
        if (bills.contains(bill)) {
            bill.setPaid(true);
        }
    }

    public void unPayBill(Bill bill) {
        if (bills.contains(bill)) {
            bill.setPaid(false);
        }
    }

    public int getNumberUnPaidBills() {
        int count = 0;
        for (Bill bill : bills) {
            if (!bill.isPaid()) {
                count++;
            }
        }
        return count;
    }

    public void addIncome(Income income) {
        incomes.add(income);
        //budgetRemainingForPurchases = incomeTotal();
        updateBudget();

    }

    public void removeIncome(Income income) {
        //Find that income, remove it from internal list
        if (incomes.contains(income)) {
            incomes.remove(income);
        }
        updateBudget();
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
        budgetRemainingForPurchases -= purchase.getAmount();

    }


    public void addBill(Bill bill) {
        bills.add(bill);
        updateBudget();
    }

    public void removeBill(Bill bill) {
        if (bills.contains(bill)) {
            bills.remove(bill);
        }
        updateBudget();
    }

    public void addLuxury(Luxury luxury) {
        luxuries.add(luxury);
        budgetRemainingForLuxuries -= luxury.getAmount();
    }

    //will need to call in on create method of main to see if budget needs to be refreshed
    public void resetMonthlyBudget() {

        for (Purchase purchase : purchases
                ) {
            purchases.remove(purchase);
        }

        for (Luxury luxury : luxuries
                ) {
            if (luxuries.contains(luxury)) {
                luxuries.remove(luxury);
            }
        }
        for (Bill bill : bills
                ) {
            bill.setPaid(false);
        }
        budgetRemainingForLuxuries = 0;
        budgetRemainingForLuxuries = 0;
        updateBudget();
    }
}
