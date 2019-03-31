package ml.mozillabbsr.www.mozillabbsr;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class HomeFragment extends Fragment {
    ArrayList<String> posterLink;
    RecyclerView upRecyclerView;
    ArrayList<eventData> upDataList;
    eventDataAdapter upAdapter;
    RecyclerView psRecyclerView;
    eventData psData;
    ArrayList<eventData> psDataList;
    ViewPager viewpager;
    SlideAdapter myadapter;
    private DatabaseReference mref;
    private ProgressDialog progressDialog;
    eventDataAdapter psAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview = inflater.inflate(R.layout.fragment_home2, container, false);

        mref = FirebaseDatabase.getInstance().getReference();
        viewpager=mview.findViewById(R.id.viewpager);
        posterLink=new ArrayList<>();
        myadapter=new SlideAdapter(getActivity(),posterLink);
        viewpager.setAdapter(myadapter);

        upDataList = new ArrayList<>();
        //eventData upData =new eventData("https://firebasestorage.googleapis.com/v0/b/mozillabbsr-47731.appspot.com/o/hackathon_newlogo.jpg?alt=media&token=595627f5-afdb-4ec3-bccf-5fb6005d6081","Hackathon", "10/03/2019", "mozillabbsr");
        //upDataList.add(upData);

        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Getting Information.....");
        progressDialog.show();

        upRecyclerView = mview.findViewById(R.id.up_recyclerview);
        upRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        upAdapter=new eventDataAdapter(getActivity(), upDataList);
        upRecyclerView.setAdapter(upAdapter);

        psDataList = new ArrayList<>();
        psRecyclerView = mview.findViewById(R.id.ps_recyclerview);
        psRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        psAdapter=new eventDataAdapter(getActivity(), psDataList);
        psRecyclerView.setAdapter(psAdapter);
        prepareData();
        return mview;
    }

    private void prepareData() {
        mref.child("event").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot qslistsnapshot : dataSnapshot.getChildren()) {
                    try {
                        eventData eventData = qslistsnapshot.getValue(eventData.class);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_YEAR, -1);
                        Date date1 = calendar.getTime();
                        //Toast toast= Toast.makeText(getActivity(),sp,Toast.LENGTH_SHORT);
                        //toast.show();
                        //eventData.setDate(sdf.format(date1));
                        Date date2 = sdf.parse(eventData.getDate());
                        if (date2.after(date1)) {
                            upDataList.add(eventData);
                            upAdapter.notifyDataSetChanged();

                        } else {
                            psDataList.add(eventData);
                            psAdapter.notifyDataSetChanged();
                        }
                        eventData.setKey(qslistsnapshot.getKey());

                    } catch (Exception e) {
                    }
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        mref.child("banner").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot qslistsnapshot : dataSnapshot.getChildren()) {
                    try {
                        String posurl = qslistsnapshot.getValue(String.class);
                        posterLink.add(posurl);

                    } catch (Exception e) {


                    }
                }
                myadapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }

