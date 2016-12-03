package com.erkanceylan.match_watcher_v_01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erkanceylan.match_watcher_v_01.Models.Fixture;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.COLOR;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by ERKAN on 7.11.2016.
 */

public class MatchResultsAdapter extends ArrayAdapter<Fixture>
{
    ArrayList<Fixture> fixtures;
    Context context;
    int resource;
    int tvResourceId;
    public MatchResultsAdapter(Context context, int resource, int textViewResourceId, ArrayList<Fixture> objects)
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
            convertView=inflater.inflate(R.layout.match_results_layout,null,true);
        }
        Fixture thisFixture=getItem(position);

        TextView dateText=(TextView)convertView.findViewById(R.id.txtDate);
        TextView fixtureText=(TextView)convertView.findViewById(R.id.txtFixtureText);

        TextView txtview=(TextView)convertView.findViewById(tvResourceId);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd / MM / yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH : mm");
        dateText.setText(sdf1.format(thisFixture.getDate())+"\n"+sdf2.format(thisFixture.getDate()));
        fixtureText.setText(thisFixture.getHomeTeamName()+" "+thisFixture.getGoalsHomeTeam()+" - "+thisFixture.getGoalsAwayTeam()+" "+thisFixture.getAwayTeamName());

        return super.getView(position,convertView,parent);
    }
}
