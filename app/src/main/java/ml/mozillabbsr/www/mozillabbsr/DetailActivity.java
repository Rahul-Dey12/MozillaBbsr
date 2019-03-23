package ml.mozillabbsr.www.mozillabbsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ImageView mImage;
    TextView mTitle;
    GridView mgridView;
    ArrayList<speakerData> marrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImage = findViewById(R.id.ivImage);
        mTitle = findViewById(R.id.tvDescription);
        mgridView = (GridView)findViewById(R.id.sp_gridview);



        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            //mImage.setImageResource(mBundle.getInt("Image"));
            mTitle.setText(mBundle.getString("Title"));
        }
        marrayList=new ArrayList<>();
        marrayList.add(new speakerData(R.drawable.github,"Rahul","CSE"));
        marrayList.add(new speakerData(R.drawable.github,"Arko","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));

        speakerAdapter mspeakerAdapter=new speakerAdapter(this,R.layout.speaker_details,marrayList);
        mgridView.setAdapter(mspeakerAdapter);
        mgridView.setFocusable(false);
       // mgridView.setVerticalScrollBarEnabled(false);
    }
}
