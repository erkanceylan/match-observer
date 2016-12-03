package com.erkanceylan.match_watcher_v_01.Models;

import java.util.Date;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class Fixture
{
    public enum matchStatus{SCHEDULED, FINISHED, TIMED, IN_PLAY} //Oynanmadı(planda), Bitti, Bugun Oynanacak, Şuan Oynanıyor

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

    //Oynanmış maçların için fixture constructor'ı

    public Fixture(Date date, matchStatus status, String homeTeamName, String awayTeamName, int goalsHomeTeam, int goalsAwayTeam)
    {
        this.status = status;
        this.goalsAwayTeam = goalsAwayTeam;
        this.goalsHomeTeam = goalsHomeTeam;
        this.date = date;
        this.awayTeamName = awayTeamName;
        this.homeTeamName = homeTeamName;
    }


    //Analiz edilecek maçlar için fixture constructor'ı

    public Fixture(int matchId, int homeTeamId, int awayTeamId, String homeTeamName, String awayTeamName, int leagueId, int matchDay, Date date, matchStatus status, int goalsHomeTeam, int goalsAwayTeam, Head2Head head2head) {
        this.matchId = matchId;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.leagueId = leagueId;
        this.matchDay = matchDay;
        this.date = date;
        this.status = status;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        this.head2head = head2head;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public matchStatus getStatus() {
        return status;
    }

    public void setStatus(matchStatus status) {
        this.status = status;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public Head2Head getHead2head() {
        return head2head;
    }

    public void setHead2head(Head2Head head2head) {
        this.head2head = head2head;
    }
}
