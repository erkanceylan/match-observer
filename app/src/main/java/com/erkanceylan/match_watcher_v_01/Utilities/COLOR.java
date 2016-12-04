package com.erkanceylan.match_watcher_v_01.Utilities;

import android.graphics.Color;

/**
 * Created by ERKAN on 26.11.2016.
 */

public class COLOR
{

    private static int ChampionsLeague=Color.rgb(1,52,107);
    private static int ChampionsLeagueQualification=Color.rgb(81,140,198);
    private static int UEFAEuropeLeague=Color.rgb(224, 155, 16);
    private static int UEFAEuropeLeagueQualification=Color.rgb(251, 203, 103);
    private static int LeagueDown=Color.rgb(213,0,0);
    private static int LeagueUp=Color.rgb(107, 127, 178);
    private static int PlayOff=Color.rgb(245, 127, 23);
    private static int PlayOut=Color.rgb(191, 54, 12);
    private static int NormalRank=Color.rgb(232, 232, 232);

    public static int getColor(String abr)
    {
        switch (abr)
        {
            case "PL":
                return Color.rgb(13,71,161);
            case "ELC":
                return Color.rgb(244,67,54);
            case "BL1":
                return Color.rgb(76,175,80);
            case "DED":
                return Color.rgb(255,87,34);
            case "FL1":
                return Color.rgb(96,125,139);
            case "SA":
                return Color.rgb(0,188,212);
            case "PPL":
                return Color.rgb(156,39,176);
            default:
                return Color.CYAN;
        }
    }

    public static int getRankColor(String abr, int position)
    {
        switch (abr)
        {
            case "PL":
                if(position<4)
                    return  COLOR.ChampionsLeague;
                else if(position==4)
                    return COLOR.ChampionsLeagueQualification;
                else if(position==5)
                    return COLOR.UEFAEuropeLeague;
                else if(position<18)
                    return COLOR.NormalRank;
                else
                    return COLOR.LeagueDown;
            case "ELC":
                if(position<3)
                    return COLOR.LeagueUp;
                else if(position<7)
                    return COLOR.PlayOff;
                else if (position<22)
                    return COLOR.NormalRank;
                else
                    return COLOR.LeagueDown;
            case "BL1":
                if(position<4)
                    return  COLOR.ChampionsLeague;
                else if(position==4)
                    return COLOR.ChampionsLeagueQualification;
                else if(position<7)
                    return COLOR.UEFAEuropeLeague;
                else if(position<16)
                    return COLOR.NormalRank;
                else if(position==16)
                    return COLOR.PlayOut;
                else
                    return COLOR.LeagueDown;
            case "DED":
                if(position==1)
                    return  COLOR.ChampionsLeague;
                else if(position==2)
                    return COLOR.ChampionsLeagueQualification;
                else if(position==3)
                    return COLOR.UEFAEuropeLeague;
                else if(position<8)
                    return COLOR.UEFAEuropeLeagueQualification;
                else if(position<16)
                    return COLOR.NormalRank;
                else if(position<18)
                    return COLOR.PlayOut;
                else if(position==18)
                    return COLOR.LeagueDown;
            case "FL1":
                if(position<3)
                    return  COLOR.ChampionsLeague;
                else if(position==3)
                    return COLOR.ChampionsLeagueQualification;
                else if(position==4)
                    return COLOR.UEFAEuropeLeague;
                else if(position<18)
                    return COLOR.NormalRank;
                else if(position==18)
                    return COLOR.PlayOut;
                else
                    return COLOR.LeagueDown;
            case "SA":
                if(position<3)
                    return  COLOR.ChampionsLeague;
                else if(position==3)
                    return COLOR.ChampionsLeagueQualification;
                else if(position<6)
                    return COLOR.UEFAEuropeLeagueQualification;
                else if(position<18)
                    return COLOR.NormalRank;
                else
                    return COLOR.LeagueDown;
            case "PD":
                if(position<4)
                    return  COLOR.ChampionsLeague;
                else if(position==4)
                    return COLOR.ChampionsLeagueQualification;
                else if(position<7)
                    return COLOR.UEFAEuropeLeague;
                else if(position<18)
                    return COLOR.NormalRank;
                else
                    return COLOR.LeagueDown;
            case "PPL":
                if(position<3)
                    return  COLOR.ChampionsLeague;
                else if(position==3)
                    return COLOR.ChampionsLeagueQualification;
                else if(position<6)
                    return COLOR.UEFAEuropeLeagueQualification;
                else if(position<17)
                    return COLOR.NormalRank;
                else
                    return COLOR.LeagueDown;
            default:
                return COLOR.NormalRank;
        }
    }
}
