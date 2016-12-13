package com.erkanceylan.match_watcher_v_01.Utilities.Tahmin;

import android.util.Log;

import com.erkanceylan.match_watcher_v_01.Models.Fixture;

import java.util.Date;

/**
 * Created by ERKAN on 12.12.2016.
 */

public class TahministReyis
{
    private Fixture fixtureDetails;

    private int homeTeamPlayedGames;
    private int awayTeamPlayedGames;
    private int totalHomeGoalsOnLeague;
    private int totalAwayGoalsOnLeague;
    private int totalHomePointsOnLeague;
    private int totalAwayPointsOnLeague;

    public TahministReyis(Fixture fixtureDetails, int homeTeamPlayedGames, int awayTeamPlayedGames, int totalHomePointsOnLeague, int totalAwayPointsOnLeague, int totalHomeGoalsOnLeague, int totalAwayGoalsOnLeague)
    {
        this.fixtureDetails = fixtureDetails;
        this.homeTeamPlayedGames = homeTeamPlayedGames;
        this.awayTeamPlayedGames = awayTeamPlayedGames;
        this.totalHomeGoalsOnLeague = totalHomeGoalsOnLeague;
        this.totalAwayGoalsOnLeague = totalAwayGoalsOnLeague;
        this.totalHomePointsOnLeague = totalHomePointsOnLeague;
        this.totalAwayPointsOnLeague = totalAwayPointsOnLeague;
    }

    private double averageGoalsHomeTeam()
    {
        return (double)totalHomeGoalsOnLeague/homeTeamPlayedGames;
    }

    private double averageGoalsAwayTeam()
    {
        return (double)totalAwayGoalsOnLeague/awayTeamPlayedGames;
    }

    private double averagePointsHomeTeam()
    {
        return (double)totalHomePointsOnLeague/homeTeamPlayedGames;
    }

    private double averagePointsAwayTeam()
    {
        return (double)totalAwayPointsOnLeague/awayTeamPlayedGames;
    }
    public String getHomeTeamName()
    {
        return fixtureDetails.getHomeTeamName();
    }
    public String getAwayTeamName()
    {
        return fixtureDetails.getAwayTeamName();
    }
    public int getHomeTeamGoalsPredict()
    {
        //Sezonda maç başına attığı gol
        double avgGoalPerMatchInSeason=averageGoalsHomeTeam();
        //Sezonda maç başına aldığı puan
        double avgPointPerMatchInSeason=averagePointsHomeTeam();
        //Kendi aralarındaki galibiyet oranı
        double winRate=fixtureDetails.getHead2head().getHomeTeamWins()/fixtureDetails.getHead2head().getCount();
        //Kendi aralarında maç başına gol
        double goalRate=(double)fixtureDetails.getHead2head().getTotalHomeTeamsGoals()/fixtureDetails.getHead2head().getCount();

        Log.d("HOME TEAM PREDICT: "," avgGoalSeason: "+avgGoalPerMatchInSeason+" avgPoint: "+avgPointPerMatchInSeason+" winRate: "+winRate+" goalRate: "+goalRate);

        double predictGoal= ((avgGoalPerMatchInSeason*(0.5))*(avgPointPerMatchInSeason)+goalRate*(0.5)*(winRate));
        return (int)predictGoal;
    }
    public int getAwayTeamGoalsPredict()
    {
        //Sezonda maç başına attığı gol %20 etkili
        double avgGoalPerMatchInSeason=averageGoalsAwayTeam();
        //Sezonda maç başına aldığı puan
        double avgPointPerMatchInSeason=averagePointsAwayTeam();
        //Kendi aralarındaki galibiyet oranı
        double winRate=fixtureDetails.getHead2head().getAwayTeamWins();
        //Kendi aralarında maç başına gol
        double goalRate=(double)fixtureDetails.getHead2head().getTotalAwayTeamGoals()/fixtureDetails.getHead2head().getCount();
        Log.d("AWAY TEAM PREDICT: "," avgGoalSeason: "+avgGoalPerMatchInSeason+" avgPoint: "+avgPointPerMatchInSeason+" winRate: "+winRate+" goalRate: "+goalRate);
        double predictGoal= ((avgGoalPerMatchInSeason*(0.5))*(avgPointPerMatchInSeason)+goalRate*(0.5)*(winRate));
        return (int)predictGoal;
    }
    public Date getDate()
    {
        return fixtureDetails.getDate();
    }
    public void Print()
    {
        Log.d("TAHMİNİST REYİS",""+averageGoalsHomeTeam()+" | "+averageGoalsAwayTeam()+" | "+averagePointsHomeTeam()+" | "+averagePointsAwayTeam());
    }
}
