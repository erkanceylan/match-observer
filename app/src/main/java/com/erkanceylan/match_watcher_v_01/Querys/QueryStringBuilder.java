package com.erkanceylan.match_watcher_v_01.Querys;


/**
 * Created by ERKAN on 20.11.2016.
 */

public class QueryStringBuilder
{
    public static String getAllLeague()
    {
        return "/v1/competitions";
    }

    public static String getStandingsForLeague(String leagueId)
    {
        return "/v1/competitions/"+leagueId+"/leagueTable";
    }

    public static String getFixturesForLeagueAndWeek(String leagueId, int matchWeek)
    {
        return "/v1/competitions/"+leagueId+"/fixtures/?matchday="+matchWeek;
    }

    public static String getLastFixturesForLeagueAndWeek(String leagueId, int matchWeek)
    {
        return "/v1/competitions/"+leagueId+"/fixtures/?matchday="+(matchWeek-1);
    }

    public static String getFixture(String fixtureId)
    {
        return "/v1/fixtures/"+fixtureId;
    }

}
