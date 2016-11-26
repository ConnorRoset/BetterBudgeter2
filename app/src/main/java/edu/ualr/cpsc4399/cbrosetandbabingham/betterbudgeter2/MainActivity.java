package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.Gson;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddLuxury.AddLuxuryFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.AddPurchase.AddPurchaseFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Budget;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBills.ViewBillsFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewIncomes.ViewIncomesFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewLuxuries.ViewLuxuriesFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewPurchases.ViewPurchasesFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Fragment transaction to move the activity around
   // MenuOptionsFragment fragment = new MenuOptionsFragment();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    public Budget budget;

    //SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //prepare the recyclerview for the fragments

        //saveBudget();
       // openBudget();
        //open the budget
        //makeBudgetreal quick
//        budget = new Budget(true);
//        saveBudget();
//        recyclerView = (RecyclerView) findViewById(R.id.view_incomes_list_of_incomes_recycler_view);
//        view_incomes_list_of_incomes_recycler_viewrecyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//saveBudget();
//        budget = new Budget(true);
//        saveBudget();
        openBudget();
//        if(!budget.isMade)
//        {
//            budget = new Budget(true);
//            saveBudget();
//        }
        //will eventually need to change to standard budget constructor

        //make fragment of type view budget
        ViewBudgetFragment fragment = new ViewBudgetFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        //fix the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void saveBudget(){
        //write budget to memory here
        SharedPreferences.Editor prefsEditor =  getPreferences(MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(budget);
        prefsEditor.putString("BUDGET_SAVE", json);
        prefsEditor.commit();
    }

    public void openBudget(){
        //open the budget from storage
      try {
          Gson gson = new Gson();
          String json = getPreferences(MODE_PRIVATE).getString("BUDGET_SAVE", "");
          budget = gson.fromJson(json, Budget.class);
      } catch(UnknownError e){
          budget = new Budget(true);
          saveBudget();
      }
//        if(budget.isMade){
//            return true;
//        } else{
//            return false;
//        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public Budget getBudget(){
        return this.budget;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_view_budget) {
            //view budget fragment
            fragmentTransaction.replace(R.id.fragment_container, new ViewBudgetFragment());
        }
         else if (id == R.id.nav_add_purchase) {
            //add purchase fragment
            fragmentTransaction.replace(R.id.fragment_container, new AddPurchaseFragment());
        }
         else if (id == R.id.nav_add_luxury) {
            //add luxury fragment
            fragmentTransaction.replace(R.id.fragment_container, new AddLuxuryFragment());
        }
        else if (id == R.id.nav_view_purchases) {
            //view purchases fragment
            fragmentTransaction.replace(R.id.fragment_container, new ViewPurchasesFragment());
        }
        else if(id == R.id.nav_view_luxuries) {
            //view luxuries fragment

            fragmentTransaction.replace(R.id.fragment_container, new ViewLuxuriesFragment());
        }
        else if(id == R.id.nav_view_bills) {
            //view bills fragment

            fragmentTransaction.replace(R.id.fragment_container, new ViewBillsFragment());
        }
        else if (id == R.id.nav_view_incomes){
            //View Incomes fragment

            fragmentTransaction.replace(R.id.fragment_container, new ViewIncomesFragment());
        }


       // fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    public RecyclerView getRecyclerView(){
//        return this.recyclerView;
//    }
}
