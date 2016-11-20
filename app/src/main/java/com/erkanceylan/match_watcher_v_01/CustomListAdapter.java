package com.erkanceylan.match_watcher_v_01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erkanceylan.match_watcher_v_01.Models.Team;

import java.util.ArrayList;
/**
 * Created by ERKAN on 7.11.2016.
 */

public class CustomListAdapter extends ArrayAdapter<Team>
{
    ArrayList<Team> teams;
    Context context;
    int resource;
    public CustomListAdapter(Context context, int resource, ArrayList<Team> objects) {
        super(context, resource, objects);

        this.teams=objects;
        this.context=context;
        this.resource=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_list_layout,null,true);
        }
        Team myTeam=(Team)getItem(position);

        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);

        TextView teamName=(TextView)convertView.findViewById(R.id.txtTeamName);
        teamName.setText(myTeam.getTeamName());

        TextView teamScore=(TextView)convertView.findViewById(R.id.txtTeamScore);
        teamScore.setText("Game: "+myTeam.getGameCount()+" Points:"+myTeam.getPoint());

        return super.getView(position,convertView,parent);
    }
}
