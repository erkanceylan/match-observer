package com.erkanceylan.match_watcher_v_01.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.erkanceylan.match_watcher_v_01.Adapters.StandingsAdapter;
import com.erkanceylan.match_watcher_v_01.LeagueTabbedActivity;
import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Models.Team;
import com.erkanceylan.match_watcher_v_01.Querys.QueryCreator;
import com.erkanceylan.match_watcher_v_01.Querys.QueryStringBuilder;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.JsonToObject;

import java.io.IOException;
import java.util.ArrayList;

import layout.Standings;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ERKAN on 1.12.2016.
 */

public class StandingsTab extends Fragment
{
    private ArrayList<Team> teamList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Önce viewler'i elde edelim.
        View rootView = inflater.inflate(R.layout.fragment_standings, container, false);
        final ListView standingsListView=(ListView)rootView.findViewById(R.id.standingsListView);
        ImageView leagueImage=(ImageView)rootView.findViewById(R.id.standingsLeagueImage);
        TextView leagueNameText=(TextView)rootView.findViewById(R.id.standingsLeagueName);

        //Sonra sorgu yapalım.
        if(teamList==null)
        {
            //lig resmi ve adını set edelim.
            leagueImage.setImageResource(League.getImage(LeagueTabbedActivity.bundle.getString("LeagueAbrevation")));
            leagueNameText.setText(LeagueTabbedActivity.bundle.getString("LeagueName"));
            try
            {
                QueryCreator query=new QueryCreator();
                query.run(QueryStringBuilder.getStandingsForLeague(LeagueTabbedActivity.bundle.getString("id")), new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e)
                    {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                Toast.makeText(getContext(),"Bir hata oluştu",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException
                    {
                        String teamStandings=response.body().string();
                        teamList = JsonToObject.GetTeamsFromJson(teamStandings);
                        final StandingsAdapter adapter=new StandingsAdapter(getContext(),R.layout.standings_layout,R.id.lanetTextView, teamList, LeagueTabbedActivity.bundle.getString("LeagueAbrevation"));

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                Log.e("***","ADAPTER SET EDILDI");
                                standingsListView.setAdapter(adapter);
                                standingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                                    {
                                        Team league = teamList.get(position);
                                        Toast.makeText(getContext(), league.getTeamName(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                    }
                });

            }
            catch (Exception e)
            {
                Toast.makeText(getContext(),"Internet bağlantısı yok !",Toast.LENGTH_SHORT).show();
                Log.e("Internet yok, i think","Thats very sad for you");
                e.printStackTrace();
                return null;
            }

        }
        return rootView;
    }
}
