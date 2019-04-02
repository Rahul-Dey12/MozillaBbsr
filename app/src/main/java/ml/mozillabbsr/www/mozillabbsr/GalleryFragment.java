package ml.mozillabbsr.www.mozillabbsr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class GalleryFragment extends Fragment {

//    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        c1= getView().findViewById(R.id.card_view);
//        c2= getView().findViewById(R.id.card_view1);
//        c3= getView().findViewById(R.id.card_view2);
//        c4= getView().findViewById(R.id.card_view3);
//        c5= getView().findViewById(R.id.card_view4);

//        c1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//
//        c2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
//
//        c9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(getActivity(),GalleryImages.class);
//            }
//        });
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

}
