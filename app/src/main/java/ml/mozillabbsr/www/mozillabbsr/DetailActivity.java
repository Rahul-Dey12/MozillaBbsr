package ml.mozillabbsr.www.mozillabbsr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ImageView mImage;
    TextView mName;
    TextView mTitle;
    TextView mDate;
    TextView mDesc;
    Button mReg;
    RecyclerView recyclerView;
    ArrayList<speakerData> marrayList;
    private DatabaseReference mref;
    speakerAdapter myspeakerAdapter;
    String eLink;
    String ekey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImage = findViewById(R.id.evImage);
        mName = findViewById(R.id.evName);
        mTitle = findViewById(R.id.evTitle);
        mDate = findViewById(R.id.evDate);
        mDesc = findViewById(R.id.evDesc);
        mReg = findViewById(R.id.evRegister);

        recyclerView = findViewById(R.id.sp_gridview);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            ekey=mBundle.getString("eKey");
            Glide.with(this).load(mBundle.getString("ePoster")).into(mImage);
            mName.setText(mBundle.getString("eName"));
            mTitle.setText(mBundle.getString("eTitle"));
            mDate.setText(mBundle.getString("eDate"));
            mDesc.setText(mBundle.getString("eDescription"));
            eLink = mBundle.getString("eReglink");

        }
        mref = FirebaseDatabase.getInstance().getReference().child("event").child(ekey).child("speaker");
        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(eLink));
                startActivity(intent);
            }
        });

        marrayList = new ArrayList<>();
        /*marrayList.add(new speakerData(R.drawable.github,"Rahul","CSE"));
        marrayList.add(new speakerData(R.drawable.github,"Arko","IT"));
        marrayList.add(new speakerData(R.drawable.github,"Ritik","IT"));*/

        myspeakerAdapter = new speakerAdapter(this, marrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(myspeakerAdapter);
        prepareData();
        recyclerView.setFocusable(false);
    }
    private void prepareData() {
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot qslistsnapshot : dataSnapshot.getChildren())
                {
                    try {
                        speakerData mspeakerData = qslistsnapshot.getValue(speakerData.class);
                        marrayList.add(mspeakerData);

                    }catch (Exception e){}
                }
                myspeakerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}


