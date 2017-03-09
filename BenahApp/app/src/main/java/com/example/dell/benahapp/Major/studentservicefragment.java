package com.example.dell.benahapp.Major;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dell.benahapp.R;
import com.example.dell.benahapp.attend.AttendenceActivity;

import java.util.ArrayList;
import java.util.List;


public class studentservicefragment extends Fragment {

    public static final String ALERT = "ALERT";
    public static final String LIBRARY = "LIBRARY";
    public static final String MAP = "MAP";
    public static final String ATTENDANCE = "ATTENDANCE";
    public static final String STAFF = "STAFF";
    public static final String OFFICE = "OFFICE 365";

    View v;
    Toolbar toolbar;
    public List<ViewHolder> ArrayOfData=new ArrayList<>();
    public studentservicefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      v=inflater.inflate(R.layout.fragment_startfragment, container, false);
  //      toolbar = (Toolbar) v.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        //ListView l=(ListView)v.findViewById(R.id.l1);
        GridView g=(GridView)v.findViewById(R.id.gridView);

        ViewHolder v1=new ViewHolder();
        v1.settitle(ALERT);
        v1.setid(R.drawable.ic_alert);

       ViewHolder v2=new ViewHolder();
        v2.settitle(LIBRARY);
        v2.setid(R.drawable.library);

        ViewHolder v3=new ViewHolder();
        v3.settitle(MAP);
        v3.setid(R.drawable.map);

        ViewHolder v4=new ViewHolder();
        v4.settitle(ATTENDANCE);
        v4.setid(R.drawable.ic_rafid);

        ViewHolder v5=new ViewHolder();
        v5.settitle(OFFICE);
        v5.setid(R.drawable.outlook);


        ViewHolder v6=new ViewHolder();
        v6.settitle(STAFF);
        v6.setid(R.drawable.searchstaff);


        ArrayOfData.add(v1);
        ArrayOfData.add(v2);
        ArrayOfData.add(v3);
        ArrayOfData.add(v4);
        ArrayOfData.add(v5);
        ArrayOfData.add(v6);


        ImageAdapter a=new ImageAdapter(getContext(),R.layout.griditem,ArrayOfData);
        g.setAdapter(a);

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ViewHolder vh=ArrayOfData.get(position);
                Log.v("xtest" , "oncllick items");


                if(vh.gettitle().equals(OFFICE))
                {
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://outlook.office.com/owa/"));
                    startActivity(i);
                }

               if(vh.gettitle().equals(STAFF))
                {
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bu.edu.eg/portal/index.php?act=104"));
                    startActivity(i);
                }

                if(vh.gettitle().equals(ATTENDANCE))
                {
                    Intent i=new Intent( getActivity(), AttendenceActivity.class);
                    startActivity(i);
                }

            }
            });


        return v;
    }

}
