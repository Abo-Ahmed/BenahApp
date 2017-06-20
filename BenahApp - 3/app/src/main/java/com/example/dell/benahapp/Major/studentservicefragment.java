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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;

import com.example.dell.benahapp.R;
import com.example.dell.benahapp.attend.AttendenceActivity;
import com.example.dell.benahapp.attend.pluserActivity;
import com.example.dell.benahapp.protal.portalMain;

import java.util.ArrayList;
import java.util.List;


public class studentservicefragment extends Fragment {

    public static final String ALERT = "ALERT";
    public static final String LIBRARY = "LIBRARY";
    public static final String MAP = "MAP";
    public static final String ATTENDANCE = "ATTENDANCE";
    public static final String STAFF = "STAFF";
    public static final String OFFICE = "OFFICE 365";
    public static final String EKB = "EKB";
    public static final String PORTAL = "PORTAL";

    View v;
    Toolbar toolbar;
    public List<ViewHolder> ArrayOfData=new ArrayList<>();
    public studentservicefragment() {
        // Required empty public constructor
    }



    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    public void searchAutoComplete2()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                v.findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      v=inflater.inflate(R.layout.fragment_startfragment, container, false);
  //      toolbar = (Toolbar) v.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        //ListView l=(ListView)v.findViewById(R.id.l1);


        Button Go = (Button) v.findViewById(R.id.buttonGo);

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , pluserActivity.class);

                startActivity(intent);
            }
        });

        searchAutoComplete2();

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

        ViewHolder v7=new ViewHolder();
        v7.settitle(EKB);
        v7.setid(R.drawable.ekb);

        ViewHolder v8=new ViewHolder();
        v8.settitle(PORTAL);
        v8.setid(R.drawable.portal);

        ArrayOfData.add(v1);
        ArrayOfData.add(v2);
        ArrayOfData.add(v3);
        ArrayOfData.add(v4);
        ArrayOfData.add(v5);
        ArrayOfData.add(v6);
        ArrayOfData.add(v7);
        ArrayOfData.add(v8);


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
                else if(vh.gettitle().equals(STAFF))
                {
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bu.edu.eg/portal/index.php?act=104"));
                    startActivity(i);
                }
                else if(vh.gettitle().equals(ATTENDANCE))
                {
                    Intent i=new Intent( getActivity(), AttendenceActivity.class);
                    startActivity(i);
                }
                else if(vh.gettitle().equals(LIBRARY))
                {
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://srv3.eulc.edu.eg/eulc_v5/libraries/start.aspxn"));
                    startActivity(i);
                }else if(vh.gettitle().equals(EKB))
                {
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekb.eg/login"));
                    startActivity(i);
                }
                else if(vh.gettitle().equals(PORTAL))
                {
                    Intent i=new Intent( getActivity(), portalMain.class);
                    startActivity(i);
                }
            }
            });


        return v;
    }

}
