package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by KIIT on 22-03-2019.
 */

public class speakerAdapter extends RecyclerView.Adapter<spViewHolder> {
    Context mcontext;
    ArrayList<speakerData> mspeakerDataList;

    public speakerAdapter(Context mcontext, ArrayList<speakerData> mspeakerDataList) {
        this.mcontext = mcontext;
        this.mspeakerDataList = mspeakerDataList;
    }

    @NonNull
    @Override
    public spViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.speaker_details, viewGroup, false);
        return new spViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull spViewHolder spViewHolder, int i) {
        Glide.with(mcontext).load(mspeakerDataList.get(i).getImgurl()).into(spViewHolder.mImage);
        spViewHolder.mName.setText(mspeakerDataList.get(i).getName());
        spViewHolder.mTitle.setText(mspeakerDataList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mspeakerDataList.size();
    }
}
class spViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    TextView mName;

    spViewHolder(View itemView) {

        super(itemView);
        mImage = itemView.findViewById(R.id.sp_img);
        mName = itemView.findViewById(R.id.sp_name);
        mTitle = itemView.findViewById(R.id.sp_desc);
    }
}

