package ml.mozillabbsr.www.mozillabbsr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView upRecyclerView;
    Data upData;
    ArrayList<Data> upDataList;
    RecyclerView psRecyclerView;
    Data psData;
    ArrayList<Data> psDataList;
    Toolbar myToolbar;
    ViewPager viewpager;
    SlideAdapter myadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview = inflater.inflate(R.layout.fragment_home2, container, false);

        viewpager=mview.findViewById(R.id.viewpager);

        myadapter=new SlideAdapter(getActivity());
        viewpager.setAdapter(myadapter);

        upDataList = new ArrayList<>();
        upRecyclerView = mview.findViewById(R.id.up_recyclerview);
       // GridLayoutManager upGridLayoutManager = new GridLayoutManager(getActivity(), 1);
        upRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        upData =new Data(R.drawable.hackathon,"Hackathon");
        upDataList.add(upData);
        upData =new Data(R.drawable.webvr,"WebVr");
        upDataList.add(upData);



        DataAdapter upAdapter=new DataAdapter(getActivity(), upDataList);
        upRecyclerView.setAdapter(upAdapter);

        psDataList = new ArrayList<>();
        psRecyclerView = mview.findViewById(R.id.ps_recyclerview);
        psRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        psData =new Data(R.drawable.rust,"Rust");
        psDataList.add(psData);
        psData =new Data(R.drawable.github,"Open Source");
        psDataList.add(psData);
        psData =new Data(R.drawable.googlemini,"Googlemini");
        psDataList.add(psData);
        DataAdapter psAdapter=new DataAdapter(getActivity(), psDataList);
        psRecyclerView.setAdapter(psAdapter);

        return mview;
    }
}
