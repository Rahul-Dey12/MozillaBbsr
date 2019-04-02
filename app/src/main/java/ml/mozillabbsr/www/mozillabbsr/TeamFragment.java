package ml.mozillabbsr.www.mozillabbsr;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<memberData> dataArrayList;
    private DatabaseReference mref;
    private memberAdapter mymemberAdapter;
    TextView descText,descText2;
    ImageButton plus,plus2, minus,minus2;
    ProgressBar progressBar;
    ConstraintLayout mcontainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        progressBar = view.findViewById(R.id.progressBar_team);
        mcontainer = view.findViewById(R.id.container_team);
        progressBar.setVisibility(View.VISIBLE);
        mcontainer.setVisibility(View.GONE);

        descText = (TextView) view.findViewById(R.id.description_text);
        plus = (ImageButton) view.findViewById(R.id.plus);
        minus = (ImageButton) view.findViewById(R.id.minus);
        descText2 = (TextView) view.findViewById(R.id.description_text2);
        plus2 = (ImageButton) view.findViewById(R.id.plus2);
        minus2 = (ImageButton) view.findViewById(R.id.minus2);

        clickevent();


        mref= FirebaseDatabase.getInstance().getReference().child("members");
        recyclerView=view.findViewById(R.id.member_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        dataArrayList =new ArrayList<>();
        //dataArrayList.add(new memberData("Manzar Hasnain","Club Captain", "Marketin & Evernt organizer", "https://firebasestorage.googleapis.com/v0/b/mozillabbsr-47731.appspot.com/o/manzar_hasnain.jpg?alt=media&token=fce999fc-db3d-460e-8852-d948d58f06b4"));
        mymemberAdapter=new memberAdapter(getActivity(),dataArrayList);
        recyclerView.setAdapter(mymemberAdapter);
        preparedata();
        return view;
    }

    private void preparedata() {
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot qslistsnapshot : dataSnapshot.getChildren())
                {
                    try {
                        memberData memberData = qslistsnapshot.getValue(memberData.class);
                        dataArrayList.add(memberData);

                    }catch (Exception e){}
                }
                mymemberAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                mcontainer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    void clickevent(){
        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                plus.setVisibility(View.GONE);
                minus.setVisibility(View.VISIBLE);
                descText.setMaxLines(Integer.MAX_VALUE);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                minus.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                descText.setMaxLines(5);

            }
        });
        plus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                plus2.setVisibility(View.GONE);
                minus2.setVisibility(View.VISIBLE);
                descText2.setMaxLines(Integer.MAX_VALUE);

            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);
                descText2.setMaxLines(5);

            }
        });

    }

}
