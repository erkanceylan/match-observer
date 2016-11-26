package com.erkanceylan.match_watcher_v_01.Models;

import java.util.Date;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class Fixture
{
    public enum matchStatus{SCHEDULED, FINISHED, TIMED} //Oynanmadı(planda), Bitti, Şuan Oynanıyor


    private int matchId; // {id}
    private int homeTeamId; // Ev Sahibi Takım Id {homeTeamId}
    private int awayTeamId; // Deplasman Takım Id {awayTeamId}
    private String homeTeamName; // Ev Sahibi {homeTeamName}
    private String awayTeamName; // Deplasman {awayTeamName}
    private int leagueId; //Lig Id {competitionId}
    private int matchDay; //Kaçıncı hafta {matchday}
    private Date date; //Maç tarihi(saat dahil) {date}
    private matchStatus status; // Maç durumu {status}
    private int goalsHomeTeam; // Ev sahibi gol sayısı {goalsHomeTeam}
    private int goalsAwayTeam; // Deplasman gol sayısı {goalsAwayTeam}

    //Önceki karşılaşmaları
    private Head2Head head2head; // Önceki karşılaşma istatistikleri {head2head]
}
