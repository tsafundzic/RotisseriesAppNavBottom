package com.tsafundzic.rotisseriesappnavbottom.customer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.utils.BaseFragment;
import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;
import com.tsafundzic.rotisseriesappnavbottom.utils.ValidationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerAddMoneyToBalanceFragment extends BaseFragment implements View.OnClickListener {

    EditText inputedAmountToAddToBalance;
    Button addMoneyToBalance;

    Customer customer = DataHolder.getInstance().getLoggedCustomer();

    public CustomerAddMoneyToBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_add_money_to_balance, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputedAmountToAddToBalance = view.findViewById(R.id.etAmountOfMoney);
        addMoneyToBalance = view.findViewById(R.id.btnAddInputedMoneyToBalance);
        addMoneyToBalance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double currentCustomerBalance = DataHolder.getInstance().returnCurrentCustomerBalance(customer);

        if (ValidationUtils.isInputValid(inputedAmountToAddToBalance.getText().toString())) {
            Toast.makeText(getActivity(), getText(R.string.you_must_input_something), Toast.LENGTH_SHORT).show();
        } else {
            double moneyAmountToAdd = Double.parseDouble(inputedAmountToAddToBalance.getText().toString());

            customer.setBalance(currentCustomerBalance + moneyAmountToAdd);
            Toast.makeText(getActivity(), R.string.successful, Toast.LENGTH_SHORT).show();

            changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerBalanceFragment(), getActivity());
        }
    }
}
