package com.erkanceylan.match_watcher_v_01.Querys;


import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class QueryBuilder
{
    private Query query;
    public String getAllLeague()
    {
        return query.GET("/v1/competitions");
    }

    public String getStandingsForLeague(String leagueId) throws IOException
    {
        return query.GET("/v1/competitions/"+leagueId+"/leagueTable");
    }

    public String getFixturesForLeagueAndWeek(String leagueId, String matchWeek) throws IOException
    {
        return query.GET("/v1/competitions/"+leagueId+"/fixtures/?matchday="+matchWeek);
    }

    public String getFixture(String fixtureId) throws IOException
    {
        return query.GET("/v1/fixtures/"+fixtureId);
    }

}
