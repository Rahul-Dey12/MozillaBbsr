package ml.mozillabbsr.www.mozillabbsr;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        mref= FirebaseDatabase.getInstance().getReference().child("members");
        recyclerView=view.findViewById(R.id.member_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Getting Information.....");
        progressDialog.show();
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
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}
