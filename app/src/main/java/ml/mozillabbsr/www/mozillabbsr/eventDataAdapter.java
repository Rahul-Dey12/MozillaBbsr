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

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by KIIT on 02-03-2019.
 */

public class eventDataAdapter extends RecyclerView.Adapter<mViewHolder>{

    Context mcontext;
    List<eventData> mDataList;

    eventDataAdapter(Context mContext, List<eventData> dataList) {
        this.mcontext = mContext;
        this.mDataList = dataList;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new mViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(final mViewHolder holder, final int position) {
        Glide.with(mcontext).load(mDataList.get(position).getLogourl()).thumbnail(0.1f).into(holder.mImage);
        holder.mName.setText(mDataList.get(position).getName());
        holder.mTitle.setText(mDataList.get(position).getTitle());
        holder.mDate.setText(mDataList.get(position).getDate());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mcontext, DetailActivity.class);
                mIntent.putExtra("eKey",mDataList.get(position).getKey());
                mIntent.putExtra("ePoster",mDataList.get(position).getPoster());
                mIntent.putExtra("eName",mDataList.get(position).getName());
                mIntent.putExtra("eTitle",mDataList.get(position).getTitle());
                mIntent.putExtra("eDate",mDataList.get(position).getDate());
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
    TextView mName;
    TextView mDate;
    TextView mTitle;
    CardView mCardView = itemView.findViewById(R.id.card_view);
    mViewHolder(View itemView) {

        super(itemView);
        mImage = itemView.findViewById(R.id.event_logo);
        mName = itemView.findViewById(R.id.event_name);
        mDate = itemView.findViewById(R.id.event_date);
        mTitle = itemView.findViewById(R.id.event_title);
    }
}
