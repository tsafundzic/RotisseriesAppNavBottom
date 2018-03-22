package com.tsafundzic.rotisseriesappnavbottom.worker;


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
import com.tsafundzic.rotisseriesappnavbottom.model.Product;
import com.tsafundzic.rotisseriesappnavbottom.utils.ValidationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkerAddNewProductFragment extends Fragment implements View.OnClickListener {

    EditText productName;
    EditText productPrice;
    Button addNewProduct;

    public WorkerAddNewProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_worker_add_new_product, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productName = view.findViewById(R.id.etProductName);
        productPrice = view.findViewById(R.id.etProductPrice);
        addNewProduct = view.findViewById(R.id.btnAddNewProductToList);

        addNewProduct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ValidationUtils.isInputValid(productName.getText().toString())) {
            productName.setError(getText(R.string.you_must_input_something));
        } else if (ValidationUtils.isInputValid(productPrice.getText().toString())) {
            productPrice.setError(getText(R.string.you_must_input_something));
        } else {
            Product product = new Product(DataHolder.getInstance().getLastProductID() + 1, productName.getText().toString(), Double.parseDouble(productPrice.getText().toString()));
            DataHolder.getInstance().addProduct(product);

            Toast.makeText(getActivity(), R.string.product_added, Toast.LENGTH_SHORT).show();

            BaseFragment.changeFragments(R.id.fragmentFrameWorkerChooser, new WorkerDeleteProductFragment(), getActivity());
        }
    }
}
