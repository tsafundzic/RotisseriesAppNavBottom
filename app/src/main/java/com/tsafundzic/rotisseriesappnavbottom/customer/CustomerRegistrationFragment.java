package com.tsafundzic.rotisseriesappnavbottom.customer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.utils.BaseFragment;
import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;
import com.tsafundzic.rotisseriesappnavbottom.utils.ValidationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerRegistrationFragment extends BaseFragment implements View.OnClickListener {

    EditText customerName;
    EditText customerSurname;
    EditText customerPassword;
    EditText customerPasswordAgain;
    Button customerRegistration;
    TextView customerID;

    public CustomerRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_registration, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customerID = getView().findViewById(R.id.tvCustomerID);
        customerName = getView().findViewById(R.id.etCustomerName);
        customerSurname = getView().findViewById(R.id.etCustomerSurname);
        customerPassword = getView().findViewById(R.id.etCustomerPasswordFirst);
        customerPasswordAgain = getView().findViewById(R.id.etCustomerPasswordAgain);
        customerRegistration = getView().findViewById(R.id.btnCustomerLogin);

        customerID.setText(String.valueOf(DataHolder.getInstance().getCustomersSize() + 1));

        customerRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ValidationUtils.isInputValid(customerName.getText().toString())) {
            customerName.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(customerSurname.getText().toString())) {
            customerSurname.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(customerPassword.getText().toString())) {
            customerPassword.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(customerPasswordAgain.getText().toString())) {
            customerPasswordAgain.setError(getText(R.string.you_must_input_something));
        } else if (customerPassword.getText().toString().equals(customerPasswordAgain.getText().toString())) {
            Customer customer = new Customer(DataHolder.getInstance().getCustomersSize() + 1, customerName.getText().toString(), customerSurname.getText().toString(), customerPassword.getText().toString(), 0);
            DataHolder.getInstance().addNewCustomer(customer);
            Toast.makeText(getContext(), R.string.new_cutomer_created, Toast.LENGTH_SHORT).show();

            BaseFragment.changeFragments(R.id.fragmentFrameHome, new CustomerLoginFragment(), getActivity());

        } else {
            Toast.makeText(getContext(), R.string.password_doesnt_match, Toast.LENGTH_SHORT).show();
        }
    }
}
