package com.erkanceylan.match_watcher_v_01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.COLOR;

import java.util.ArrayList;
/**
 * Created by ERKAN on 7.11.2016.
 */

public class LeagueListAdapter extends ArrayAdapter<League>
{
    ArrayList<League> leagues;
    Context context;
    int resource;
    int tvResourceId;
    public LeagueListAdapter(Context context, int resource,int textViewResourceId, ArrayList<League> objects)
    {
        super(context, resource,textViewResourceId, objects);

        this.tvResourceId=textViewResourceId;
        this.leagues=objects;
        this.context=context;
        this.resource=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.league_list_layout,null,true);
        }
        League thisLeague=getItem(position);

        ImageView leagueImageView=(ImageView)convertView.findViewById(R.id.leaguePicture);
        TextView txtview=(TextView)convertView.findViewById(tvResourceId);
        TextView leagueName=(TextView)convertView.findViewById(R.id.txtLeagueName);
        TextView leagueAbr=(TextView)convertView.findViewById(R.id.textLeagueAbrevation);

        convertView.setBackgroundColor(COLOR.getColor(thisLeague.getLeagueAbrevation()));
        leagueImageView.setImageResource(League.getImage(thisLeague.getLeagueAbrevation()));
        leagueName.setText(thisLeague.getLeagueName());
        Log.e("->",thisLeague.getLeagueName());
        leagueAbr.setText(thisLeague.getLeagueAbrevation());

        return super.getView(position,convertView,parent);
    }
}
