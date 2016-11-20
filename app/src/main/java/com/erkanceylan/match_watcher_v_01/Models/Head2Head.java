package com.erkanceylan.match_watcher_v_01.Models;

/**
 * Created by ERKAN on 20.11.2016.
 */

public class Head2Head
{
    private int fixtureId; // {fixture > id}
    private int count; // Toplam oynadıkları maç sayısı {head2head > count}

    private int homeTeamId; //Ev sahibi takım id {fixture > homeTeamId}
    private int awayTeamId; //Deplasman takım id {fixture > awayTeamId}
    private int homeTeamWins; //Ev sahibinin kazandığı maç sayısı{head2head > homeTeamWins}
    private int awayTeamWins; //Deplasman takımının kazandığı maç sayısı{head2head > awayTeamWins}
    private int draws; //Beraberlik sayısı {head2head > draws}

    private Fixture lastHomeWinHomeTeam; // Ev sahibinin 'evinde' son kazandığı maç{head2head > lastHomeWinHomeTeam}
    private Fixture lastWinHomeTeam; // Ev sahibinin son kazandığı maç {head2head > lastWinHomeTeam}
    private Fixture lastAwatWinAwayTeam; // Deplasman takımının 'deplasmanda' son kazandığı maç {head2head > lastAwayWinAwayTeam}
    private Fixture lastWinAwayTeam; // Deplasman takımının son kazandığı maç {head2head > lastWinAwayTeam}
}
