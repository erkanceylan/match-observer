package com.erkanceylan.match_watcher_v_01.Models;

import android.util.Log;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class Head2Head
{
    private int count; // Toplam oynadıkları maç sayısı {head2head > count}

    private int homeTeamWins; //Ev sahibinin kazandığı maç sayısı{head2head > homeTeamWins}
    private int awayTeamWins; //Deplasman takımının kazandığı maç sayısı{head2head > awayTeamWins}
    private int draws; //Beraberlik sayısı {head2head > draws}

    private int totalHomeTeamsGoals;
    private int totalAwayTeamGoals;

    public int getCount() {
        return count;
    }

    public int getHomeTeamWins() {
        return homeTeamWins;
    }

    public int getAwayTeamWins() {
        return awayTeamWins;
    }

    public int getDraws() {
        return draws;
    }

    public int getTotalHomeTeamsGoals() {
        return totalHomeTeamsGoals;
    }

    public int getTotalAwayTeamGoals() {
        return totalAwayTeamGoals;
    }

    public Head2Head(int count, int homeTeamWins, int awayTeamWins, int draws, int totalHomeTeamsGoals, int totalAwayTeamGoals)
    {
        this.count = count;
        this.homeTeamWins = homeTeamWins;
        this.awayTeamWins = awayTeamWins;
        this.draws = draws;
        this.totalHomeTeamsGoals = totalHomeTeamsGoals;
        this.totalAwayTeamGoals = totalAwayTeamGoals;
    }

    public void Print()
    {
        Log.d("Head2Head"," Count: "+count+" HomeTeamWins: "+homeTeamWins+" AwayTeamwins: "+awayTeamWins+" Draws: "+draws+" AwayTeamGoals "+totalAwayTeamGoals+" HomeTeamGoals "+totalHomeTeamsGoals);
    }
}
