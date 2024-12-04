package edu.mga.henrybookstore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Inventory> inventoryList;
    private Context context;

    public CustomAdapter(Context context,List<Inventory> inventoryList){
        this.context = context;
        this.inventoryList = inventoryList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtBookId;
        TextView txtBranchId;
        TextView txtQuantity;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtBookId = mView.findViewById(R.id.txtBookId);
            txtBranchId = mView.findViewById(R.id.txtBranchId);
            txtQuantity = mView.findViewById(R.id.txtQuantity);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtBookId.setText(inventoryList.get(position).getBookId().toString());
        holder.txtBranchId.setText(inventoryList.get(position).getBranchId().toString());
        holder.txtQuantity.setText(inventoryList.get(position).getQuantity().toString());
    }

    @Override
    public int getItemCount() {
        return inventoryList.size();
    }
}
