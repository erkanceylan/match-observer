package com.erkanceylan.match_watcher_v_01.Utilities;


import android.util.Log;

import com.erkanceylan.match_watcher_v_01.Models.Fixture;
import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Models.Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
    public static ArrayList<Team> GetTeamsFromJson(String json)
    {
        ArrayList<Team> teams=new ArrayList<Team>();
        int id, playedGames,points,goalDifference;
        String teamName, imageUri;

        try
        {
            JSONObject standingObject = new JSONObject(json);
            JSONArray standingsList = standingObject.getJSONArray("standing");
            Log.e("TOPLAM SAYISI: ","" + standingsList.length());
            for (int i=0; i<standingsList.length();i++)
            {
                Log.e("TAKIMLAR DÖNÜLÜYOR","i: "+i);
                JSONObject teamObject=standingsList.getJSONObject(i);
                id=teamObject.getInt("teamId");
                playedGames=teamObject.getInt("playedGames");
                points=teamObject.getInt("points");
                goalDifference=teamObject.getInt("goalDifference");
                teamName=teamObject.getString("team");
                imageUri=teamObject.getString("crestURI");

                Log.e("YENI TEAM","adı:"+teamName);
                teams.add(new Team(id,teamName,playedGames,points,goalDifference,imageUri));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        return teams;
    }

    public static ArrayList<Fixture> GetFixturesFromJson(String json)
    {

        ArrayList<Fixture> fixtures=new ArrayList<Fixture>();
        Date date;//Maç tarihi
        Fixture.matchStatus matchStatus; //Match Durumu
        String homeTeamName, awayTeamName;
        int goalsHomeTeam,goalsAwayTeam;


        try
        {
            JSONObject fixturesObject = new JSONObject(json);
            JSONArray fixtureList = fixturesObject.getJSONArray("fixtures");
            Log.e("TOPLAM SAYISI: ","" + fixtureList.length());
            for (int i=0; i<fixtureList.length();i++)
            {
                Log.e("TAKIMLAR DÖNÜLÜYOR","i: "+i);
                JSONObject fixtureObject=fixtureList.getJSONObject(i);

                //Sistem Zamanını alalım.
                Calendar cal = Calendar.getInstance();
                TimeZone tz = cal.getTimeZone();
                /* debug: is it local time? */
                Log.d("Time zone: ", tz.getDisplayName());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                sdf.setTimeZone(tz);

                date = sdf.parse(fixtureObject.getString("date"));

                String statusStr=fixtureObject.getString("status");
                switch (statusStr)
                {
                    case "FINISHED":
                        matchStatus = Fixture.matchStatus.FINISHED;
                        break;
                    case "SCHEDULED":
                        matchStatus = Fixture.matchStatus.SCHEDULED;
                        break;
                    case "TIMED":
                        matchStatus = Fixture.matchStatus.TIMED;
                        break;
                    default:
                        matchStatus = Fixture.matchStatus.FINISHED;

                }

                homeTeamName=fixtureObject.getString("homeTeamName");
                awayTeamName=fixtureObject.getString("awayTeamName");
                if(matchStatus == Fixture.matchStatus.FINISHED)
                {

                    JSONObject resultObject=fixtureObject.getJSONObject("result");
                    goalsHomeTeam=resultObject.getInt("goalsHomeTeam");
                    goalsAwayTeam=resultObject.getInt("goalsAwayTeam");

                    Log.e("YENI FIXTURE",": "+homeTeamName+" vs "+awayTeamName);
                    fixtures.add(new Fixture(date,matchStatus,homeTeamName,awayTeamName,goalsHomeTeam,goalsAwayTeam));
                }
             //   else
               //     fixtures.add(new Fixture(date,matchStatus,homeTeamName,awayTeamName,goalsHomeTeam,goalsAwayTeam));

            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return fixtures;
    }
}
