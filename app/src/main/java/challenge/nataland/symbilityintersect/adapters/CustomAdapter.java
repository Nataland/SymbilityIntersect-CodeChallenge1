package challenge.nataland.symbilityintersect.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import challenge.nataland.symbilityintersect.R;
import challenge.nataland.symbilityintersect.models.Crypto;

/**
 * Created by natalie on 2018-10-07.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Crypto> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Crypto> dataList) {
        this.context = context;
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
        holder.txtTitle.setText(dataList.get(position).getCoinName());
        holder.txtTitle.setText(dataList.get(position).getPrice().toString());

//        holder.txtTitle.setText(dataList.get(position).getTagName());

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
