package com.tsafundzic.rotisseriesappnavbottom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerLoginFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerRegistrationFragment;
import com.tsafundzic.rotisseriesappnavbottom.utils.BaseActivity;
import com.tsafundzic.rotisseriesappnavbottom.worker.WorkerLoginFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        setTitle(R.string.app_name);

        changeFragments(R.id.fragmentFrameHome, new CustomerLoginFragment(), this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.homeBottomNavigationItems);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuCustomerLogin:
                                setTitle(R.string.login);
                                changeFragments(R.id.fragmentFrameHome, new CustomerLoginFragment(), MainActivity.this);
                                break;
                            case R.id.menuCustomerRegistration:
                                setTitle(R.string.customer_registration);
                                changeFragments(R.id.fragmentFrameHome, new CustomerRegistrationFragment(), MainActivity.this);
                                break;
                            case R.id.menuWorkerLogin:
                                setTitle(R.string.worker_login);
                                changeFragments(R.id.fragmentFrameHome, new WorkerLoginFragment(), MainActivity.this);
                                break;
                        }
                        return false;
                    }

                });
    }

}
