package com.erkanceylan.match_watcher_v_01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.erkanceylan.match_watcher_v_01.Fragments.TahministTab;
import com.erkanceylan.match_watcher_v_01.Models.Fixture;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.Tahmin.TahministReyis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by ERKAN on 3.12.2016.
 */

public class TahministAdapter extends ArrayAdapter<TahministReyis>
{
    ArrayList<TahministReyis> fixtures;
    Context context;
    int resource;
    int tvResourceId;
    public TahministAdapter(Context context, int resource, int textViewResourceId, ArrayList<TahministReyis> objects)
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
        TahministReyis thisFixture=getItem(position);

        TextView dateText=(TextView)convertView.findViewById(R.id.txtTahministDate);
        TextView fixtureText=(TextView)convertView.findViewById(R.id.txtTahministFixtureText);

        TextView txtview=(TextView)convertView.findViewById(tvResourceId);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd / MM / yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH : mm");
        dateText.setText(sdf1.format(thisFixture.getDate())+"\n"+sdf2.format(thisFixture.getDate()));
        fixtureText.setText(thisFixture.getHomeTeamName()+" "+thisFixture.getHomeTeamGoalsPredict()+" - "+thisFixture.getAwayTeamGoalsPredict()+" "+thisFixture.getAwayTeamName());

        return super.getView(position,convertView,parent);
    }
}
