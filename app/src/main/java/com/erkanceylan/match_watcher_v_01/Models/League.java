package com.erkanceylan.match_watcher_v_01.Models;

import java.util.List;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class League
{
    private int id; //{id}
    private int numberOfTeams; //Takım sayısı {numberOfTeams}
    private String leagueAbrevation; //Lig adı kısaltması {league}
    private String leagueName; //Lig adı {caption}
    private int numberOfMatchDay; //Maç günü(kaçıncı hafta) {numberOfMatchDay}

    private List<Team> standing;

    public League(int id, int numberOfTeams, String leagueAbrevation, String leagueName, int numberOfMatchDay)
    {
        this.id = id;
        this.numberOfTeams = numberOfTeams;
        this.leagueAbrevation = leagueAbrevation;
        this.leagueName = leagueName;
        this.numberOfMatchDay = numberOfMatchDay;
    }
}
