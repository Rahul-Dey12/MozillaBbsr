package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView mRecyclerView;
    Data mData;
    ArrayList<Data> mDataList;
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

        mDataList = new ArrayList<Data>();
        mRecyclerView = mview.findViewById(R.id.up_recyclerview);
        GridLayoutManager upGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(upGridLayoutManager);

        mData =new Data(R.drawable.hackathon,"Hackathon");
        mDataList.add(mData);
        mData =new Data(R.drawable.recuritment,"recuritment");
        mDataList.add(mData);
        mData =new Data(R.drawable.webvr,"WebVr");
        mDataList.add(mData);


        mData =new Data(R.drawable.github,"OpenSource");
        mDataList.add(mData);
        mData =new Data(R.drawable.rust,"Rust");
        mDataList.add(mData);
        mData =new Data(R.drawable.googlemini,"Googlemini");
        mDataList.add(mData);

        DataAdapter upAdapter=new DataAdapter(getActivity(), mDataList);
        mRecyclerView.setAdapter(upAdapter);
        return mview;
    }
}
