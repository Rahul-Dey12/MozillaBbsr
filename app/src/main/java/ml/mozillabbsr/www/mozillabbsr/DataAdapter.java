package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KIIT on 02-03-2019.
 */

public class DataAdapter extends RecyclerView.Adapter<mViewHolder>{

    Context mcontext;
    List<Data> mDataList;

    DataAdapter(Context mContext, List<Data> dataList) {
        this.mcontext = mContext;
        this.mDataList = dataList;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new mViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        holder.mImage.setImageResource(mDataList.get(position).getImgurl());
        holder.mTitle.setText(mDataList.get(position).getTitle());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mcontext, DetailActivity.class);
                mIntent.putExtra("Title",mDataList.get(holder.getAdapterPosition()).getTitle());
                //mIntent.putExtra("Description",mDataList.get(holder.getAdapterPosition()).ge);
                mIntent.putExtra("Image", mDataList.get(holder.getAdapterPosition()).getImgurl());
                mcontext.startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
class mViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    CardView mCardView = itemView.findViewById(R.id.card_view);
    mViewHolder(View itemView) {

        super(itemView);
        mImage = itemView.findViewById(R.id.image_view);
        mTitle = itemView.findViewById(R.id.event_title);
    }
}
