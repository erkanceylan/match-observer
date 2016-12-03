package com.erkanceylan.match_watcher_v_01.Models;

/**
 * Created by ERKAN on 7.11.2016.
 */

public class Team
{
    private int teamId; // {teamId}
    private String teamName; // Takım adı {team}
    private int playedGames; // Oynadığı maç sayısı {playedGames}
    private int points; // Topladığı puan sayısı {points}
    private int goals; // Attığı gol sayısı {goals}
    private int goalsAgainst; // Yediği gol sayısı {goalsAgainst}
    private int goalDifference; // Gol averajı {goalDifference}
    private String imageUri; //Resim url'si {crestURI}

    public int getTeamId()
    {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getPoints() {
        return points;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public String getImageUri() {
        return imageUri;
    }

    public Team(int teamId, String teamName, int playedGames, int points, int goalDifference, String imageUri )
    {
        this.teamId = teamId;
        this.teamName = teamName;
        this.playedGames = playedGames;
        this.points = points;
        this.goalDifference = goalDifference;
        this.imageUri=imageUri;
    }
    public Team(int teamId, String teamName, int playedGames, int points, int goals, int goalsAgainst, int goalDifference, String imageUri) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.playedGames = playedGames;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.imageUri = imageUri;
    }

}
