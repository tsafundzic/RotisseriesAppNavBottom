package com.tsafundzic.rotisseriesappnavbottom;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CustomerChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_chooser);

        setTitle(R.string.customer_menu);

        setUI();
    }

    private void setUI() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.customerChooserNavigationBottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuCheckBalance:
                                break;
                            case R.id.menuAddMoneyToBalance:
                                break;
                            case R.id.menuBuyProducts:
                                break;
                        }
                        return true;
                    }
                });

    }
}
