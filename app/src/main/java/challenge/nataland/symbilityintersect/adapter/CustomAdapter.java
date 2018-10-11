package challenge.nataland.symbilityintersect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import challenge.nataland.symbilityintersect.R;
import challenge.nataland.symbilityintersect.model.Crypto;

/**
 * Created by natalie on 2018-10-07.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Crypto> dataList;

    public CustomAdapter(List<Crypto> dataList) {
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View view;

        TextView txtTitle;
        TextView txtPrice;
        ImageView iconFavourite;

        CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtTitle = view.findViewById(R.id.title);
            txtPrice = view.findViewById(R.id.price);
            iconFavourite = view.findViewById(R.id.favourite);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_favourite, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtTitle.setText(dataList.get(position).getName());
        NumberFormat format = NumberFormat.getCurrencyInstance();
        holder.txtPrice.setText(format.format(dataList.get(position).getPrice()));

        // TODO: onClick Listener for the favourite button

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, ProductsListPageActivity.class);
//
//                intent.putExtra("LIST", (Serializable) dataList.get(position).getProducts());
//                intent.putExtra("NAME", dataList.get(position).getTagName());
//
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
