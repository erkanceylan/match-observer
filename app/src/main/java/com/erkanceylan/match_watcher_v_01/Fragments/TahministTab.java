package com.erkanceylan.match_watcher_v_01.Fragments;

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

import com.erkanceylan.match_watcher_v_01.Adapters.MatchResultsAdapter;
import com.erkanceylan.match_watcher_v_01.Adapters.TahministAdapter;
import com.erkanceylan.match_watcher_v_01.LeagueTabbedActivity;
import com.erkanceylan.match_watcher_v_01.Models.Fixture;
import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Querys.QueryCreator;
import com.erkanceylan.match_watcher_v_01.Querys.QueryStringBuilder;
import com.erkanceylan.match_watcher_v_01.R;
import com.erkanceylan.match_watcher_v_01.Utilities.JsonToObject;
import com.erkanceylan.match_watcher_v_01.Utilities.Tahmin.TahministReyis;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ERKAN on 1.12.2016.
 */

public class TahministTab extends Fragment
{
    private ArrayList<Integer> idList;
    private ArrayList<TahministReyis> fixtureList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Önce viewler'i elde edelim.
        View rootView = inflater.inflate(R.layout.fragment_tahminist, container, false);
        final ListView standingsListView=(ListView)rootView.findViewById(R.id.tahministListView);
        ImageView leagueImage=(ImageView)rootView.findViewById(R.id.tahministLeagueImage);
        TextView leagueNameText=(TextView)rootView.findViewById(R.id.tahministLeagueName);

        final StandingsTab standingsFragment=(StandingsTab) getActivity().getSupportFragmentManager().getFragments().get(1);
        //Sonra sorgu yapalım.
        if(fixtureList==null)
        {
            //lig resmi ve adını set edelim.
            leagueImage.setImageResource(League.getImage(LeagueTabbedActivity.bundle.getString("LeagueAbrevation")));
            leagueNameText.setText(LeagueTabbedActivity.bundle.getString("LeagueName"));
            try
            {
                QueryCreator query=new QueryCreator();
                query.run(QueryStringBuilder.getFixturesForLeagueAndWeek(LeagueTabbedActivity.bundle.getString("id"),LeagueTabbedActivity.bundle.getInt("currentMatchday")), new Callback() {
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
                        String fixturesJson=response.body().string();
                        idList = JsonToObject.GetFixtureIdsFromJson(fixturesJson);
                        fixtureList=new ArrayList<TahministReyis>();
                        QueryCreator myQuery = new QueryCreator();
                        for (int i=0;i<idList.size();i++)
                        {
                            final int id=idList.get(i);
                            try {
                                final int finalI = i;
                                myQuery.run(QueryStringBuilder.getFixture(Integer.toString(id)), new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run()
                                            {
                                                Toast.makeText(getContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }


                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException
                                    {
                                        String jsonStr=response.body().string();
                                        Log.d("JSON:"+ id, jsonStr);
                                        Fixture fxt=(JsonToObject.GetFixtureWithHead2HeadFromJson(jsonStr));

                                        TahministReyis reyis=new TahministReyis(fxt,standingsFragment.getTeamById(fxt.getHomeTeamId()).getPlayedGames(),standingsFragment.getTeamById(fxt.getAwayTeamId()).getPlayedGames(),standingsFragment.getTeamById(fxt.getHomeTeamId()).getPoints(),standingsFragment.getTeamById(fxt.getAwayTeamId()).getPoints(),standingsFragment.getTeamById(fxt.getHomeTeamId()).getGoals(),standingsFragment.getTeamById(fxt.getAwayTeamId()).getGoals());
                                        reyis.Print();
                                        if(reyis!=null)
                                            fixtureList.add(reyis);
                                        if((finalI +1)==idList.size())
                                        {
                                            final TahministAdapter adapter = new TahministAdapter(getContext(), R.layout.fragment_tahminist, R.id.lanetTextView3, fixtureList);

                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("***", "ADAPTER SET EDILDI");
                                                    standingsListView.setAdapter(adapter);
                                                    standingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                            TahministReyis fixture = fixtureList.get(position);
                                                            Toast.makeText(getContext(), fixture.getHomeTeamName() + " vs " + fixture.getAwayTeamName(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    }
                                });

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
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
