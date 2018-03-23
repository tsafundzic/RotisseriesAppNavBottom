package com.tsafundzic.rotisseriesappnavbottom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerAddMoneyToBalanceFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerBalanceFragment;
import com.tsafundzic.rotisseriesappnavbottom.customer.CustomerBuyProductsFragment;
import com.tsafundzic.rotisseriesappnavbottom.utils.BaseActivity;


public class CustomerChooserActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_chooser);

        setUI();
    }

    private void setUI() {
        setTitle(R.string.check_balance);
        changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerBalanceFragment(), this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.customerChooserNavigationBottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCheckBalance:
                setTitle(R.string.check_balance);
                changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerBalanceFragment(), CustomerChooserActivity.this);
                break;
            case R.id.menuAddMoneyToBalance:
                setTitle(R.string.add_money);
                changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerAddMoneyToBalanceFragment(), CustomerChooserActivity.this);
                break;
            case R.id.menuBuyProducts:
                setTitle(R.string.buy_products);
                changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerBuyProductsFragment(), CustomerChooserActivity.this);
                break;
        }
        return true;
    }
}
