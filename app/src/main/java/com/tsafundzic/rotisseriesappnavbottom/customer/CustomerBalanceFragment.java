package com.tsafundzic.rotisseriesappnavbottom.customer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerBalanceFragment extends Fragment {

    TextView customerBalance;
    Customer customer = DataHolder.getInstance().getLoggedCustomer();

    public CustomerBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_balance, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customerBalance = view.findViewById(R.id.tvCustomerBalance);

        customerBalance.setText(String.valueOf(customer.getBalance()));
    }

}
