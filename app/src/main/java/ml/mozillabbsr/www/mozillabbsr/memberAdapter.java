package ml.mozillabbsr.www.mozillabbsr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by KIIT on 23-03-2019.
 */

public class memberAdapter extends RecyclerView.Adapter<meViewHolder>{
    Context mcontext;
    List<memberData> mDataList;


    public memberAdapter(Context mcontext, List<memberData> mDataList) {
        this.mcontext = mcontext;
        this.mDataList = mDataList;
    }
    @NonNull
    @Override
    public meViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_card, viewGroup, false);
        return new meViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final meViewHolder meViewHolder, int i) {
        Glide.with(mcontext).load(mDataList.get(i).getImgurl()).placeholder(R.drawable.ic_account_circle_black_24dp).into(meViewHolder.mImage);
        meViewHolder.mName.setText(mDataList.get(i).getName());
        meViewHolder.mTitle.setText(mDataList.get(i).getTitle());
        meViewHolder.mDesc.setText(mDataList.get(i).getDesg());
        meViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(meViewHolder.mCardView, "scaleX", 1f, 0f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(meViewHolder.mCardView, "scaleX", 0f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                       // meViewHolder.mImage.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                        if(meViewHolder.mDesc.getVisibility()==View.INVISIBLE){
                            meViewHolder.mImage.setVisibility(View.INVISIBLE);
                            meViewHolder.mTitle.setVisibility(View.INVISIBLE);
                            meViewHolder.mName.setVisibility(View.INVISIBLE);
                            meViewHolder.mDesc.setVisibility(View.VISIBLE);

                        }
                        else{
                            meViewHolder.mImage.setVisibility(View.VISIBLE);
                            meViewHolder.mTitle.setVisibility(View.VISIBLE);
                            meViewHolder.mName.setVisibility(View.VISIBLE);
                            meViewHolder.mDesc.setVisibility(View.INVISIBLE);
                        }
                        oa2.start();
                    }
                });
                oa1.start();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
class meViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    TextView mName;
    TextView mDesc;
    CardView mCardView;

    meViewHolder(View itemView) {

        super(itemView);
        mImage = itemView.findViewById(R.id.me_img);
        mName = itemView.findViewById(R.id.me_name);
        mTitle = itemView.findViewById(R.id.me_title);
        mDesc = itemView.findViewById(R.id.mm_details);
        mCardView = itemView.findViewById(R.id.mm_cardview);
    }


}
