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
import com.example.dell.benahapp.calender.calenderMain;
import com.example.dell.benahapp.course.courseMain;
import com.example.dell.benahapp.gallery.galleryMain;
import com.example.dell.benahapp.maps.mapMain;
import com.example.dell.benahapp.protal.portalMain;
import com.example.dell.benahapp.result.resultMain;

import java.util.ArrayList;
import java.util.List;


public class studentservicefragment extends Fragment {

    public static final String ALERT = "Notifications";
    public static final String LIBRARY = "Library";
    public static final String MAP = "Maps";
    public static final String ATTENDANCE = "Attendence";
    public static final String STAFF = "Staff";
    public static final String OFFICE = "Office 365";
    public static final String EKB = "EKB";
    public static final String PORTAL = "Portal";
    public static final String GALLERY = "News";
    public static final String COURSE = "Courses";
    public static final String CALENDER = "Time Table";
    public static final String RESULT = "Exam Results";
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

        ViewHolder v9=new ViewHolder();
        v9.settitle(GALLERY);
        v9.setid(R.drawable.gallery);

        ViewHolder v10=new ViewHolder();
        v10.settitle(COURSE);
        v10.setid(R.drawable.course);

        ViewHolder v11=new ViewHolder();
        v11.settitle(CALENDER);
        v11.setid(R.drawable.calender);

        ViewHolder v12=new ViewHolder();
        v12.settitle(RESULT);
        v12.setid(R.drawable.results);


        ArrayOfData.add(v4); // attendence
        ArrayOfData.add(v11); // calender
        ArrayOfData.add(v9); // news
        ArrayOfData.add(v10); // courses
        ArrayOfData.add(v3); // Maps
        ArrayOfData.add(v1); // alert

        ArrayOfData.add(v12); // results
        ArrayOfData.add(v8); // portal
        ArrayOfData.add(v7); // EKB
        ArrayOfData.add(v5);  // office

        ArrayOfData.add(v2); // library
        ArrayOfData.add(v6); // staff



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
                else if(vh.gettitle().equals(GALLERY))
                {
                    Intent i=new Intent( getActivity(), galleryMain.class);
                    startActivity(i);
                }else if(vh.gettitle().equals(COURSE))
                {
                    Intent i=new Intent( getActivity(), courseMain.class);
                    startActivity(i);
                }
                else if(vh.gettitle().equals(CALENDER))
                {
                    Intent i=new Intent( getActivity(), calenderMain.class);
                    startActivity(i);
                }
                else if(vh.gettitle().equals(RESULT))
                {
                    Intent i=new Intent( getActivity(), resultMain.class);
                    startActivity(i);
                }
                else if(vh.gettitle().equals(MAP))
                {
                    Intent i=new Intent( getActivity(), mapMain.class);
                    startActivity(i);
                }
            }
            });

        Go.requestFocus();


        return v;
    }

}
