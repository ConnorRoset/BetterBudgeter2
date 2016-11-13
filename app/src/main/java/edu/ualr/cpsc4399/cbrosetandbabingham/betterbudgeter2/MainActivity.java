package edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.Gson;

import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.BudgetContents.Budget;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.AddLuxuryFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.AddPurchaseFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.ManageBillsFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.ManageIncomesFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.MenuOptionsFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.ViewBudgetFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.ViewLuxuriesFragment;
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.NavFragments.ViewPurchasesFragment;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Fragment transaction to move the activity around
    MenuOptionsFragment fragment = new MenuOptionsFragment();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    public Budget budget;
    //SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        if(budget == null) {
//            budget = new Budget(true);
//            saveBudget();
//        }
        //will eventually need to change to standard budget constructor

//        else
        {
            openBudget();
        }
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
        Gson gson = new Gson();
        String json =  getPreferences(MODE_PRIVATE).getString("BUDGET_SAVE", "");
        budget = gson.fromJson(json, Budget.class);
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
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_view_budget) {
            fragment = new ViewBudgetFragment();
        } else if (id == R.id.nav_add_purchase) {
            fragment = new AddPurchaseFragment();
        } else if (id == R.id.nav_add_luxury) {
            fragment = new AddLuxuryFragment();
        } else if (id == R.id.nav_manage_bills) {
            fragment = new ManageBillsFragment();
        } else if (id == R.id.nav_manage_incomes) {
            fragment = new ManageIncomesFragment();
        } else if (id == R.id.nav_view_purchases) {
            fragment = new ViewPurchasesFragment();
        } else if(id == R.id.nav_view_luxuries){
            fragment = new ViewLuxuriesFragment();
        } //else if (id == R.id.nav_view_bills){
//            fragment = new ViewBillsFragment();
//        }

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
