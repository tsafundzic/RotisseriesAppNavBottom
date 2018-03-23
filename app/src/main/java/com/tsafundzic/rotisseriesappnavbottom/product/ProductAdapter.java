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

import java.util.List;

/**
 * Created by Tomislav on 21.3.2018..
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

   private List<Product> products = DataHolder.getInstance().getProducts();

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.productID.setText(String.valueOf(products.get(position).getProductID()));
        holder.productName.setText(products.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(products.get(position).getProductPrice()));
    }

    @Override
    public int getItemCount() {
        return DataHolder.getInstance().getProductSize();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productID;
        TextView productName;
        TextView productPrice;
        Button deleteProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            productID = itemView.findViewById(R.id.tvProductID);
            productName = itemView.findViewById(R.id.tvProductName);
            productPrice = itemView.findViewById(R.id.tvProductPrice);
            deleteProduct = itemView.findViewById(R.id.btnDeleteItem);

            deleteProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    products.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
