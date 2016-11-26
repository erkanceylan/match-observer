package com.erkanceylan.match_watcher_v_01.Utilities;


import android.util.Log;

import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Models.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ERKAN on 25.11.2016.
 */

public class JsonToObject
{

    /* Premier League, Championship, Bundesliga, Eredivise, League1, La Liga, Serie A */
    public static ArrayList<League> GetLeaguesFromJson(String json)
    {
        ArrayList<League> leagues=new ArrayList<League>();
        int id, numberOfTeams,currentMatchDay;
        String leagueName, leagueAbrevation;

        try
        {
            JSONArray leagueList = new JSONArray(json);
            Log.e("TOPLAM SAYISI: ",""+leagueList.length());
            for (int i=0; i<leagueList.length();i++)
            {
                Log.e("LİGLER DÖNÜLÜYOR","i: "+i);
                JSONObject leagueObject=leagueList.getJSONObject(i);
                id=leagueObject.getInt("id");
                numberOfTeams=leagueObject.getInt("numberOfTeams");
                currentMatchDay=leagueObject.getInt("currentMatchday");
                leagueName=leagueObject.getString("caption");
                leagueAbrevation=leagueObject.getString("league");

                int defaultLeagueLength=League.DefaultLeagues.length;
                Log.e("Default League Count",""+defaultLeagueLength);
                for (int j=0; j<defaultLeagueLength; j++)
                {
                    Log.e("IF: ",leagueAbrevation+"=="+League.DefaultLeagues[j]);
                    if(leagueAbrevation.equals(League.DefaultLeagues[j]))
                    {
                        Log.e("YENI LİG","adı:"+leagueName);
                        leagues.add(new League(id,numberOfTeams,leagueAbrevation,leagueName,currentMatchDay));
                        break;
                    }
                }
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        return leagues;
    }
}
