package com.tsafundzic.rotisseriesappnavbottom.product;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tsafundzic.rotisseriesappnavbottom.R;
import com.tsafundzic.rotisseriesappnavbottom.data.DataHolder;
import com.tsafundzic.rotisseriesappnavbottom.model.Product;
import com.tsafundzic.rotisseriesappnavbottom.model.ProductAmount;

import java.util.List;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class ProductBuyAdapter extends RecyclerView.Adapter<ProductBuyAdapter.ViewHolder> {

    List<Product> products = DataHolder.getInstance().getProducts();
    List<ProductAmount> productAmounts = DataHolder.getInstance().getProductAmounts();

    @Override
    public ProductBuyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_buy_item, parent, false);

        return new ProductBuyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductBuyAdapter.ViewHolder holder, int position) {

        holder.productName.setText(products.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(products.get(position).getProductPrice()));

    }

    @Override
    public int getItemCount() {
        return DataHolder.getInstance().getProductSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        int numberOfProduct = 0;
        TextView productName;
        TextView productPrice;
        TextView productAmount;
        Button increaseProductAmount;
        Button decreaseProductAmount;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.tvProductBuyName);
            productPrice = itemView.findViewById(R.id.tvProductBuyPrice);
            productAmount = itemView.findViewById(R.id.tvProductAmount);
            increaseProductAmount = itemView.findViewById(R.id.btnIncreaseProductAmount);
            decreaseProductAmount = itemView.findViewById(R.id.btnDecreaseProductAmount);

            increaseProductAmount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numberOfProduct++;
                    productAmount.setText(String.valueOf(numberOfProduct));

                    ProductAmount productAmount = new ProductAmount(getAdapterPosition(), products.get(getAdapterPosition()).getProductName(), products.get(getAdapterPosition()).getProductPrice(), 1);
                    productAmounts.add(productAmount);
                }
            });

            decreaseProductAmount.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick(View view) {
                    if (numberOfProduct > 0) {
                        numberOfProduct--;
                        productAmount.setText(String.valueOf(numberOfProduct));

                        productAmounts.remove(productAmounts.get(getAdapterPosition()));
                        notifyDataSetChanged();
                    }
                }
            });

        }
    }
}
