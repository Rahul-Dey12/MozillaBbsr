package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KIIT on 22-03-2019.
 */

public class speakerAdapter extends ArrayAdapter {
    Context mcontext;
    ArrayList<speakerData> mspeakerDataList;
    public speakerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<speakerData> speakerDataList) {
        super(context, resource, speakerDataList);
        this.mcontext=context;
        this.mspeakerDataList =speakerDataList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if(convertView==null){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.speaker_details,parent,false);
        }
        else{
            view=convertView;
        }
        ImageView spimage = view.findViewById(R.id.sp_img);
        spimage.setImageResource(mspeakerDataList.get(position).getImgurl());

        TextView spname=view.findViewById(R.id.sp_name);
        spname.setText(mspeakerDataList.get(position).getName());

        TextView spdesc=view.findViewById(R.id.sp_desc);
        spdesc.setText(mspeakerDataList.get(position).getTitle());

        return view;
    }
}
