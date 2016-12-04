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

import com.erkanceylan.match_watcher_v_01.Models.Team;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.COLOR;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by ERKAN on 7.11.2016.
 */

public class StandingsAdapter extends ArrayAdapter<Team>
{
    ArrayList<Team> teams;
    Context context;
    int resource;
    String leagueAbr;
    int tvResourceId;
    public StandingsAdapter(Context context, int resource, int textViewResourceId,  ArrayList<Team> objects, String leagueAbr)
    {
        super(context, resource, textViewResourceId, objects);

        this.tvResourceId=textViewResourceId;
        this.leagueAbr=leagueAbr;
        this.teams=objects;
        this.context=context;
        this.resource=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.standings_layout,null,true);
        }
        Team thisTeam=getItem(position);

        TextView teamName=(TextView)convertView.findViewById(R.id.txtStandingsTeamName);
        TextView stats=(TextView)convertView.findViewById(R.id.txtStandingsStats);
        TextView rank=(TextView)convertView.findViewById(R.id.txtRank);
        TextView txtview=(TextView)convertView.findViewById(tvResourceId);

        rank.setBackgroundColor(COLOR.getRankColor(this.leagueAbr,position+1));
        rank.setText(Integer.toString(position+1));
        teamName.setText(thisTeam.getTeamName());
        Log.e("->",thisTeam.getTeamName());
        String playedGames=Integer.toString(thisTeam.getPlayedGames());
        String goalDiff=Integer.toString(thisTeam.getGoalDifference());
        String points=Integer.toString(thisTeam.getPoints());


        stats.setText(StatsEditor(playedGames)+" "+StatsEditor(goalDiff)+" "+StatsEditor(points));

        return super.getView(position,convertView,parent);
    }

    private String StatsEditor(String str)
    {
        if(str.length()<7)
        {
            for (str.length(); str.length()<7;)
            {
                str=" "+str;
            }
        }
        return str;
    }
}
