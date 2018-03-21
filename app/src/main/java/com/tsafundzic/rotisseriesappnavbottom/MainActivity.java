package com.tsafundzic.rotisseriesappnavbottom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerLoginFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerRegistrationFragment;

public class MainActivity extends AppCompatActivity {


    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    private void setUI() {
        setTitle(R.string.app_name);
        fragment = new CustomerLoginFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameHome, fragment);
        fragmentTransaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.homeBottomNavigationItems);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    Fragment fragment = null;

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuCustomerLogin:
                                setTitle(R.string.login); //this will set title of Action Bar
                                fragment = new CustomerLoginFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameHome, fragment);
                                fragmentTransaction.commit();
                                return true;
                            case R.id.menuCustomerRegistration:
                                setTitle(R.string.customer_registration); //this will set title of Action Bar
                                fragment = new CustomerRegistrationFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameHome, fragment);
                                fragmentTransaction.commit();
                                return true;
                            case R.id.menuWorkerLogin:
                                setTitle(R.string.worker_login); //this will set title of Action Bar
                                fragment = new CustomerRegistrationFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameHome, fragment);
                                fragmentTransaction.commit();
                                return true;
                        }
                        return false;
                    }

                });
    }
}
