package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView upRecyclerView;
    RecyclerView psRecyclerView;
    Data upData;
    Data psData;
    ArrayList<Data> upDataList;
    ArrayList<Data> psDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        upDataList = new ArrayList<Data>();
        upRecyclerView = view.findViewById(R.id.up_recyclerview);
        GridLayoutManager upGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        upRecyclerView.setLayoutManager(upGridLayoutManager);

        upData =new Data(R.drawable.hackathon,"Hackathon");
        upDataList.add(upData);
        upData =new Data(R.drawable.recuritment,"recuritment");
        upDataList.add(upData);
        upData =new Data(R.drawable.webvr,"WebVr");
        upDataList.add(upData);
        upData =new Data(R.drawable.rust,"Rust");
        upDataList.add(upData);
        upData =new Data(R.drawable.googlemini,"Googlemini");
        upDataList.add(upData);

        DataAdapter upAdapter=new DataAdapter(getActivity(), upDataList);
        upRecyclerView.setAdapter(upAdapter);

        /*psDataList = new ArrayList<Data>();
        psRecyclerView = view.findViewById(R.id.ps_recyclerview);
        GridLayoutManager psGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        psRecyclerView.setLayoutManager(psGridLayoutManager);

        psData =new Data(R.drawable.github,"OpenSource");
        psDataList.add(psData);
        psData =new Data(R.drawable.rust,"Rust");
        psDataList.add(psData);
        psData =new Data(R.drawable.googlemini,"Googlemini");
        psDataList.add(psData);

        DataAdapter psAdapter=new DataAdapter(getActivity(), psDataList);
        psRecyclerView.setAdapter(psAdapter);*/
        return view;
    }
}
