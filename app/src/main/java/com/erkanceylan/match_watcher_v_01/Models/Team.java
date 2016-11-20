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

}
