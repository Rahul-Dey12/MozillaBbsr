package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by KIIT on 02-03-2019.
 */

class ImageAdapter extends BaseAdapter {

    private Context mContext;
    public Integer[] mThumbIds = {
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d
    };
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return mThumbIds[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if(view==null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else {
                imageView = (ImageView) view;
        }
        //String url = getItem(i);
        imageView.setImageResource(mThumbIds[i]);
        return imageView;
    }
}
