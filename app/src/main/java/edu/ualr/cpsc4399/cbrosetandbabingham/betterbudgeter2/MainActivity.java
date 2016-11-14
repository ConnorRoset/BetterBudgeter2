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
import edu.ualr.cpsc4399.cbrosetandbabingham.betterbudgeter2.ViewBudget.ViewBudgetFragment;


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


        if(budget == null) {
            budget = new Budget(true);
            saveBudget();
        }
        //will eventually need to change to standard budget constructor

//        else
        {
            openBudget();
        }

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_view_budget) {
            //view budget fragment
            ViewBudgetFragment fragment = new ViewBudgetFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
        }
//        } else if (id == R.id.nav_add_purchase){
//            //add purchase fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        } else if (id == R.id.nav_add_luxury){
//            //add luxury fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        } else if (id == R.id.nav_view_purchases){
//            //view purchases fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        } else if(id == R.id.nav_view_luxuries){
//            //view luxuries fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        } else if(id == R.id.nav_view_bills){
//            //view bills fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        } else if (id == R.id.nav_view_incomes){
//            //View Incomes fragment
//
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        }


       // fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
