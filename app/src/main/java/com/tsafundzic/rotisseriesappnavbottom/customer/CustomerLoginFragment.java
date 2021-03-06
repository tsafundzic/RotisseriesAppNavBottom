package com.tsafundzic.rotisseriesappnavbottom.customer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.CustomerChooserActivity;
import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;
import com.tsafundzic.rotisseriesappnavbottom.utils.ValidationUtils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerLoginFragment extends Fragment implements View.OnClickListener {

    EditText customerID;
    EditText customerPassword;
    Button customerLogin;
    List<Customer> customers = DataHolder.getInstance().getCustomers();

    public CustomerLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customerID = view.findViewById(R.id.etCustomerID);
        customerPassword = view.findViewById(R.id.etCustomerPassword);
        customerLogin = view.findViewById(R.id.btnCustomerLogin);
        customerLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ValidationUtils.isInputValid(customerID.getText().toString())) {
            customerID.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(customerPassword.getText().toString())) {
            customerPassword.setError(getText(R.string.you_must_input_something));
        } else {
            int inputedCustomerID = Integer.parseInt(customerID.getText().toString());
            String inputedCustomerPassword = customerPassword.getText().toString();

            for (Customer customer : customers) {
                if (inputedCustomerID == customer.getId() && inputedCustomerPassword.equals(customer.getPassword())) {
                    Toast.makeText(getContext(), R.string.logged_as_customer, Toast.LENGTH_SHORT).show();

                    DataHolder.getInstance().setLoggedCustomerBasedOnID(customer.getId());

                    Intent startCustomerChooseActivity = new Intent(getActivity(), CustomerChooserActivity.class);
                    startActivity(startCustomerChooseActivity);
                }
            }
        }
    }
}
