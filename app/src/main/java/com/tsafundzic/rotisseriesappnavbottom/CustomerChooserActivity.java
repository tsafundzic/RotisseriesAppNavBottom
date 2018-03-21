package com.tsafundzic.rotisseriesappnavbottom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerAddMoneyToBalanceFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerBalanceFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerBuyProductsFragment;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;

public class CustomerChooserActivity extends AppCompatActivity {


    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_chooser);

        setUI();
    }

    private void setUI() {

        setTitle(R.string.check_balance);
        fragment = new CustomerBalanceFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentFrameCustomerChooser, fragment);
        fragmentTransaction.commit();

        Customer loggedCustomer = DataHolder.getInstance().getLoggedCustomer();

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerChooserNavigationBottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuCheckBalance:
                                setTitle(R.string.check_balance);
                                fragment = new CustomerBalanceFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameCustomerChooser, fragment);
                                fragmentTransaction.commit();
                                break;
                            case R.id.menuAddMoneyToBalance:
                                setTitle(R.string.add_money);
                                fragment = new CustomerAddMoneyToBalanceFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameCustomerChooser, fragment);
                                fragmentTransaction.commit();
                                break;
                            case R.id.menuBuyProducts:
                                setTitle(R.string.buy_products);
                                fragment = new CustomerBuyProductsFragment();
                                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentFrameCustomerChooser, fragment);
                                fragmentTransaction.commit();
                                break;
                        }
                        return true;
                    }
                });

    }
}
