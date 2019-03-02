package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
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
    List<Data> meventdataList;

    DataAdapter(Context mContext, List<Data> dataList) {
        this.mcontext = mContext;
        this.meventdataList = dataList;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new mViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        holder.mImage.setImageResource(meventdataList.get(position).getImgurl());
        holder.mTitle.setText(meventdataList.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return meventdataList.size();
    }
}
class mViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    mViewHolder(View itemView) {

        super(itemView);
        mImage = itemView.findViewById(R.id.image_view);
        mTitle = itemView.findViewById(R.id.event_title);
    }
}
