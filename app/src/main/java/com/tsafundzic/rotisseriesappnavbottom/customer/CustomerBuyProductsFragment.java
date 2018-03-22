package com.tsafundzic.rotisseriesappnavbottom.customer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tsafundzic.rotisseriesappnavbottom.utils.BaseFragment;
import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Customer;
import com.tsafundzic.rotisseriesappnavbottom.model.ProductAmount;
import com.tsafundzic.rotisseriesappnavbottom.product.ProductBuyAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerBuyProductsFragment extends BaseFragment implements View.OnClickListener {

    Button buyProducts;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    Customer loggedCustomer = DataHolder.getInstance().getLoggedCustomer();
    List<ProductAmount> productAmounts = DataHolder.getInstance().getProductAmounts();

    public CustomerBuyProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_buy_products, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvProductList);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductBuyAdapter();
        recyclerView.setAdapter(adapter);

        buyProducts = view.findViewById(R.id.btnBuySelectedProducts);
        buyProducts.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double currentCustomerBalance = DataHolder.getInstance().returnCurrentCustomerBalance(loggedCustomer);
        double totalPrice = 0;

        for (ProductAmount productAmount : productAmounts) {
            totalPrice += productAmount.getAmountOfProduct() * productAmount.getProductPrice();
        }
        if (currentCustomerBalance >= totalPrice) {
            DataHolder.getInstance().setCustomerBalance(loggedCustomer, currentCustomerBalance - totalPrice);
            Toast.makeText(getActivity(), R.string.successful, Toast.LENGTH_SHORT).show();

            BaseFragment.changeFragments(R.id.fragmentFrameCustomerChooser, new CustomerBalanceFragment(), getActivity());

        } else {
            Toast.makeText(getActivity(), R.string.you_dont_have_money, Toast.LENGTH_SHORT).show();
        }


        productAmounts.removeAll(productAmounts);
    }
}
