package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interac.kits.calenderModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CalenderView extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ArrayList<calenderModel> listItem =AcademicCalendar.senditem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);

        if(getIntent().getStringExtra("Session").equals("22-23")){
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, listItem) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                    SimpleDateFormat DateFor = new SimpleDateFormat("dd MMMM yyyy");
                    text1.setText("Event: "+listItem.get(position).getEvent().get("Event"));
                    text2.setText("Date: "+DateFor.format(listItem.get(position).getD()));
                    text1.setTextColor(getResources().getColor(R.color.black));
                    text2.setTextColor(getResources().getColor(R.color.black));
                    text2.setGravity(Gravity.RIGHT);
                    return view;
                }
            };
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                calenderModel value= (calenderModel) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value.getEvent().get("Event"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}