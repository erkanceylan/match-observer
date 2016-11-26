package com.erkanceylan.match_watcher_v_01.Models;

import com.erkanceylan.match_watcher_v_01.R;

import java.util.List;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class League
{
    public static String[] DefaultLeagues={"PL","ELC","BL1","DED","FL1","PPL","SA" };
    public static int getImage(String abr)
    {
        switch (abr)
        {
            case "PL":
                return R.drawable.pl;
            case "ELC":
                return R.drawable.elc;
            case "BL1":
                return R.drawable.bl1;
            case "DED":
                return R.drawable.ded;
            case "FL1":
                return R.drawable.fl1;
            case "SA":
                return R.drawable.sa;
            case "PPL":
                return R.drawable.ppl;
            default:
                return R.mipmap.ic_launcher;
        }
    }

    private int id; //{id}
    private int numberOfTeams; //Takım sayısı {numberOfTeams}
    private String leagueAbrevation; //Lig adı kısaltması {league}
    private String leagueName; //Lig adı {caption}
    private int currentMatchDay; //Maç günü(kaçıncı hafta) {numberOfMatchDay}

    private List<Team> standing;

    public League(int id, int numberOfTeams, String leagueAbrevation, String leagueName, int currentMatchDay)
    {
        this.id = id;
        this.numberOfTeams = numberOfTeams;
        this.leagueAbrevation = leagueAbrevation;
        this.leagueName = leagueName;
        this.currentMatchDay = currentMatchDay;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public String getLeagueAbrevation() {
        return leagueAbrevation;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public List<Team> getStanding() {
        return standing;
    }
}
