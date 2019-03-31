package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ml.mozillabbsr.www.mozillabbsr.R;

public class SlideAdapter extends PagerAdapter {

    LayoutInflater layoutInflater;
    Context context;
    ArrayList<String> lst_images;

    public SlideAdapter(Context context, ArrayList<String> lst_images) {
        this.context = context;
        this.lst_images = lst_images;
    }

    public SlideAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return lst_images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide=(LinearLayout)view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide=(ImageView)view.findViewById(R.id.slideimg);
        Glide.with(context).load(lst_images.get(position)).thumbnail(0.1f).into(imgslide);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
