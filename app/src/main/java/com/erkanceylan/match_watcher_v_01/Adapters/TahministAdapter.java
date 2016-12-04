package com.erkanceylan.match_watcher_v_01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.erkanceylan.match_watcher_v_01.Models.Fixture;
import com.erkanceylan.match_watcher_v_01.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by ERKAN on 3.12.2016.
 */

public class TahministAdapter extends ArrayAdapter<Fixture>
{
    ArrayList<Fixture> fixtures;
    Context context;
    int resource;
    int tvResourceId;
    public TahministAdapter(Context context, int resource, int textViewResourceId, ArrayList<Fixture> objects)
    {
        super(context, resource, textViewResourceId, objects);

        this.tvResourceId=textViewResourceId;
        this.fixtures=objects;
        this.context=context;
        this.resource=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.tahminist_layout,null,true);
        }
        Fixture thisFixture=getItem(position);

        TextView dateText=(TextView)convertView.findViewById(R.id.txtTahministDate);
        TextView fixtureText=(TextView)convertView.findViewById(R.id.txtTahministFixtureText);

        TextView txtview=(TextView)convertView.findViewById(tvResourceId);

        return super.getView(position,convertView,parent);
    }
}
